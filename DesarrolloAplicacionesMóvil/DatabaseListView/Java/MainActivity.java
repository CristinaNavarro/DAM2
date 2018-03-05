package com.example.cristi.databaselistview;

/*
********Autor: Cristina Navarro
********Fecha: 18/12/2017
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	BBDD con ListView
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listNombres;
    private AdaptadorBD adaptadorBD;
    private Button bCambiar;
    private boolean mostrarCopia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNombres = (ListView) findViewById(R.id.listNombres);
        bCambiar = (Button) findViewById(R.id.bCambiar);
        mostrarCopia = false;

        adaptadorBD = new AdaptadorBD(getApplicationContext());
        Log.e("1", "New adaptador");
        adaptadorBD.open();
        adaptadorBD.borrarBD();
        adaptadorBD.open();
        Log.e("2", "Abierto");
        adaptadorBD.insertarPersona(new Persona("Nombre1", "Apellido1"));
        Log.e("3", "Insertado");
        adaptadorBD.insertarPersona(new Persona("Nombre2", "Apellido2"));
        adaptadorBD.insertarPersona(new Persona("Nombre3", "Apellido3"));
        actualizarSeleccion(adaptadorBD.getAllPersonas(), listNombres);
        adaptadorBD.close();
        listNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adaptadorBD.open();
                Persona persona = (Persona) listNombres.getItemAtPosition(position);
                adaptadorBD.insertarPersonaCopia(persona.getNombre(), persona.getApellido());
                Toast.makeText(getApplicationContext(), "Se ha copiado.", Toast.LENGTH_SHORT).show();
                if (!mostrarCopia) {
                    actualizarSeleccion(adaptadorBD.getAllPersonas(), listNombres);
                } else {
                    actualizarSeleccion(adaptadorBD.getAllPersonasCopia(), listNombres);
                }
                adaptadorBD.close();
            }
        });

        bCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptadorBD.open();
                if (mostrarCopia) {
                    actualizarSeleccion(adaptadorBD.getAllPersonas(), listNombres);
                } else {
                    actualizarSeleccion(adaptadorBD.getAllPersonasCopia(), listNombres);
                }
                adaptadorBD.close();
                mostrarCopia = !mostrarCopia;

            }
        });

    }

    void actualizarSeleccion(ArrayList<Persona> listaJugadores, ListView lista) {
        AdaptadorNombreSolo adaptadorNombreSolo = new AdaptadorNombreSolo(this, listaJugadores);
        lista.setAdapter(adaptadorNombreSolo);
    }

}
