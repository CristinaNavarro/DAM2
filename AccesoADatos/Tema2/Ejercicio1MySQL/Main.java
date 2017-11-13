/*
********Autor: Cristina Navarro
********Fecha: 12/11/2017
********Asignatura: Acceso a Datos
********Ejercicio:⦁	Crea una base de datos en MySQL
******** con tres campos, introducir cinco registros
******** y crear una aplicación java mediante JDBC que
******** recorra todos sus registros visualizando su contenido.
*/



public class Main {

    public static void main(String[] args)  {
        Conexion conexion = new Conexion();
        conexion.visualizar();
    }
}
