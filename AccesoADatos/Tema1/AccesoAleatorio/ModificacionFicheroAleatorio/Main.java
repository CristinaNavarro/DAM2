/*
********Autor: Cristina Navarro*********************
********Fecha: 09/10/2017***************************
********Asignatura:Acceso a Datos*******************
********Ejercicio:	 Modificación de fichero con****
********* acceso aleatorio**************************
*/

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentoAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f,"rw");
        System.out.println("Introduce el codigo del departamento a modificar");
        int registro = sc.nextInt();
        int posicion = (registro-1)*44;
        if(posicion>raf.length()){
            System.out.println("Ese departamento no existe");
        }else{
            raf.seek(posicion+4);
            System.out.println("Introduce el nuevo nombre");
            StringBuffer sbNombre = new StringBuffer(sc.next());
            sbNombre.setLength(10);
            raf.writeChars(sbNombre.toString());
            System.out.println("Introduce el nuevo lugar");
            StringBuffer sbLugar = new StringBuffer(sc.next());
            sbLugar.setLength(10);
            raf.writeChars(sbLugar.toString());
            raf.close();
        }

    }
}
