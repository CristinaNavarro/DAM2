/*
        ********Autor: Cristina Navarro
        ********Fecha: 1/12/2017
        ********Asignatura: Acceso a Datos
        ********Ejercicio:EXAMEN ACDA.
*/

public class Config {

    //Datos configuración conexión MySQL
    private final String BBDD = "jdbc:mysql://localhost/pevalacda";
    private final String SSLFALSE = "?useSSL=false";
    private final String USER = "root";
    private final String PASS = ""; //Modificar según contraseña del usuario


    //Datos fichero .txt
    private final String PATH = "D://PEVALACDA//felicitaciones.txt"; //cambiar según la raíz

    //Getters
    String getBBDD() {
        return BBDD;
    }

    String getSSLFALSE() {
        return SSLFALSE;
    }

    String getUSER() {
        return USER;
    }

    String getPASS() {
        return PASS;
    }

    String getPATH() {
        return PATH;
    }

}
