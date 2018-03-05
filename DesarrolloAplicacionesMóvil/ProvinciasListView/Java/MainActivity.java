package com.example.cristi.provinciaslistview;

/*
********Autor: Cristina Navarro
********Fecha: 28/11/2017
********Asignatura:D. de Aplicaciones Moviles
********Ejercicio:	Práctica con ListView
*/

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private ListView listaActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);
        listaActualizar = (ListView) findViewById(R.id.listaActualizar);

        final ArrayList<Provincia> listaProvincias = new ArrayList<>();
        listaProvincias.add(new Provincia("Málaga", 29000));
        listaProvincias.add(new Provincia("Cuenca", 16000));
        listaProvincias.add(new Provincia("Gerona", 17000));
        listaProvincias.add(new Provincia("Huelva", 21000));

        actualizar(listaProvincias,lista);
        final ArrayList<Provincia> listaProvinciasAnadidas = new ArrayList<>();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                ConstraintLayout base = (ConstraintLayout) parent.getChildAt(position);
                LinearLayout v = (LinearLayout) base.getChildAt(0);
                TextView tvNombre = (TextView) v.getChildAt(0);
                TextView tvCodigo = (TextView) v.getChildAt(1);
                listaProvinciasAnadidas.add(new Provincia(tvNombre.getText().toString(),Integer.parseInt(tvCodigo.getText().toString())));
                actualizar(listaProvinciasAnadidas,listaActualizar);
            }
        });

        listaActualizar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                listaProvinciasAnadidas.remove(position);
                actualizar(listaProvinciasAnadidas,listaActualizar);
            }
        });
    }

    //Introduce los datos en el listView
    void actualizar(ArrayList<Provincia> listaProvincias,ListView lista) {
        Adaptador adaptador = new Adaptador(this, listaProvincias);
        lista.setAdapter(adaptador);
    }
}
