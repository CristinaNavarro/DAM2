package com.example.cristi.databaselistview;


/*
********Autor: Cristina Navarro
********Fecha: 18/12/2017
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	BBDD con ListView
*/


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorNombreSolo extends ArrayAdapter {
    private Activity context;
    private ArrayList<Persona> datos;

    public AdaptadorNombreSolo(Activity context, ArrayList<Persona> datos) {
        super(context, R.layout.activity_adaptadornombresolo,datos);
        this.context = context;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_adaptadornombresolo, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.tvNombre);
        lblNombre.setText(datos.get(position).getNombre());

        return(item);
    }
}
