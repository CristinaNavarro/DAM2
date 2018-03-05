package com.example.cristi.guardardatoslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Persona> listaPersonas = new ArrayList<>();

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Button bGuardar = (Button) linearLayout.getChildAt(2);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNombre = (EditText) linearLayout.getChildAt(0);
                EditText etApellidos = (EditText) linearLayout.getChildAt(1);
                if(!etNombre.getText().toString().equals("") && !etApellidos.getText().toString().equals("")) {
                    listaPersonas.add(new Persona(etNombre.getText().toString(), etApellidos.getText().toString()));
                    actualizar(listaPersonas);
                }
            }
        });
    }

    //Introduce los datos en el listView
    void actualizar(ArrayList<Persona> listaPersonas) {
        Adaptador adaptador = new Adaptador(this,listaPersonas);
        ListView lstOpciones = (ListView)findViewById(R.id.lista);
        lstOpciones.setAdapter(adaptador);
    }
}
