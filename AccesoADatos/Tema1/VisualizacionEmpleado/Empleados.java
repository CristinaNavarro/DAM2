import com.sun.java_cup.internal.runtime.Scanner;

import java.io.Serializable;

public class Empleados implements Serializable{

    int codigo;
    String apellido;
    int sueldo;

    Empleados(){

    }

    Empleados(int cod, String apellido, int sueldo){
        this.codigo = cod;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    int getCodigo(){
        return this.codigo;
    }

    String getApellido(){
        return this.apellido;
    }

    int getSueldo(){
        return this.sueldo;
    }

    void setCodigo(int cod){
        this.codigo = cod;
    }

    void setApellido(String apellido){
        this.apellido = apellido;
    }

    void setSueldo(int sueldo){
        this.sueldo = sueldo;
    }
}
