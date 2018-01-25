package com.example.cristi.noriaejercicio17final;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristi on 08/01/2018.
 */

public class AdaptadorListViewNorias extends ArrayAdapter {

    private Activity context;
    private ArrayList<Noria> datosNoria;

    AdaptadorListViewNorias(Activity context, ArrayList<Noria> datosNoria) {
        super(context, R.layout.adaptador_norias,datosNoria);
        this.context = context;
        this.datosNoria = datosNoria;
    }

    /*
     * Adaptador que permite cargar la información de las norias
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.adaptador_norias, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.tvNombre);
        lblNombre.setText(context.getResources().getString(ConfiguracionLocal.codigoNoria[position]));

        return(item);
    }
}
