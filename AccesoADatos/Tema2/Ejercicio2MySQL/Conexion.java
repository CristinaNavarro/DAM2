import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class Conexion {
    private Connection conexion;
    private ArrayList<Integer> listEmpNo = new ArrayList<>();
    private ArrayList<Integer> listDeptNo = new ArrayList<>();
    Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Config config = new Config();
            conexion = DriverManager.getConnection(config.getBBDD() + config.getSSLFALSE(), config.getUSER(), config.getPASS());
            System.out.println("Conexión con BBDD correcta.\n");
        }catch (SQLException e) {
            System.out.println("Problema al conectar");
        }catch (ClassNotFoundException e){
            System.out.println("No se encuentra la clase");
        }
    }


    void visualizar() {
        System.out.println("Todos los resultados de la tabla: ");
        try {
            String query = "SELECT * FROM ejercicio2empleados";
            Statement statement = conexion.createStatement();
            boolean existeRegistro = statement.execute(query);
            if(existeRegistro) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.printf("%-10s\t%d\t%d\t%n",rs.getString(1),rs.getInt(2),rs.getInt(3));
                }
                rs.close();
            }
            statement.close();
            conexion.close();
        }catch (SQLException e) {
            System.out.println("Fallo al visualizar.");
        }
    }

    void listarEmpleados() {
        String query = "SELECT emp_no FROM ejercicio2empleados";
        try {
            Statement statement = conexion.createStatement();
            boolean existeRegistro = statement.execute(query);
            if(existeRegistro) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    listEmpNo.add(rs.getInt("emp_no"));
                }
            }
        }catch (SQLException e) {
            System.out.println("Fallo al listar empleados");
        }
    }

    void listarDepartamentos() {
        String query = "SELECT dept_no FROM ejercicio2departamentos";
        try {
            Statement statement = conexion.createStatement();
            boolean existeRegistro = statement.execute(query);
            if(existeRegistro) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    listDeptNo.add(rs.getInt("dept_no"));
                }
            }
        }catch (SQLException e) {
            System.out.println("Fallo al listar departamentos");
        }
    }


    void insertar() {
        Scanner sc = new Scanner(System.in);
        //String patron = "[0-9]+";
        boolean valido = true;
        String errores = "Errores: ";
        int emp_no;
        String apellido;
        String profesion;
        int director;
        int salario;
        int comision;
        int dept_no;
        System.out.print("Introduce el número de empleado: ");
        emp_no = sc.nextInt();
        if(listEmpNo.contains(emp_no)){
            valido = false;
            errores += "\nYa existe un empleado con ese número.";
        }
        System.out.print("\nIntroduce el apellido: ");
        apellido = sc.next();
        System.out.print("\nIntroduce la profesión: ");
        profesion = sc.next();
        System.out.print("\nIntroduce el número del director: ");
        director = sc.nextInt();
        if(!listEmpNo.contains(director)) {
            valido = false;
            errores += "\nNo existe un empleado con ese número.";
        }
        System.out.print("\nIntroduce el salario: ");
        salario = sc.nextInt();
        if(salario<=0) {
            valido = false;
            errores += "\nNo se puede introducir un salario igual o menor a 0.";
        }
        System.out.print("\nIntroduce la comisión: ");
        comision = sc.nextInt();
        System.out.print("\nIntroduce el número de departamento: ");
        dept_no = sc.nextInt();
        if(!listDeptNo.contains(dept_no)) {
            valido = false;
            errores += "\nEse departamento no existe";
        }

        if(valido) {
            String query = "INSERT INTO ejercicio2empleados VALUES (?,?,?,?,?,?,?);";
            try {
                PreparedStatement preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setInt(1,emp_no);
                preparedStatement.setString(2,apellido);
                preparedStatement.setString(3,profesion);
                preparedStatement.setInt(4,director);
                preparedStatement.setInt(5,salario);
                preparedStatement.setInt(6,comision);
                preparedStatement.setInt(7,dept_no);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Fallo al insertar.");
            }
        } else {
            System.out.println("No se ha podido insertar.");
            System.out.println(errores);
        }

    }

    void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conexión.");
        }
    }

}
