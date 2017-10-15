/*
********Autor: Cristina Navarro*********************
********Fecha: 01/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Crea un programa java que*******
********  reciba desde teclado un identificador de**
********  empleado y un importe. Se debe sumar al***
********  salario del empleado el importe tecleado.*
********  El programa debe visualizar el apellido,**
********  el salario antiguo y el nuevo. Si el******
********  identificador no existe se visualizará un*
********  mensaje indicándolo.**********************
*/

import java.io.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int actual;
        boolean existe = false;
        System.out.println("Elija el empleado para subirle el sueldo");
        int codigo = sc.nextInt();
        System.out.println("Introduzca la cantidad del aumento");
        int aumento = sc.nextInt();
        File fOld = new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.dat");
        File fNew = new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.new.dat");
        DataInputStream dIn = new DataInputStream(new FileInputStream(fOld));
        fOld.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.old.dat"));
        DataOutputStream dOut = new DataOutputStream(new FileOutputStream(fNew));
        try {
            while(true){
                if(codigo==(actual=dIn.readInt())){
                    existe = true;
                    String apellido = dIn.readUTF();
                    int sueldo = dIn.readInt();
                    aumento += sueldo;
                    System.out.println(codigo +" " +apellido +" " +sueldo +" " +aumento);
                    dOut.writeInt(codigo);
                    dOut.writeUTF(apellido);
                    dOut.writeInt(aumento);
                }else{
                    dOut.writeInt(actual);
                    dOut.writeUTF(dIn.readUTF());
                    dOut.writeInt(dIn.readInt());
                }

            }


        }catch (EOFException e){
            dIn.close();
            dOut.close();
            if(!existe){
                System.out.println("No existe ese empleado");
            }
            fOld.delete();
            fNew.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.dat"));
        }
    }
}
