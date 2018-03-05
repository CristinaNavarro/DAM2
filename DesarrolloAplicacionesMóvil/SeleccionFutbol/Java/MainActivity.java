package com.example.cristi.seleccionfutbol;

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

    private ListView listBarcelona;
    private ListView listMadrid;
    private ListView listSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBarcelona = (ListView) findViewById(R.id.listBarcelona);
        listMadrid = (ListView) findViewById(R.id.listMadrid);
        listSeleccion = (ListView) findViewById(R.id.listSeleccion);

        final ArrayList<Persona> arrayBarcelona = new ArrayList<>();
        arrayBarcelona.add(new Persona("Lionel","Messi","Barcelona"));
        arrayBarcelona.add(new Persona("Gerard","Piqué","Barcelona"));
        final ArrayList<Persona> arrayMadrid = new ArrayList<>();
        arrayMadrid.add(new Persona("Cristiano","Ronaldo","Madrid"));
        arrayMadrid.add(new Persona("Karim","Benzema","Madrid"));
        final ArrayList<Persona> arraySeleccion = new ArrayList<>();
        actualizar(arrayBarcelona,listBarcelona);
        actualizar(arrayMadrid,listMadrid);

        listBarcelona.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConstraintLayout base = (ConstraintLayout) parent.getChildAt(position);
                LinearLayout v = (LinearLayout) base.getChildAt(0);
                TextView tvNombre = (TextView) v.getChildAt(0);
                TextView tvApellido = (TextView) v.getChildAt(1);
                arraySeleccion.add(new Persona(tvNombre.getText().toString(),tvApellido.getText().toString(),"Barcelona"));
                arrayBarcelona.remove(position);
                actualizar(arrayBarcelona,listBarcelona);
                actualizarSeleccion(arraySeleccion,listSeleccion);
            }
        });

        listMadrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConstraintLayout base = (ConstraintLayout) parent.getChildAt(position);
                LinearLayout v = (LinearLayout) base.getChildAt(0);
                TextView tvNombre = (TextView) v.getChildAt(0);
                TextView tvApellido = (TextView) v.getChildAt(1);
                arraySeleccion.add(new Persona(tvNombre.getText().toString(),tvApellido.getText().toString(),"Madrid"));
                arrayMadrid.remove(position);
                actualizar(arrayMadrid,listMadrid);
                actualizarSeleccion(arraySeleccion,listSeleccion);
            }
        });

        listSeleccion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConstraintLayout base = (ConstraintLayout) parent.getChildAt(position);
                LinearLayout v = (LinearLayout) base.getChildAt(0);
                TextView tvNombre = (TextView) v.getChildAt(0);
                String apellido = arraySeleccion.get(position).getApellidos();
                String equipo = arraySeleccion.get(position).getEquipo();
                switch (equipo) {
                    case "Barcelona":
                        arrayBarcelona.add(new Persona(tvNombre.getText().toString(),apellido,"Barcelona"));
                        break;
                    case "Madrid":
                        arrayMadrid.add(new Persona(tvNombre.getText().toString(),apellido,"Madrid"));
                        break;
                }
                arraySeleccion.remove(position);

                actualizar(arrayMadrid,listMadrid);
                actualizarSeleccion(arraySeleccion,listSeleccion);
                actualizar(arrayBarcelona,listBarcelona);
            }
        });
    }

    //Actualiza los listView de los distintos equipos
    void actualizar(ArrayList<Persona> listaJugadores, ListView lista) {
        Adaptador adaptador = new Adaptador(this, listaJugadores);
        lista.setAdapter(adaptador);
    }

    //Actualiza el listView de la selección
    void actualizarSeleccion(ArrayList<Persona> listaJugadores, ListView lista) {
        AdaptadorNombreSolo adaptadorNombreSolo = new AdaptadorNombreSolo(this,listaJugadores);
        lista.setAdapter(adaptadorNombreSolo);
    }
}
