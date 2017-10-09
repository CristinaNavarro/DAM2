/*
********Autor: Cristina Navarro*********************
********Fecha: 06/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Lector de información de un*****
********  .dat con objetos**************************
*/


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el empleado a visualizar");
        int cod = sc.nextInt();
        boolean existe = false;
        Empleados e;
        FileInputStream fIn = new FileInputStream("C:\\Users\\Cristi\\Desktop\\A\\CopiaEmpleadosObjetos.dat");
        ObjectInputStream objectIn = new ObjectInputStream(fIn);
        try {
            while (true) {
                e = (Empleados) objectIn.readObject();
                if(cod == e.getCodigo()) {
                    System.out.println("Codigo: " + e.getCodigo() + " Apellido: " + e.getApellido() + " Sueldo: " + e.getSueldo());
                    existe = true;
                }
            }
        }catch (EOFException error){
            objectIn.close();
            fIn.close();
            if(!existe) System.out.println("Ese empleado no existe");
        }catch (ClassNotFoundException error){
            System.out.println(error.getMessage());
        }catch (OptionalDataException error){
            System.out.println(error.getMessage());
        }

    }
}
