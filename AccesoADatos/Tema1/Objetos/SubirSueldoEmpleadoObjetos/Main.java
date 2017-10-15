/*
********Autor: Cristina Navarro*********************
********Fecha: 06/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Crear un programa que modifique*
********  un documento dat desde objetos************
*/

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el empleado a subir el sueldo");
        int cod = sc.nextInt();
        System.out.println("Introduce la cantidad del aumento");
        int sueldo = sc.nextInt();
        boolean existe = false;
        Empleados e;
        File fOld = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.dat");
        File fNew = new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.new.dat");
        FileInputStream fInOld = new FileInputStream(fOld);
        FileOutputStream fOutNew = new FileOutputStream(fNew);
        ObjectInputStream objectIn = new ObjectInputStream(fInOld);
        ObjectOutputStream objectOut = new ObjectOutputStream(fOutNew);

        try {
            while (true) {
                e = (Empleados) objectIn.readObject();
                if (e.getCodigo() == cod) {
                    e.setSueldo(e.getSueldo() + sueldo);
                    objectOut.writeObject(e);
                    existe = true;
                }else{
                    objectOut.writeObject(e);
                }
            }
        } catch (ClassNotFoundException error) {
            System.out.println(error.getMessage());
        } catch (EOFException error) {
            objectIn.close();
            objectOut.close();
            fInOld.close();
            fOutNew.close();

            if (!existe) {
                System.out.println("No existe ese empleado");
            }

            fOld.delete();
            fNew.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.dat"));
        }
    }
}
