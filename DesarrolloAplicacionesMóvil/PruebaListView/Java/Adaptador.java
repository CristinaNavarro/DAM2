package com.example.cristi.pruebalistview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter {
    private Activity context;
    private Persona[] datos;

    public Adaptador(Activity context, Persona[] datos) {
        super(context, R.layout.activity_adaptador,datos);
        this.context = context;
        this.datos = datos;

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.activity_adaptador, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.tvNombre);
        lblNombre.setText(datos[position].getNombre());

        TextView lblApellido1 =
                (TextView)item.findViewById(R.id.tvApellido1);
        lblApellido1.setText(datos[position].getApellido1());

        TextView lblApellido2 =
                (TextView)item.findViewById(R.id.tvApellido2);
        lblApellido2.setText(datos[position].getApellido2());

        return(item);
    }
}
