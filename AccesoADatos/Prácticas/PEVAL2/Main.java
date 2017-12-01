/*
        ********Autor: Cristina Navarro
        ********Fecha: 24/11/2017
        ********Asignatura: Acceso a Datos
        ********Ejercicio:Manejo de conectores.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Config config = new Config();
        Modelo modelo = new Modelo(config); //abro mysql
        String respuestaAnulacion = "";
        modelo.conectarBBDDSQLite(config);
        //Conexión del usuario al sistema
        String vehiculo =  modelo.consultaPorDNI();//cierro mysql
        int registrosRestantes = modelo.mostrarContenidoTablaSQLite(); //se muestran los datos si existen
        if(!vehiculo.equals("noexiste") && registrosRestantes > 0) {
            while (!respuestaAnulacion.equals("N") && registrosRestantes != 0) {
                    System.out.println("¿Desea anular una denuncia? (Y/N) ");
                    respuestaAnulacion = sc.nextLine();
                switch (respuestaAnulacion) {
                    case "Y":
                        registrosRestantes = modelo.mostrarContenidoTablaSQLite();
                        if(registrosRestantes != 0) {
                            modelo.opcionBorrado();
                        }
                        break;
                    case "N":
                        break;
                    default:
                        System.out.println("Introduzca 'Y' o 'N'.");
                        break;
                }
            }
            if (registrosRestantes == 0) {
                System.out.println("No quedaban registros de multas para este dni.");
            }
            modelo.borrarDatosSQLite();
            modelo.cerrarConexionSQLite();
            modelo.conectarBBDDMySQL(config);
            modelo.actualizarTablaMySQL();
        }
        modelo.cerrarConexionMySQL();
    }
}
