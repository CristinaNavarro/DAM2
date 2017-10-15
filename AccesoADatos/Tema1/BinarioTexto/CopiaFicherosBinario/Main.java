/*
********Autor: Cristina Navarro*********************
********Fecha: 30/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Realiza un programa que copie***
********  dos ficheros. El nombre de los dos********
********  ficheros, origen y destino se introducen**
********  por teclado.******************************
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream dIn = new DataInputStream(new FileInputStream("C:\\Users\\Cristi\\Desktop\\A\\Departamentos.dat"));
        DataOutputStream dOut = new DataOutputStream(new FileOutputStream("C:\\Users\\Cristi\\Desktop\\A\\CopiaDepartamentos.dat"));
        try {
            while (true) {
                dOut.writeInt(dIn.readInt());
                dOut.writeUTF(dIn.readUTF());
                dOut.writeUTF(dIn.readUTF());
            }
        }catch (EOFException e){
            dIn.close();
            dOut.close();
        }
    }
}
