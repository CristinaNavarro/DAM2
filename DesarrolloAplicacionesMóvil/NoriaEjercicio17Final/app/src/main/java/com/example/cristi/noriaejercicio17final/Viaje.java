package com.example.cristi.noriaejercicio17final;

/**
 * Created by Cristi on 08/01/2018.
 */

public class Viaje {
    private Persona[] personas;
    private String nombre;
    private String hora;


    Viaje(String nombre, String hora) {
    //    this.personas = new Persona[MAXIMOPERSONAS];
        this.nombre = nombre;
        this.hora = hora;
    }

    String getNombre() {
        return this.nombre;
    }
    String getHora() {
        return this.hora;
    }

    void añadirPersona(int posicion, Persona persona) {
        this.personas[posicion] = persona;
    }


}
