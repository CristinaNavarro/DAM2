package com.example.cristi.actividadesletras;

/*
********Autor: Cristina Navarro
********Fecha: 23/10/2017
********Asignatura:D. de Aplicaciones Moviles
********Ejercicio:	Aplicación de 4 actividades que permite
********enviar vocales a una actividad, consonantes a otra actividad
********y contar el número de veces que la cadena contiene
********cada vocal.
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText etCadena;
    private Button bVocales;
    private Button bConsonantes;
    private String letras;
    private String patron = "[aeiou]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCadena = (EditText) findViewById(R.id.etCadena);
        bVocales = (Button) findViewById(R.id.bVocales);
        bConsonantes = (Button) findViewById(R.id.bConsonantes);
        bVocales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostrarVocales.class);
                eventoIntent(intent, "vocal");
            }
        });
        bConsonantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MostrarConsonantes.class);
                eventoIntent(intent, "consonante");
            }
        });
    }

    private void eventoIntent(Intent intent, String tipo) {
        letras = "";
        for (int i = 0; i < etCadena.getText().toString().length(); i++) {
            char caracter = etCadena.getText().toString().charAt(i);
            if (tipo.equals("vocal") && Pattern.matches(patron, String.valueOf(caracter))) {
                letras += caracter;
            }
            if (!tipo.equals("vocal") && !Pattern.matches(patron, String.valueOf(caracter)) && caracter != ' ') {
                letras += caracter;
            }
        }
        intent.putExtra("letras", letras);
        startActivity(intent);
    }
}
