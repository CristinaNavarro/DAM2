/*
********Autor: Cristina Navarro*********************
********Fecha: 02/10/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Crear un programa que escriba***
********  un documento dat desde objetos************
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //Creacion de los departamentos
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();
        Departamento d1 = new Departamento();
        d1.setCodigo(1);
        d1.setNombre("Ventas");
        d1.setLugar("Malaga");
        listaDepartamentos.add(d1);
        listaDepartamentos.add(new Departamento(2,"Marketing","Asturias"));
        listaDepartamentos.add(new Departamento(3,"RRHH","Madrid"));

        //Creacion del archivo a escribir
        FileOutputStream fOut = new FileOutputStream("C:\\Users\\Cristi\\Desktop\\A\\DepartamentosObjetos.dat");
        ObjectOutputStream objectOut = new ObjectOutputStream(fOut);
        for(int i=0;i<listaDepartamentos.size();i++){
            objectOut.writeObject(listaDepartamentos.get(i));
        }
        objectOut.close();
        fOut.close();

    }
}
