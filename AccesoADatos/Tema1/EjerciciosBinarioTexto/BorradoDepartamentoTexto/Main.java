/*
********Autor: Cristina Navarro*********************
********Fecha: 30/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Realiza un programa java que te*
********  permita eliminar un departamento. El******
********  programa lee el número de departamento a**
********  eliminar. Si el departamento no existe****
********  visualiza un mensaje indicándolo.*********
********  Visualiza también el número total de******
********  departamentos que existen.****************
*/

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean cambio = false;
        int contDepartamentos = 0;

        //Creacion de archivos
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.txt");
        File modificado = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.temp.txt");
        //Creacion de IO
        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(modificado));
        BufferedReader brMod = new BufferedReader(new FileReader(modificado));


        System.out.println("Introduce el numero del departamento a eliminar: ");
        int n = sc.nextInt();
        int actual;
        String linea;
        while ((linea = br.readLine()) != null) {
            actual = Integer.parseInt(linea.substring(0, 1));
            if (n != actual) {
                contDepartamentos++;
                bw.write(linea);
                bw.newLine();
            } else {
                cambio = true;
            }
        }
        br.close();
        bw.close();
        brMod.close();
        if (!cambio) {
            System.out.println("No se ha encontrado el departamento a eliminar");
        } else {
            System.out.println("Cambios efectuados");
            f.delete();
            modificado.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.txt"));
        }
        System.out.println("Ahora hay un total de " +contDepartamentos +" departamentos.");

    }
}
