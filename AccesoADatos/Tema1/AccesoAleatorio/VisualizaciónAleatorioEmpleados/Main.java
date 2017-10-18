import java.io.*;
import java.util.Scanner;

/*
********Autor: Cristina Navarro*********************
********Fecha: 16/10/2017***************************
********Asignatura:Acceso a Datos ******************
********Ejercicio:	 Visualización de empleado******
*/

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f,"r");
        System.out.println("Introduzca el empleado a visualizar");
        int registro = sc.nextInt();
        int posicion = (registro-1)*32;
        //lectura de fichero ///////////////////////////////
        try {
            raf.seek(posicion+28);
            if(raf.readInt() == 0) {
                raf.seek(posicion);
                char[] apellidos = new char[10];
                System.out.print(raf.readInt());
                for (int j = 0; j < 10; j++) {
                    apellidos[j] = raf.readChar();
                    System.out.print(apellidos[j]);
                }
                System.out.print(raf.readInt() + " ");
                System.out.println(raf.readInt());
                System.out.println();
            }

        }catch (EOFException e){
            System.out.println("Saliendo");
        }
        ///////////////////////////////////////////////////
        raf.close();
    }
}
