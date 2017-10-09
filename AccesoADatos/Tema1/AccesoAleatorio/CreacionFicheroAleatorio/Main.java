/*
********Autor: Cristina Navarro*********************
********Fecha: 09/10/2017***************************
********Asignatura:D. de Aplicaciones Moviles*******
********Ejercicio:	 Creación de fichero con acceso*
*********  aleatorio********************************
*/

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentoAleatorio.dat");
        RandomAccessFile raf = new RandomAccessFile(f,"rw");
        String[] nombre = {"Ventas","Márketing","RRHH"};
        String[] lugar = {"Málaga", "Asturias","Granada"};
        StringBuffer sbNombre;
        StringBuffer sbLugar;

        for(int i=0;i<nombre.length;i++){
            raf.writeInt(i+1);
            sbNombre = new StringBuffer(nombre[i]);
            sbNombre.setLength(10);
            raf.writeChars(sbNombre.toString());
            sbLugar = new StringBuffer(lugar[i]);
            sbLugar.setLength(10);
            raf.writeChars(sbLugar.toString());
        }
        raf.close();
    }
}
