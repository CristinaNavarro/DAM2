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

public class PrincipalRunnable {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++) {
            System.out.println("Introduce nombre: ");
            String color = sc.nextLine();
            Thread h = new Thread(new Hilo(color));
            h.start();
            h.join();
        }
    }
}

//como se puenden comunicar entre si las tareas si cada una se crea dentro de un Runnable y no la podemos controlar
//desde el main, si una tarea requiere que otra haya terminado de ejecutar X accion
