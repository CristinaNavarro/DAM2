/*
********Autor: Cristina Navarro*********************
********Fecha: 25/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Realiza un programa java que****
********  cree un fichero binario para guardar******
********  datos de departamentos, dale el nombre****
********  Departamentos.dat. Introduce varios*******
********  departamentos. Los datos por cada*********
********  departamento son: Número de departamento:*
********  entero, Nombre: String y Localidad:*******
********  String.***********************************
*/

import java.io.*;

public class main {
    public static void main(String[] args) throws Exception {
        File fichero = new File("C:\\Users\\Cristi\\Desktop\\A\\Empleados.dat");
        DataOutputStream fOut = new DataOutputStream(new FileOutputStream(fichero));
        int[] numDepartamento = {1,2,3};
        String[] apellidos = {"Navarro","Soto","Alcaraz"};
        int[] sueldo = {2000,1500,1700};
        for(int i=0;i<numDepartamento.length;i++){
            fOut.writeInt(numDepartamento[i]);
            fOut.writeUTF(apellidos[i]);
            fOut.writeInt(sueldo[i]);
        }
        fOut.close();

    }
}
