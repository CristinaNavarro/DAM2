package com.example.cristi.estudioexamenandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Read_Activity extends AppCompatActivity {

    private ListView listRegistros;
    private ArrayList<Persona> listaJugadores = new ArrayList<>();
    private AdaptadorBD adaptadorBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_);

        adaptadorBD = new AdaptadorBD(getApplicationContext());
        listRegistros = (ListView) findViewById(R.id.listRegistros);
        adaptadorBD.open();
        listaJugadores = adaptadorBD.getAllPersonas();
        adaptadorBD.close();
        actualizarSeleccion(listaJugadores,listRegistros);
    }

    void actualizarSeleccion(ArrayList<Persona> listaJugadores, ListView lista) {
        AdaptadorNombreSolo adaptadorNombreSolo = new AdaptadorNombreSolo(this, listaJugadores);
        lista.setAdapter(adaptadorNombreSolo);
    }
}
