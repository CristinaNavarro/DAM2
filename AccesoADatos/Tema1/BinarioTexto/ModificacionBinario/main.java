/*
********Autor: Cristina Navarro*********************
********Fecha: 25/09/2017***************************
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

public class main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat");
        File modificado = new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.temp.dat");
        DataInputStream dIn = new DataInputStream(new FileInputStream(f));
        DataOutputStream dOut = new DataOutputStream(new FileOutputStream(modificado));
        DataInputStream dInMod = new DataInputStream(new FileInputStream(modificado));
        boolean cambio = false;
        try{
            System.out.println("Introduce el numero del departamento a modificar: ");
            int n = sc.nextInt();
            int actual;
            while(true){
                actual=dIn.readInt();
                if(n!=actual) {
                    dOut.writeInt(actual);
                    dOut.writeUTF(dIn.readUTF());
                    dOut.writeUTF(dIn.readUTF());
                    System.out.println("Linea escrita en el nuevo documento: " +dInMod.readInt() +dInMod.readUTF() +dInMod.readUTF());
                }else{
                    cambio=true;
                    System.out.println("Se sustituiran los siguientes datos( " +" " +dIn.readUTF() +", " +dIn.readUTF() +") del departamento " +actual);
                    dOut.writeInt(actual);
                    System.out.println("Nombre");
                    dOut.writeUTF(sc.next());
                    System.out.println("Lugar");
                    dOut.writeUTF(sc.next());
                    System.out.println("Linea escrita en el nuevo documento: " +dInMod.readInt() +dInMod.readUTF() +dInMod.readUTF());
                }
            }
        }catch (EOFException e){
            dIn.close();
            dOut.close();
            dInMod.close();

            if(!cambio){
                System.out.println("No se ha encontrado el departamento a modificar");
            }else{
                System.out.println("Cambios efectuados");

                f.delete();
                modificado.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat"));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
