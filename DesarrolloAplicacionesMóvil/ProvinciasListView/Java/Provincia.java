package com.example.cristi.provinciaslistview;

/*
********Autor: Cristina Navarro
********Fecha: 28/11/2017
********Asignatura:D. de Aplicaciones Moviles
********Ejercicio:	Práctica con ListView
*/

public class Provincia {
    private String nombre;
    private int codigoPostal;


    Provincia(String nombre, int codigoPostal) {
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;

    }

    String getNombre() {
        return this.nombre;
    }

    int getCodigoPostal() {
        return this.codigoPostal;
    }

}
