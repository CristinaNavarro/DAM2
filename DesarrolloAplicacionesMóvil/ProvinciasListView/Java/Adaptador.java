package com.example.cristi.provinciaslistview;
/*
********Autor: Cristina Navarro
********Fecha: 28/11/2017
********Asignatura:D. de Aplicaciones Moviles
********Ejercicio:	Práctica con ListView
*/
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter {
    private Activity context;
    private ArrayList<Provincia> datos;

    Adaptador(Activity context, ArrayList<Provincia> datos) {
        super(context, R.layout.activity_adaptador,datos);
        this.context = context;
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_adaptador, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.tvNombre);
        lblNombre.setText(datos.get(position).getNombre());

        TextView lblCodigo =
                (TextView)item.findViewById(R.id.tvCodigo);
        lblCodigo.setText(String.valueOf(datos.get(position).getCodigoPostal()));

        return(item);
    }
}
