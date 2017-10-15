/*
********Autor: Cristina Navarro*********************
********Fecha: 02/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Modificacion de informacion de *
********  un .dat con objetos***********************
*/

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Departamento d;
        System.out.println("Introduce el codigo del departamento a modificar");
        int codModificacion = sc.nextInt();

        File fOld = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.dat");
        File fNew = new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.new.dat");
        FileInputStream fInOld = new FileInputStream(fOld);
        FileOutputStream fOutNew = new FileOutputStream(fNew);
        ObjectInputStream objectIn = new ObjectInputStream(fInOld);
        ObjectOutputStream objectOut = new ObjectOutputStream(fOutNew);

        try {
            while (true) {
                d = (Departamento) objectIn.readObject();
                if(d.getCodigo() == codModificacion){
                    System.out.println("Introduce el nuevo nombre");
                    d.setNombre(sc.next());
                    System.out.println("Introduce el nuevo lugar");
                    d.setLugar(sc.next());
                }
                objectOut.writeObject(d);
            }
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (EOFException e){
            fInOld.close();
            fOutNew.close();

            fOld.delete();
            fNew.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.dat"));

        }
    }
}
