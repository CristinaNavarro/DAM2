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
        boolean existe = false;
        String[] datos;
        String apellido;
        int sueldo;
        System.out.println("Elija el empleado al que se va a subir el sueldo");
        String codigo = sc.nextLine();
        System.out.println("Introduce el aumento");
        int aumento = sc.nextInt();
        File fOld = new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.txt");
        File fNew = new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.new.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(fOld));
            fOld.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.old.txt"));
            BufferedWriter bw =new BufferedWriter(new FileWriter(fNew));
            String linea;
            while((linea=br.readLine())!=null){
                if(linea.substring(0,1).equals(codigo)){
                    existe = true;
                    datos = linea.split(",");
                    sueldo = Integer.parseInt(datos[2]);
                    aumento += sueldo;
                    apellido = datos[1];
                    System.out.println(codigo +" " +apellido +" " +sueldo +" " +aumento);
                    bw.write(codigo+","+apellido+","+aumento);
                }else{
                    bw.write(linea);
                }
            }
            br.close();
            bw.close();
            fOld.delete();
            fNew.renameTo(new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.txt"));
            if(!existe){
                System.out.println("No existe ese empleado");
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
