/*
********Autor: Cristina Navarro*********************************
********Fecha: 23/09/2017***************************************
********Asignatura:ProgramacionServiciosYProcesos***************
********Ejercicio: Crear dos hilos en el que cada uno de *******
******* ellos escriba una serie de números desde el 0 al 499, **
******* también deberá mostrar el identificador del hilo. Cada *
******* hilo deberá esperar 500 milisegundos entre número y ****
******* número escrito.*****************************************
*/


public class PrincipalThread {
    public static void main(String[] args) {
        new Hilo("Primero");
        new Hilo("Segundo");
    }
}
