package com.example.cristi.noriaejercicio17final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ActHorarioNoria extends AppCompatActivity {

    private LinearLayout linearHorario;
    private ArrayList<Viaje> arrayListHorario = new ArrayList<>();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_noria);


        linearHorario = (LinearLayout) findViewById(R.id.linearHorario);

        Intent intentRecibido = getIntent();
        Bundle b = intentRecibido.getExtras();


        final TextView textView = (TextView) linearHorario.getChildAt(0);
        final int idNoria = b.getInt("idnoria",0);
        final int nombreNoria = b.getInt("nombreNoria");
        textView.setText(nombreNoria);

        /*
         * Creación e inclusión de datos en ListView
         */
        final ListView listNorias = (ListView) linearHorario.getChildAt(1);
        for (int i = 1; i <= ConfiguracionLocal.MAXIMOVIAJES; i++) {
            arrayListHorario.add(new Viaje("viaje" + i,ConfiguracionLocal.horas[i-1]));
        }
        AdaptadorListViewHorario adaptador = new AdaptadorListViewHorario(this, arrayListHorario);
        listNorias.setAdapter(adaptador);

        /*
         * Envía la información a otra actividad al pulsar un elemento del ListView
         */
        ListView listView = (ListView) linearHorario.getChildAt(1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ActClientesNoria.class);
                Bundle b = new Bundle();
                b.putInt("idnoria",idNoria);
                b.putInt("idviaje",position+1);
                b.putString("hora",ConfiguracionLocal.horas[position]);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
}
