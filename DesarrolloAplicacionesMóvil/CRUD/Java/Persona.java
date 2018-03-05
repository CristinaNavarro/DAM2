package com.example.cristi.estudioexamenandroid;

/*
********Autor: Cristina Navarro
********Fecha: 28/01/2018
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	Mi CRUD de SQLite
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

    String getApellido() {
        return this.apellidos;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
