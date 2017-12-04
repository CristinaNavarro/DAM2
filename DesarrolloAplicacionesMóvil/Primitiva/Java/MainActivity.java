package com.example.cristi.primitiva;

/*
********Autor: Cristina Navarro
********Fecha: 21/11/2017
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	Aplicación que simula un juego
********de primitiva. Consta de dos modos: automático
********y manual. Dentro del modo manual, se podrá elegir
********si queremos añadir solo algunos valores o todos.
********Si elegimos introducir algunos valores fijos, estos
********aparecerán en todas las apuestas.
********Las apuestas no podrán tener números repetidos.
********Finalmente, al pulsar en el botón SORTEAR, se dan
********a conocer los aciertos de cada apuesta.
*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout estructuraImagenButton = (GridLayout) findViewById(R.id.estructuraImagenButton);
        editText = (EditText) estructuraImagenButton.getChildAt(2);

        for (int i = 0; i < estructuraImagenButton.getChildCount() - 1; i++) {
            switch (i) {
                case 0: //Línea de textview
                    break;
                case 1: //Línea de imagebutton
                    LinearLayout linearLayout = (LinearLayout) estructuraImagenButton.getChildAt(i);
                    for (int j = 0; j < linearLayout.getChildCount(); j++) {
                        ImageButton imageButton = (ImageButton) findViewById(linearLayout.getChildAt(j).getId());
                        switch (j) {
                            case 0:
                                //Automático
                                imageButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(), AutomaticActivity.class);
                                        enviarInformacion(intent);
                                    }
                                });
                                break;
                            case 1:
                                //Manual
                                imageButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(getApplicationContext(), ManualActivity.class);
                                        enviarInformacion(intent);
                                    }
                                });
                                break;
                        }
                    }
                    break;
            }
        }
    }

    //Comprueba si la información es correcta y, si es así, la envía
    public void enviarInformacion(Intent intent) {
        ArrayList<Integer> lista = new ArrayList<>();
        String regex = "[1-5]";
        if (editText.getText().toString().matches(regex)) {
            Bundle extras = new Bundle();
            extras.putInt("NumeroApuestas", Integer.parseInt(editText.getText().toString()));
            extras.putIntegerArrayList("ListadoNumeros",lista);
            intent.putExtras(extras);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.malNumero), Toast.LENGTH_SHORT).show();
        }

    }
}
