package com.example.cristi.tragaperras;
/*
********Autor: Cristina Navarro*********************
********Fecha: 03/10/2017***************************
********Asignatura:D. de Aplicaciones Moviles*******
********Ejercicio:	Aplicación de una sola *********
******** actividad, que simula una tragaperras. Se**
******** comienza con 5€ para intentos. Si se llega*
******** a 0€, se puede pulsar un botón para *******
******** reiniciar la partida. Se puede elegir *****
******** la dificultad. A menor dificultad, más ****
******** cara la jugada. Si se consigue una triple *
******** combinación, se gana 5€, ******************
******** independientemente de la dificultad.*******
*/


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private TextView tvCantidad;
    private TextView tvNumeroIntentos;
    private Button bJugar;
    private Button bReiniciar;
    private LinearLayout linearNumeros;
    private RadioGroup rgDificultad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creación de objetos////////////////////////////////////////////////////
        tvCantidad = (TextView) findViewById(R.id.tvCantidad);
        tvNumeroIntentos = (TextView) findViewById(R.id.tvNumeroIntentos);
        bJugar = (Button) findViewById(R.id.bJugar);
        bReiniciar = (Button) findViewById(R.id.bInsertarDinero);
        linearNumeros = (LinearLayout) findViewById(R.id.linearNumeros);
        rgDificultad = (RadioGroup) findViewById(R.id.rgDificultad);


        //////Listeners//////////////////////////////////////////////////////////
        //método al pulsar el botón jugar
        bJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumaIntento();
                int dificultad = hallarDificultad();
                if(dificultad==0){
                    Toast.makeText(getApplicationContext(),R.string.noDificultad,Toast.LENGTH_SHORT).show();
                }else {
                    for (int i = 0; i < linearNumeros.getChildCount(); i++) {
                        TextView tv = (TextView) linearNumeros.getChildAt(i);
                        tv.setText(hallarNumero(dificultad));
                    }
                    comprobarGanador();
                    comprobarRestante();
                }
            }
        });

        //método al pulsar el botón reiniciar, reinicia el dinero, habilita todos los botones y reinicia los intentos
        bReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCantidad.setText(R.string.tvCantidadReinicio);
                bJugar.setEnabled(true);
                for (int i = 0; i < rgDificultad.getChildCount(); i++) {
                    RadioButton rbChecked = (RadioButton) rgDificultad.getChildAt(i);
                    rbChecked.setEnabled(true);
                    rbChecked.setChecked(false);
                }
                RadioButton rbChecked = (RadioButton) rgDificultad.getChildAt(0);
                rbChecked.setChecked(true);
                tvNumeroIntentos.setText("0");
            }
        });
    }


    //////Métodos///////////////////////////////////////////////////////////////////////////////////
    //halla un número en un rango acotado según la dificultad
    public String hallarNumero(int dificultad) {
        return String.valueOf((int) Math.floor((Math.random() * dificultad) + 1));
    }

    //comprueba el resultado de la jugada y reajusta la cantidad de dinero
    public void comprobarGanador() {
        boolean iguales = true;
        TextView tv = (TextView) linearNumeros.getChildAt(0);
        String inicial = tv.getText().toString();
        for (int i = 1; i < linearNumeros.getChildCount(); i++) {
            TextView tvComparacion = (TextView) linearNumeros.getChildAt(i);
            if (!inicial.equals(tvComparacion.getText().toString())) {
                iguales = false;
            }
        }
        if (iguales) {
            int cantidad = Integer.parseInt(tvCantidad.getText().toString());
            cantidad += 5;
            tvCantidad.setText(String.valueOf(cantidad));
            Toast.makeText(getApplicationContext(), R.string.premio, Toast.LENGTH_SHORT).show();
        } else {
            int cantidad = Integer.parseInt(tvCantidad.getText().toString());
            if (cantidad != 0) {
                for(int i = rgDificultad.getChildCount()-1;i>=0;i--){
                    RadioButton rbComprobacion = (RadioButton) rgDificultad.getChildAt(i);
                    if(rbComprobacion.isChecked()){
                        cantidad -= (rgDificultad.getChildCount()-i);

                    }
                }
            }
            tvCantidad.setText(String.valueOf(cantidad));
        }
    }

    //calcula la cantidad restante de dinero y deshabilita las dificultades para las que no quede presupuesto
    public void comprobarRestante() {
        int restante = Integer.parseInt(tvCantidad.getText().toString());
        for(int i = rgDificultad.getChildCount()-1;i>=0;i--){
            if(restante<(rgDificultad.getChildCount()-i)){
                RadioButton rbComprobacion = (RadioButton) rgDificultad.getChildAt(i);
                rbComprobacion.setEnabled(false);
                rbComprobacion.setChecked(false);
            }else{
                RadioButton rbComprobacion = (RadioButton) rgDificultad.getChildAt(i);
                rbComprobacion.setEnabled(true);
            }
        }
        if(restante==0){
            bJugar.setEnabled(false);
        }
    }


    //suma un intento cada vez que se pulsa el botón jugar
    public void sumaIntento() {
        int intentos = Integer.parseInt(tvNumeroIntentos.getText().toString());
        intentos++;
        tvNumeroIntentos.setText(String.valueOf(intentos));
    }


    //permite controlar el rango de dificultad del juego, aumenta en 3 números cada dificultad
    public int hallarDificultad() {
        for (int i = 0; i < rgDificultad.getChildCount(); i++) {
            RadioButton rbChecked = (RadioButton) rgDificultad.getChildAt(i);
            if (rbChecked.isChecked()) {
                return ((i+1) * 3);
            }
        }
        return 0;
    }
}
