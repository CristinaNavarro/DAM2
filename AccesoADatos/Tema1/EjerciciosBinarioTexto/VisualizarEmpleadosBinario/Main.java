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
        int codigo = sc.nextInt();
        DataInputStream dIn = new DataInputStream(new FileInputStream("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat"));
        try {
            while(true){
                if(codigo==dIn.readInt()){
                    existe = true;
                    System.out.println(codigo +" " +dIn.readUTF() +" " +dIn.readInt());
                }else{
                    dIn.readUTF();
                    dIn.readInt();
                }

            }


        }catch (EOFException e){
            dIn.close();
            if(!existe){
                System.out.println("No existe ese empleado");
            }
        }
    }
}
