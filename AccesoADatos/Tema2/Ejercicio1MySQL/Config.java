class Config { //Clase que contiene todos los datos de conexión

    private final String BBDD = "jdbc:mysql://localhost/ejerciciosacda";
    private final String SSLFALSE = "?useSSL=false";
    //El certificado SSL permite encriptar la información, en estos ejercicios no se activará
    private final String SERVERPREPAREDSTATEMENT = "?useServerPrepStmts=true";
    //PreparedStatement tiene dos funciones, una de seguridad (permite al usuario introducir por ejemplo ' en un nombre)
    //y otra de rendimiento, ya que le indica a la base de datos el tipo de dato a insertar
    private final String USER = "root";
    private final String PASS = "pass";

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

}
