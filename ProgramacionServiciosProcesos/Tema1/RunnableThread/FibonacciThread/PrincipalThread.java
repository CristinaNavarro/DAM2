/*
********Autor: Cristina Navarro*********************************
********Fecha: 23/09/2017***************************************
********Asignatura:ProgramacionServiciosYProcesos***************
********Ejercicio:	Crear un hilo que calcule la serie *********
******** fibonacci de un número introducido por teclado. *******
******** (1,1,2,3,5,8,13,...)***********************************
*/


public class PrincipalThread {
    public static void main(String[] args) {
        Hilo h = new Hilo();
        h.start();
    }
}
