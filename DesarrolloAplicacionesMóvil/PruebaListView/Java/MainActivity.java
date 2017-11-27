package com.example.cristi.pruebalistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona[] datos =
                new Persona[]{
                        new Persona("Nombre 1", "Apellido 1", "Apellido 2"),
                        new Persona("Nombre 2", "Apellido 3", "Apellido 4"),
                        new Persona("Nombre 3", "Apellido 5", "Apellido 6"),
                        new Persona("Nombre 3", "Apellido 5", "Apellido 6"),
                        new Persona("Nombre 3", "Apellido 5", "Apellido 6"),
                        new Persona("Nombre 3", "Apellido 5", "Apellido 6")};

        Adaptador adaptador = new Adaptador(this,datos);

        ListView lstOpciones = (ListView)findViewById(R.id.lista);

        lstOpciones.setAdapter(adaptador);
    }
}
