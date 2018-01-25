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

public class AdaptadorListViewHorario extends ArrayAdapter {

    private Activity context;
    private ArrayList<Viaje> datosHorario;

    AdaptadorListViewHorario(Activity context, ArrayList<Viaje> datosHorario) {
        super(context, R.layout.adaptador_norias,datosHorario);
        this.context = context;
        this.datosHorario = datosHorario;
    }

    /*
     * Adaptador que permite cargar la información de los horarios de viajes
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.adaptador_norias, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.tvNombre);
        lblNombre.setText(datosHorario.get(position).getHora());

        return(item);
    }
}
