/*
********Autor: Cristina Navarro*********************
********Fecha: 01/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Crea un fichero Java que reciba*
********  un identificador de un empleado desde*****
********  teclado y visualice sus datos. Si el******
********  empleado no existe debe visualizar el*****
********  mensaje.**********************************
*/

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean existe = false;
        System.out.println("Elija el empleado a mostrar");
        String codigo = sc.nextLine();
        try {
            BufferedReader fr = new BufferedReader(new FileReader("C:\\Users\\Cristi\\Desktop\\A\\Empleados.txt"));
            String linea;
            while((linea=fr.readLine())!=null){
                if(linea.substring(0,1).equals(codigo)){
                     existe = true;
                     for(String dato : linea.split(",")){
                         System.out.print(dato +" ");
                     }
                }

            }
            if(!existe){
                System.out.println("No existe ese empleado");
            }
            fr.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
