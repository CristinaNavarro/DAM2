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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AutomaticActivity extends AppCompatActivity {
    private ArrayList<Integer> listaNumerosAciertos = new ArrayList<>();
    private ArrayList<Integer> listaNumerosApuesta = new ArrayList<>();
    private LinearLayout linCorrecto;
    private LinearLayout linCorrectoResuelto;
    private LinearLayout linApuestas;
    private Button bParar;
    private boolean estaBarajando = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic);

        linCorrecto = (LinearLayout) findViewById(R.id.linCorrecto);
        prepararLayoutBarajar(linCorrecto);
        linCorrectoResuelto = (LinearLayout) findViewById(R.id.linCorrectoResuelto);
        prepararLayoutResuelto(linCorrectoResuelto);
        linApuestas = (LinearLayout) findViewById(R.id.linApuestas);
        bParar = (Button) findViewById(R.id.bParar);


        for (int i = 0; i < linCorrecto.getChildCount(); i++) {
            if(i%2==0) {
                Glide.with(AutomaticActivity.this)
                        .load(R.drawable.gifaleatorio).into((ImageView) (linCorrecto.getChildAt(i)));
            }else{
                Glide.with(AutomaticActivity.this)
                        .load(R.drawable.gifaleatoriodos).into((ImageView) (linCorrecto.getChildAt(i)));
            }
        }

        Intent intent = getIntent();
        int numeroApuestas = intent.getIntExtra("NumeroApuestas", 1);
        ArrayList<Integer> listadoNumerosApuestas = intent.getIntegerArrayListExtra("ListadoNumeros");

        int ronda = 0;

        for (int i = 0; i < numeroApuestas; i++) {
            LinearLayout linApuesta = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            linApuesta.setLayoutParams(linearParams);
            for (int j = 0; j < 6; j++) {
                if (listadoNumerosApuestas.size() == 0) {
                    int numeroApuesta = (int) (Math.random() * 49 + 1);
                    if (!listaNumerosApuesta.contains(numeroApuesta)) {
                        listaNumerosApuesta.add(numeroApuesta);
                        addTextView(String.valueOf(numeroApuesta), linApuesta, linearParams);
                    } else {
                        j--;
                    }
                } else if (listadoNumerosApuestas.size() < 6) {
                    if (j < listadoNumerosApuestas.size()) {
                        listaNumerosApuesta.add(listadoNumerosApuestas.get(j));
                        addTextView(String.valueOf(listadoNumerosApuestas.get(j)), linApuesta, linearParams);
                    } else {
                        int numeroApuesta = (int) (Math.random() * 49 + 1);
                        if (!listaNumerosApuesta.contains(numeroApuesta)) {
                            listaNumerosApuesta.add(numeroApuesta);
                            addTextView(String.valueOf(numeroApuesta), linApuesta, linearParams);
                        } else {
                            j--;
                        }
                    }
                } else {
                    listaNumerosApuesta.add(listadoNumerosApuestas.get(j + ronda));
                    addTextView(String.valueOf(listadoNumerosApuestas.get(j + ronda)), linApuesta, linearParams);
                }
            }
            ronda += 6;
            int aciertos = 0;
            addTextView(getResources().getString(R.string.aciertos) + " " + aciertos, linApuesta, linearParams);
            linApuestas.addView(linApuesta);
        }
        if (listadoNumerosApuestas.size() == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.toastAutomatico), Toast.LENGTH_SHORT).show();
        } else if (listadoNumerosApuestas.size() < 6) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.toastSemiAutomatico), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.toastManual), Toast.LENGTH_SHORT).show();
        }

        //Permite cambiar entre el layout con los gifs y el que contiene los textview con los valores correctos
        bParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estaBarajando = !estaBarajando;
                prepararLayoutBarajar(linCorrecto);
                prepararLayoutResuelto(linCorrectoResuelto);
                if (!estaBarajando) {

                    TextView tv = new TextView(getApplicationContext());
                    bParar.setText(getResources().getString(R.string.bPararReinicio)); //ver resultado
                    //repasar aciertos

                    for (int j = 0; j < linApuestas.getChildCount(); j++) {
                        int aciertos = 0;
                        LinearLayout linControlAciertos = (LinearLayout) linApuestas.getChildAt(j);

                        for (int i = 0; i < linControlAciertos.getChildCount() - 1; i++) {
                            tv = (TextView) linControlAciertos.getChildAt(i);
                            if (listaNumerosAciertos.contains(Integer.parseInt(tv.getText().toString()))) {
                                aciertos++;
                            }
                            tv = (TextView) linControlAciertos.getChildAt(linControlAciertos.getChildCount() - 1);
                        }
                        tv.setText(getResources().getString(R.string.aciertos) + " " + aciertos);
                    }
                    listaNumerosAciertos.clear();
                } else {
                    bParar.setText(getResources().getString(R.string.bParar)); //barajar
                    for (int i = 0; i < linApuestas.getChildCount(); i++) {
                        LinearLayout linControlAciertos = (LinearLayout) linApuestas.getChildAt(i);
                        for (int j = 0; j < linControlAciertos.getChildCount(); j++) {
                            TextView tv = (TextView) linControlAciertos.getChildAt(linControlAciertos.getChildCount() - 1);
                            tv.setText(getResources().getString(R.string.aciertos) + " " + 0);
                        }
                    }
                }
            }
        });
    }

    //Añade los textview al linearlayout
    public void addTextView(String text, LinearLayout linearLayout, LinearLayout.LayoutParams layoutParams) {
        TextView tv = new TextView(getApplicationContext());
        tv.setTextColor(getResources().getColor(R.color.Marron));
        tv.setTextSize(17);
        tv.setPadding(20, 10, 20, 10);
        tv.setBackground(getResources().getDrawable(R.drawable.imagebuttonborder));
        tv.setText(text);
        tv.setLayoutParams(layoutParams);
        linearLayout.addView(tv);
    }

    //Prepara la visualización del layout con los gifs
    public void prepararLayoutBarajar(LinearLayout linCorrecto) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linCorrecto.getLayoutParams();
        if (estaBarajando) {
            layoutParams.height = 210;
            layoutParams.topMargin = 0;
        } else {
            layoutParams.height = 0;
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        }
        linCorrecto.setLayoutParams(layoutParams);
    }

    //Prepara la visualización del layout con los valores a acertar
    public void prepararLayoutResuelto(LinearLayout linCorrectoResuelto) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linCorrectoResuelto.getLayoutParams();
        if (!estaBarajando) {
            layoutParams.height = 150;
            layoutParams.topMargin = 60;
            layoutParams.bottomMargin = 0;
            for (int i = 0; i < linCorrectoResuelto.getChildCount(); i++) {
                TextView tv = (TextView) linCorrectoResuelto.getChildAt(i);
                tv.setTextSize(35);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setPadding(20, 10, 20, 10);
                tv.setBackground(getResources().getDrawable(R.drawable.imagebuttonborder));
                int numero = (int) (Math.random() * 49 + 1);
                if (!listaNumerosAciertos.contains(numero)) {
                    listaNumerosAciertos.add(numero);
                    tv.setText(String.valueOf(numero));
                } else {
                    i--;
                }
            }
        } else {
            layoutParams.height = 0;
            layoutParams.topMargin = 0;
        }
        linCorrectoResuelto.setLayoutParams(layoutParams);

    }
}




