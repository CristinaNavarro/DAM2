/*
********Autor: Cristina Navarro*********************
********Fecha: 06/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Crear un programa que escriba***
********  un documento dat desde objetos************
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //Creacion de los empleados
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();
        Empleados d1 = new Empleados();
        d1.setCodigo(1);
        d1.setApellido("ApellidoInventado");
        d1.setSueldo(1500);
        listaEmpleados.add(d1);
        listaEmpleados.add(new Empleados(2,"OtroApellidoInventado",2000));
        listaEmpleados.add(new Empleados(3,"Nosequeapellidoponer",1700));

        //Creacion del archivo a escribir
        FileOutputStream fOut = new FileOutputStream("C:\\Users\\Cristi\\Desktop\\A\\EmpleadosObjetos.dat");
        ObjectOutputStream objectOut = new ObjectOutputStream(fOut);
        for(int i=0;i<listaEmpleados.size();i++){
            objectOut.writeObject(listaEmpleados.get(i));
        }
        objectOut.close();
        fOut.close();

    }
}
