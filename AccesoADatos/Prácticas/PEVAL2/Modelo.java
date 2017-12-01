/*
        ********Autor: Cristina Navarro
        ********Fecha: 24/11/2017
        ********Asignatura: Acceso a Datos
        ********Ejercicio:Manejo de conectores.
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Modelo {

    private Connection conexionMySQL;
    private Connection conexionSQLite;
    private ArrayList<Integer> listaBorrado = new ArrayList<>();

    Modelo(Config config) {
        conectarBBDDMySQL(config);

    }

    public String consultaPorDNI() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el DNI:");
            String dni = sc.nextLine();
            String vehiculo = "noexiste";
            Statement st = conexionMySQL.createStatement();
            boolean existenRegistros = st.execute("SELECT dni, vehiculo, denuncia, nombre, fecha_denuncia, importe FROM multas, coches, usuarios WHERE vehiculo = matricula AND propietario = dni AND propietario = '" + dni + "';");
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    String query = "INSERT INTO multi_detalle(dni,coche,denuncia,nombre,fecha_denuncia,importe) VALUES(?,?,?,?,?,?);";
                    PreparedStatement preparedStatement = conexionSQLite.prepareStatement(query);
                    preparedStatement.setString(1, rs.getString(1));
                    preparedStatement.setString(2, rs.getString(2));
                    preparedStatement.setInt(3, rs.getInt(3));
                    preparedStatement.setString(4, rs.getString(4));
                    preparedStatement.setString(5, rs.getString(5));
                    preparedStatement.setInt(6, rs.getInt(6));
                    vehiculo = rs.getString(2);
                    preparedStatement.executeUpdate();
                }
                rs.close();
                cerrarConexionMySQL();
            } else {
                System.out.println("USUARIO NO EXISTE O NO POSEE MULTAS");
                dni = "noexiste";
            }
            st.close();
            return vehiculo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "noexiste";
    }

    public int mostrarContenidoTablaSQLite() {
        int numeroRegistros = 0;
        try {
            int sumaMultas = 0;
            Statement st = conexionSQLite.createStatement();
            String query = "SELECT * FROM multi_detalle;";
            st.execute(query);
            ResultSet rs = st.getResultSet();
            if (rs.next()) {
                System.out.println("Resultado tabla SQLite:");
                System.out.println(rs.getString(1) + " -> " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getInt(6));
                sumaMultas += rs.getInt(6);
                numeroRegistros++;
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " -> " + rs.getString(2) + "  " + rs.getInt(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getInt(6));
                    sumaMultas += rs.getInt(6);
                    numeroRegistros++;
                }
                System.out.println("Total precio multas: " + sumaMultas);
                rs.close();
                st.close();
            }
            return numeroRegistros;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void opcionBorrado() {  //Controlar introducción letras
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de denuncia: ");
        try {
            int numeroDenunciaEliminar = sc.nextInt();
            String query = "DELETE FROM multi_detalle WHERE denuncia = " + numeroDenunciaEliminar + ";";
            Statement stComprobacion = conexionSQLite.createStatement();
            stComprobacion.execute("SELECT * FROM multi_detalle WHERE denuncia = " + numeroDenunciaEliminar);
            ResultSet rs = stComprobacion.getResultSet();
            if (rs.next()) {
                Statement stBorrado = conexionSQLite.createStatement();
                stBorrado.execute(query);
                stBorrado.executeUpdate(query);
                listaBorrado.add(numeroDenunciaEliminar);
                System.out.println("---Denuncia eliminada---");
                stBorrado.close();
            } else {
                System.out.println("---La denuncia no existe o ha sido anulada---");
            }
            rs.close();
            stComprobacion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("Ha introducido un carácter no permitido.");
        }
    }

    public void borrarDatosSQLite() {
        String query = "DELETE FROM multi_detalle";
        Statement stBorrado = null;
        try {
            stBorrado = conexionSQLite.createStatement();
            stBorrado.execute(query);
            stBorrado.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cerrarConexionSQLite();
        System.out.println("Saliendo...");
    }


    void actualizarTablaMySQL() {
        try {
            System.out.println("Se eliminará de la base de datos MySQL: ");
            //Comparación y borrado
            for (int i : listaBorrado) {
                Statement stBorrado = conexionMySQL.createStatement();
                String queryBorrado = "DELETE FROM multas WHERE denuncia = " + i;
                stBorrado.execute(queryBorrado);
                System.out.println(queryBorrado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS multi_detalle (\n"
                + "	dni varchar(9) NOT NULL,\n"
                + "	coche varchar(7) NOT NULL,\n"
                + "	denuncia tinyint NOT NULL,\n"
                + "	nombre varchar(40),\n"
                + "	fecha_denuncia date,\n"
                + "	importe tinyint,\n"
                + " PRIMARY KEY (dni, coche, denuncia)"
                + ");";

        try {
            Statement st = conexionSQLite.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void cerrarConexionAmbas() {
        try {
            conexionMySQL.close();
            conexionSQLite.close();
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conexión.");
        }
    }

    void cerrarConexionMySQL() {
        try {
            conexionMySQL.close();
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conexión.");
        }
    }

    void cerrarConexionSQLite() {
        try {
            conexionSQLite.close();
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conexión.");
        }
    }

    void conectarBBDDMySQL(Config config) {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conexionMySQL = DriverManager.getConnection(config.getBBDD() + config.getSSLFALSE(), config.getUSER(), config.getPASS());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Conexión con BBDD MySQL correcta.\n");
    }

    public void conectarBBDDSQLite(Config config) {
        try {
            conexionSQLite = DriverManager.getConnection(config.getLocalizacion());
            crearTabla();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Conexión con BBDD SQLite correcta.\n");
    }
}
