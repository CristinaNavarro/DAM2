import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class Conexion {
    private Connection conexion;

    Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Config config = new Config();
            conexion = DriverManager.getConnection(config.getBBDD() + config.getSSLFALSE(), config.getUSER(), config.getPASS());
            System.out.println("Conexión con BBDD correcta.\n");
        } catch (SQLException e) {
            System.out.println("Problema al conectar");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase");
        }
    }


    void insertarClientes() {
        Datos datos = new Datos();
        datos.crearDatos();
        String query = "INSERT INTO clientes VALUES (?,?,?,?,?,?);";
        for (int i = 0; i < datos.getListaDatos().size() - 3; i++) {
            try {
                PreparedStatement preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(datos.listaDatos.get(i)[0]));
                preparedStatement.setString(2, datos.listaDatos.get(i)[1]);
                preparedStatement.setString(3, datos.listaDatos.get(i)[2]);
                preparedStatement.setString(4, datos.listaDatos.get(i)[3]);
                preparedStatement.setString(5, datos.listaDatos.get(i)[4]);
                preparedStatement.setString(6, datos.listaDatos.get(i)[5]);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Fallo al insertar cliente.");
            }
        }
    }

    void insertarProductos() {
        Datos datos = new Datos();
        datos.crearDatos();
        String query = "INSERT INTO productos VALUES (?,?,?,?,?);";
        for (int i = datos.getListaDatos().size() - 3; i < datos.getListaDatos().size(); i++) {
            try {
                PreparedStatement preparedStatement = conexion.prepareStatement(query);
                preparedStatement.setInt(1, Integer.parseInt(datos.listaDatos.get(i)[0]));
                preparedStatement.setString(2, datos.listaDatos.get(i)[1]);
                preparedStatement.setInt(3, Integer.parseInt(datos.listaDatos.get(i)[2]));
                preparedStatement.setInt(4, Integer.parseInt(datos.listaDatos.get(i)[3]));
                preparedStatement.setInt(5, Integer.parseInt(datos.listaDatos.get(i)[4]));
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("Fallo al insertar producto.");
            }
        }
    }

    void visualizarCliente() {
        System.out.println("Todos los resultados de la tabla cliente: ");
        try {
            String query = "SELECT * FROM clientes";
            Statement statement = conexion.createStatement();
            boolean existeRegistro = statement.execute(query);
            if (existeRegistro) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%n", rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fallo al visualizar.");
            System.out.println(e.getMessage());
        }
    }
    void visualizarProducto() {
        System.out.println("Todos los resultados de la tabla producto: ");
        try {
            String query = "SELECT * FROM productos";
            Statement statement = conexion.createStatement();
            boolean existeRegistro = statement.execute(query);
            if (existeRegistro) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.printf("%d\t%s\t%d\t%d\t%d\t%n", rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4),rs.getInt(5));
                }
                rs.close();
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Fallo al visualizar.");
            System.out.println(e.getMessage());
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
