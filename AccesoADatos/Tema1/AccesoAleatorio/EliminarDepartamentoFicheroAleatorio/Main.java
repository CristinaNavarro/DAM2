/*
********Autor: Cristina Navarro*********************
********Fecha: 09/10/2017***************************
********Asignatura:Acceso a Datos ******************
********Ejercicio:	 Eliminación datos de fichero***
*********  con acceso aleatorio*********************
*/

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentoAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f,"rw");
        System.out.println("Introduce el codigo del departamento a eliminar");
        int registro = sc.nextInt();
        int posicion = (registro * 48) - 4;
        if(posicion>raf.length()){
            System.out.println("Ese departamento no existe");
        }else{
            try {
                raf.seek(posicion);
                raf.writeInt(1);
            }catch (EOFException e){
                System.out.println("Se ha salido del archivo");
                System.out.println(e.getMessage());
            }
        }
    }
}
