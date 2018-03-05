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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Create_Activity extends AppCompatActivity {

    private Button bCrearBBDD;
    private Button bInsertar;
    private EditText etNombre;
    private EditText etApellidos;
    private ListView listRegistros;
    private AdaptadorBD adaptadorBD;
    private ArrayList<Persona> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__activity);

        bCrearBBDD = (Button) findViewById(R.id.bCrearBBDD);
        bCrearBBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptadorBD = new AdaptadorBD(getApplicationContext());
            }
        });

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellidos = (EditText) findViewById(R.id.etApellido);
        listRegistros = (ListView) findViewById(R.id.listRegistros);

        bInsertar = (Button) findViewById(R.id.bInsertar);
        bInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptadorBD.open();
                adaptadorBD.insertarPersona(new Persona(etNombre.getText().toString(),etApellidos.getText().toString()));
                listaPersonas = adaptadorBD.getAllPersonas();
                actualizarSeleccion(listaPersonas,listRegistros);
                adaptadorBD.close();
            }
        });

    }

    void actualizarSeleccion(ArrayList<Persona> listaJugadores, ListView lista) {
        AdaptadorNombreSolo adaptadorNombreSolo = new AdaptadorNombreSolo(this, listaJugadores);
        lista.setAdapter(adaptadorNombreSolo);
    }
}
