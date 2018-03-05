package com.example.cristi.estudioexamenandroid;
/*
********Autor: Cristina Navarro
********Fecha: 28/01/2018
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	Mi CRUD de SQLite
*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Delete_Activity extends AppCompatActivity {

    private ListView listRegistros;
    private Button bEliminarTodo;
    private AdaptadorBD adaptadorBD;
    private EditText etNombrePersona;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_);
        listRegistros = (ListView) findViewById(R.id.listRegistros);

        adaptadorBD = new AdaptadorBD(getApplicationContext());
        adaptadorBD.open();
        listaPersonas = adaptadorBD.getAllPersonas();
        actualizarSeleccion(listaPersonas,listRegistros);
        adaptadorBD.close();

        bEliminarTodo = (Button) findViewById(R.id.bEliminarTodo);
        bEliminarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptadorBD = new AdaptadorBD(getApplicationContext());
                adaptadorBD.open();
                adaptadorBD.borrarBD();
                listaPersonas = adaptadorBD.getAllPersonas();
                actualizarSeleccion(listaPersonas,listRegistros);
                adaptadorBD.close();
            }
        });

        etNombrePersona = (EditText) findViewById(R.id.etNombrePersona);

        listRegistros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adaptadorBD = new AdaptadorBD(getApplicationContext());
                adaptadorBD.open();
                Persona persona = (Persona)listRegistros.getItemAtPosition(position);
                String nombre = persona.getNombre();
                adaptadorBD.borrarPersona(nombre);
                listaPersonas = adaptadorBD.getAllPersonas();
                adaptadorBD.close();
                actualizarSeleccion(listaPersonas,listRegistros);
            }
        });

    }

    void actualizarSeleccion(ArrayList<Persona> listaJugadores, ListView lista) {
        AdaptadorNombreSolo adaptadorNombreSolo = new AdaptadorNombreSolo(this, listaJugadores);
        lista.setAdapter(adaptadorNombreSolo);
    }
}
