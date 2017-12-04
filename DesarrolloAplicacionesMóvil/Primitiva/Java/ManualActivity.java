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
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ManualActivity extends AppCompatActivity {

    private EditText etNumeroManual;
    private int numeroApuestas;
    private LinearLayout linApuestasManual;
    private LinearLayout linValorFijo;
    private ArrayList<Integer> listadoNumerosApuestas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        Intent intent = getIntent();
        numeroApuestas = intent.getIntExtra("NumeroApuestas", 1);


        RadioGroup rgModoManual = (RadioGroup) findViewById(R.id.rgModoManual);
        linValorFijo = (LinearLayout) findViewById(R.id.linValorFijo);
        linApuestasManual = (LinearLayout) findViewById(R.id.linApuestasManual);

        //Evento del RadioGroup que distinguirá entre modo fijo y modo manual
        rgModoManual.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                linApuestasManual.removeAllViews();
                switch (checkedId) {
                    case R.id.rbValorFijo:
                        linValorFijo.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbManual:
                        linValorFijo.setVisibility(View.INVISIBLE);
                        for (int i = 0; i < numeroApuestas; i++) {
                            LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                            for (int j = 0; j < 6; j++) {
                                addEditText(linearLayout);
                            }
                            linApuestasManual.addView(linearLayout);
                        }
                        break;
                }
            }
        });

        Button bSeleccionarManual = (Button) findViewById(R.id.bSeleccionarManual);
        etNumeroManual = (EditText) findViewById(R.id.etNumeroManual);

        //Botón disponible en el modo fijo que permitirá elegir el número de números introducidos manualmente
        bSeleccionarManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regex = "[1-5]";
                if (etNumeroManual.getText().toString().matches(regex)) {
                    listadoNumerosApuestas.clear();
                    LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                    for (int j = 0; j < Integer.parseInt(etNumeroManual.getText().toString()); j++) {
                        addEditText(linearLayout);
                    }
                    linApuestasManual.addView(linearLayout);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.malNumero), Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button bEnviar = (Button) findViewById(R.id.bEnviar);

        //Botón que envía los números introducidos por el jugador
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regex = "[0-9]+";
                listadoNumerosApuestas.clear();
                for (int i = 0; i < linApuestasManual.getChildCount(); i++) {
                    LinearLayout linearLayout = (LinearLayout) linApuestasManual.getChildAt(i);
                    for (int j = 0; j < linearLayout.getChildCount(); j++) {
                        EditText et = (EditText) linearLayout.getChildAt(j);
                        if (et.getText().toString().matches(regex)) {
                            listadoNumerosApuestas.add(Integer.parseInt(et.getText().toString()));
                        }
                    }
                }

                if (apuestaCorrecta()) {
                    linApuestasManual.removeAllViews();
                    Intent intent = new Intent(getApplicationContext(), AutomaticActivity.class);
                    Bundle extras = new Bundle();
                    extras.putInt("NumeroApuestas", numeroApuestas);
                    extras.putIntegerArrayList("ListadoNumeros", listadoNumerosApuestas);
                    intent.putExtras(extras);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.respuestaIncorrectaEnviar), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //Añade un edittext al linearlayout
    public void addEditText(LinearLayout linApuestasManual) {
        EditText et = new EditText(getApplicationContext());
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setHint("0");
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        et.setTextColor(getResources().getColor(R.color.Marron));
        et.setWidth(120);
        et.setHeight(150);
        et.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        et.setBackground(getResources().getDrawable(R.drawable.imagebuttonborder));
        et.setLayoutParams(linearParams);
        linApuestasManual.addView(et);
    }

    //Comprueba que la apuesta no tiene números repetidos
    public boolean apuestaCorrecta() {
        for (int i = 0; i < listadoNumerosApuestas.size(); i += 6) {
            for (int j = i + 1; j < i + 5; j++) {
                if (j < listadoNumerosApuestas.size()) {
                    if (listadoNumerosApuestas.get(i).equals(listadoNumerosApuestas.get(j))
                            || listadoNumerosApuestas.get(i) > 49 || listadoNumerosApuestas.get(i) < 1
                            || listadoNumerosApuestas.get(j) > 49 || listadoNumerosApuestas.get(j) < 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
