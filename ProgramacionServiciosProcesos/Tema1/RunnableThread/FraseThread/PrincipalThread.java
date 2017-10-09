/*
********Autor: Cristina Navarro*********************
********Fecha: 23/09/2017***************************
********Asignatura:ProgramacionServiciosYProcesos***
********Ejercicio: Crear tres hilos en el que ******
******** cada uno escriba durante su ejecución el **
******** siguiente mensaje, donde el color sea *****
******** introducido por teclado antes de la *******
******** ejecución del hilo*************************
*/


import java.util.Scanner;

public class PrincipalThread {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++) {
            System.out.println("Color:");
            Hilo h = new Hilo(sc.nextLine());
            h.start();
            h.join();
        }

    }
}
