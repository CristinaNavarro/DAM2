/*
********Autor: Cristina Navarro*********************
********Fecha: 25/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Crea un fichero de texto con****
********  algún editor de textos y después realiza**
********  un programa Java que visualice su*********
********  contenido. Cambia el programa java para***
********  que el nombre del fichero se acepte desde*
********  teclado. *********************************
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("intro:");
        BufferedReader fichero = new BufferedReader(new FileReader(sc.next()));
        String linea;
        while((linea = fichero.readLine())!=null){
            System.out.println(linea);
        }
        fichero.close();
    }
}
