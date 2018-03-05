package com.example.cristi.guardardatoslistview;

/**
 * Created by Cristi on 27/11/2017.
 */

public class Persona {
    private String nombre;
    private String apellidos;


    Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;

    }

    String getNombre() {
        return this.nombre;
    }

    String getApellidos() {
        return this.apellidos;
    }

}
