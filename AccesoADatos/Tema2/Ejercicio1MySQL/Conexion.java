import java.sql.*;

class Conexion {
    private Connection conexion;

    //Conexión a la base de datos
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
            String query = "SELECT * FROM ejercicio1";
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

}
