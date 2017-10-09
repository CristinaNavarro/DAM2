/*
********Autor: Cristina Navarro*********************
********Fecha: 25/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Realiza un programa que copie***
********  dos ficheros. El nombre de los dos********
********  ficheros, origen y destino se introducen**
********  por teclado.******************************
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader fichero = new BufferedReader(new FileReader("C:\\Users\\Cristi\\Desktop\\A\\F.txt"));
        PrintWriter ficheroCopia = new PrintWriter("C:\\Users\\Cristi\\Desktop\\A\\Z.txt");
        String linea;
        while((linea = fichero.readLine())!=null){
            ficheroCopia.println(linea);
        }
        fichero.close();
        ficheroCopia.close();
    }
}
