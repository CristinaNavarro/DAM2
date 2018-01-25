/*
        ********Autor: Cristina Navarro
        ********Fecha: 1/12/2017
        ********Asignatura: Acceso a Datos
        ********Ejercicio:EXAMEN ACDA.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Modelo {

    private Connection conexionMySQL;


    Modelo(Config config) {
        conectarBBDDMySQL(config);
        modificarObservacion();
        creacionFichero(config);
        cerrarConexionMySQL();
    }

    //Cerrar conexión mysql
    private void cerrarConexionMySQL() {
        try {
            conexionMySQL.close();
            System.out.println("Base de datos MySQL cerrada.");
        } catch (SQLException e) {
            System.out.println("Fallo al cerrar la conexión.");
        }
    }

    //establecer conexión mysql
    private void conectarBBDDMySQL(Config config) {
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

    //modificación observación alumnos SIGE con una nota menor o igual a 9
    private void modificarObservacion() {
        String query = "UPDATE calificaciones SET nota = nota+1, observaciones = 'DONACIÓN SANGRE +1' WHERE nota <= 9 AND `cod_asig` =" +
                " (SELECT `cod_asignatura` FROM asignaturas WHERE `nombre_asignatura` = 'SIGE');";
        try {
            Statement statement = conexionMySQL.createStatement();
            statement.executeUpdate(query);
            String queryResultado = "SELECT * FROM calificaciones  WHERE nota <= 9 AND `cod_asig` =" +
                    " (SELECT `cod_asignatura` FROM asignaturas WHERE `nombre_asignatura` = 'SIGE');";
            Statement statementResultado = conexionMySQL.createStatement();
            statementResultado.execute(queryResultado);
            ResultSet rs = statementResultado.getResultSet();
            System.out.println("Registros actualizados: \ncog_asig cod_alumno nota observaciones");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t\t  " + rs.getString(2) + "\t\t\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
            System.out.println("\n\n");
            rs.close();
            statementResultado.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //creación fichero felicitaciones.txt
    private void creacionFichero(Config config) {
        try {
            File file = new File(config.getPATH());
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            String query = "SELECT nombre_alumno, nombre_asignatura, nota, observaciones FROM alumnos, asignaturas, " +
                    " calificaciones WHERE alumnos.cod_alumno = calificaciones.cod_alumno AND" +
                    " asignaturas.cod_asignatura = calificaciones.cod_asig AND observaciones = 'SE LE FELICITA';";
            Statement statement = conexionMySQL.createStatement();

            if (statement.execute(query)) {
                ResultSet resultSet = statement.getResultSet();
                resultSet.last();
                System.out.println("Número de resultados de la consulta " + query + " \nes: " + resultSet.getRow() + "\n\n");
                resultSet.beforeFirst();
                printWriter.println("NOMBRE_ALUMNO " + "NOMBRE_ASIGNATURA " + "NOTA " + "OBSERVACIÓN");
                System.out.println("Datos a escribir en el fichero:\nNOMBRE_ALUMNO " + "NOMBRE_ASIGNATURA " + "NOTA " + "OBSERVACIÓN");
                while (resultSet.next()) {
                    printWriter.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
                }
                resultSet.close();
                System.out.println("Archivo creado y escrito con éxito en " + config.getPATH());
            }
            statement.close();
            printWriter.close();
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException" + e.getMessage());
            e.printStackTrace();
        }
    }


}
