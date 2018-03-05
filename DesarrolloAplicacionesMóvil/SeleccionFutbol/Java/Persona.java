package com.example.cristi.seleccionfutbol;

/**
 * Created by Cristi on 27/11/2017.
 */

public class Persona {
    private String nombre;
    private String apellidos;
    private String equipo;


    Persona(String nombre, String apellidos, String equipo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.equipo = equipo;
    }

    String getNombre() {
        return this.nombre;
    }

    String getApellidos() {
        return this.apellidos;
    }

    String getEquipo() {
        return this.equipo;
    }

}
