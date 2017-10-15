/*
********Autor: Cristina Navarro*********************
********Fecha: 25/09/2017***************************
********Asignatura:AccesoADatos*********************
********Ejercicio:	Realiza un programa java que****
********  cree un fichero txt para guardar**********
********  datos de departamentos, dale el nombre****
********  Departamentos.dat. Introduce varios*******
********  departamentos. Los datos por cada*********
********  departamento son: Número de departamento:*
********  entero, Nombre: String y Localidad:*******
********  String.***********************************
*/

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Cristi\\Desktop\\A\\T.txt"));
        int[] numDepartamento = {1,2,3};
        String[] departamentos = {"RRHH","Ventas","Marketing"};
        String[] localidad = {"Malaga","Madrid","Malaga"};
        for(int i=0;i<numDepartamento.length;i++){
            pw.write(numDepartamento[i] +departamentos[i] +localidad[i]);
        }
        pw.close();
    }
}
