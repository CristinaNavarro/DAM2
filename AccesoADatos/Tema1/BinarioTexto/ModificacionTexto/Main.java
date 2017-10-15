/*
********Autor: Cristina Navarro*********************
********Fecha: 29/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Realiza un programa Java que te*
********  permita modificar los datos de************
********  departamento. El programa lee el número***
********  de departamento a modificar, el nuevo*****
********  nombre de departamento y la nueva*********
********  localidad. Si el departamento no existe***
********  visualiza un mensaje indicándolo.*********
********  Visualiza también los datos antiguos del**
********  departamento y los nuevos datos.**********
*/

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean cambio = false;

        //Creacion de archivos
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.txt");
        File modificado = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.temp.txt");
        //Creacion de IO
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(modificado));
        BufferedReader brMod = new BufferedReader(new FileReader(modificado));


        System.out.println("Introduce el numero del departamento a modificar: ");
        int n = sc.nextInt();
        int actual;
        String linea;
        while ((linea = br.readLine()) != null) {
            actual = Integer.parseInt(linea.substring(0, 1));
            if (n != actual) {
                bw.write(linea);
                bw.newLine();
                //System.out.println("Linea escrita en el nuevo documento: " + brMod.readLine());
            } else {
                String printer;
                cambio = true;
                System.out.println("Se sustituiran los siguientes datos( " + " " + linea + ") del departamento " + actual);
                printer = String.valueOf(actual);
                System.out.println("Nombre");
                printer += sc.next();
                System.out.println("Lugar");
                printer += sc.next();
                bw.write(printer);
                bw.newLine();
                //System.out.println("Linea escrita en el nuevo documento: " + brMod.readLine());
            }
        }
        br.close();
        bw.close();
        System.out.println("Informacion del archivo modificado:");
        while((linea=brMod.readLine())!=null){
            System.out.println(linea);
        }
        brMod.close();
        if (!cambio) {
            System.out.println("No se ha encontrado el departamento a modificar");
        } else {
            f.delete();
            modificado.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.txt"));
            System.out.println("Cambios efectuados");
        }
    }

    //Duda: por que no me deja leer un txt mientras estoy escribiendo en el pero si en un binario?
}

