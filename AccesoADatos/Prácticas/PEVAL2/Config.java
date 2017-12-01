/*
        ********Autor: Cristina Navarro
        ********Fecha: 24/11/2017
        ********Asignatura: Acceso a Datos
        ********Ejercicio:Manejo de conectores.
*/

public class Config {

    //Datos configuración conexión MySQL
    private final String BBDD = "jdbc:mysql://localhost/denuncias";
    private final String SSLFALSE = "?useSSL=false";
    private final String SERVERPREPAREDSTATEMENT = "?useServerPrepStmts=true";
    private final String USER = "root";
    private final String PASS = "pass"; //Modificar según contraseña del usuario

    //Datos configuración conexión SQLite (modificar para diferente localización de la base de datos)
    private final String localizacion = "jdbc:sqlite:multas.db";

    String getBBDD() {
        return BBDD;
    }

    String getSSLFALSE() {
        return SSLFALSE;
    }

    String getSERVERPREPAREDSTATEMENT() {
        return SERVERPREPAREDSTATEMENT;
    }

    String getUSER() {
        return USER;
    }

    String getPASS() {
        return PASS;
    }

    String getLocalizacion() {
        return localizacion;
    }

}
