package com.example.cristi.databaselistview;

/*
********Autor: Cristina Navarro
********Fecha: 18/12/2017
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	BBDD con ListView
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
