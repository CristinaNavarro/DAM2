package com.example.cristi.seleccionfutbol;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter {
    private Activity context;
    private ArrayList<Persona> datos;

    public Adaptador(Activity context, ArrayList<Persona> datos) {
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

        TextView lblApellido1 =
                (TextView)item.findViewById(R.id.tvApellidos);
        lblApellido1.setText(datos.get(position).getApellidos());



        return(item);
    }
}
