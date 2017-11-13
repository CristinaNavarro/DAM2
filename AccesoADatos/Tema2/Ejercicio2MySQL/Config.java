class Config {

    private final String BBDD = "jdbc:mysql://localhost/ejerciciosacda";
    private final String SSLFALSE = "?useSSL=false";
    private final String SERVERPREPAREDSTATEMENT = "?useServerPrepStmts=true";
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
