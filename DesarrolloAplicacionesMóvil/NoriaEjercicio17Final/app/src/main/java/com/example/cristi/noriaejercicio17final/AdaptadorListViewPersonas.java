package com.example.cristi.noriaejercicio17final;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristi on 08/01/2018.
 */

public class AdaptadorListViewPersonas extends ArrayAdapter {

    private Activity context;
    private ArrayList<Persona> datosPersona;

    AdaptadorListViewPersonas(Activity context, ArrayList<Persona> datosPersona) {
        super(context, R.layout.adaptador_norias,datosPersona);
        this.context = context;
        this.datosPersona = datosPersona;
    }

    /*
     * Adaptador que permite cargar la información de las personas
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.adaptador_norias, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.tvNombre);
        lblNombre.setText(datosPersona.get(position).getNombre());

        return(item);
    }

}
