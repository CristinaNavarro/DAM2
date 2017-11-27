package com.example.cristi.pruebalistview;

/**
 * Created by Cristi on 27/11/2017.
 */

public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;

    Persona(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    String getNombre() {
        return this.nombre;
    }

    String getApellido1() {
        return this.apellido1;
    }

    String getApellido2() {
        return this.apellido2;
    }
}
