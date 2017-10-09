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

        //Creacion de archivos
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat");
        File modificado = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.temp.dat");

        //Creacion de IO
        DataInputStream dIn = new DataInputStream(new FileInputStream(f));
        DataOutputStream dOut = new DataOutputStream(new FileOutputStream(modificado));
        DataInputStream dInMod = new DataInputStream(new FileInputStream(modificado));


        boolean cambio = false;
        int contDepartamentos = 0;


        try{
            System.out.println("Introduce el numero del departamento a eliminar: ");
            int n = sc.nextInt();
            int actual;
            //mientras que queden datos en el archivo, se buscara el que coincida con el numero introducido y se borrara
            while(true){
                actual=dIn.readInt();
                if(n!=actual) {
                    contDepartamentos++;
                    dOut.writeInt(actual);
                    dOut.writeUTF(dIn.readUTF());
                    dOut.writeUTF(dIn.readUTF());
                    System.out.println("Linea escrita en el nuevo documento: " +dInMod.readInt() +dInMod.readUTF() +dInMod.readUTF());
                }else{
                    dIn.readUTF();
                    dIn.readUTF();
                    cambio=true;
                }
            }
        }catch (EOFException e){
            dIn.close();
            dOut.close();
            dInMod.close();
            if(!cambio){
                System.out.println("No se ha encontrado el departamento a eliminar");
            }else{
                System.out.println("Cambios efectuados");
                f.delete();
                modificado.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat"));
            }
            System.out.println("Ahora hay un total de " +contDepartamentos +" departamentos");
        }
    }
}
