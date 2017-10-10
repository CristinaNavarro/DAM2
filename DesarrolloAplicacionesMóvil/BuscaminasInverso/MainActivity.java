package com.example.cristi.buscaminasinverso;

/*
********Autor: Cristina Navarro*********************
********Fecha: 10/10/2017***************************
********Asignatura:D. de Aplicaciones Moviles*******
********Ejercicio:	Aplicación de una sola *********
******** actividad, que simula un buscaminas inverso
******** Comienza con dos intentos, el jugador elige
******** el número de botones con los que jugar. Los
******** intentos no dependerán del número de ******
******** botones. Solo se puede pulsar una vez cada*
******** botón. Se le puede dar a iniciar en *******
******** cualquier momento para reiniciar el juego.*
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridLayout glBotones;
    private EditText etBotones;
    private Button bIniciar;
    private TextView tvMostrarIntentos;
    private int MINAS = 2;
    private ArrayList<Integer> listaPremio = new ArrayList<>();
    int numeroBotones = 16;
    int aciertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        glBotones = (GridLayout) findViewById(R.id.glBotones);
        etBotones = (EditText) findViewById(R.id.etBotones);
        bIniciar = (Button) findViewById(R.id.bIniciar);
        tvMostrarIntentos = (TextView) findViewById(R.id.tvMostrarIntentos);


        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if ((Integer.parseInt(etBotones.getText().toString()) <= 16) &&
                            (Integer.parseInt(etBotones.getText().toString()) > MINAS)) {
                        reiniciar();
                        prepararPremios();
                        prepararPartida();
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),R.string.noNumero,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    //Método que sitúa el premio en los botones y les asigna un evento conforme a ello
    public void prepararPartida(){
        numeroBotones = Integer.parseInt(etBotones.getText().toString());
        for (int i = numeroBotones; i < glBotones.getChildCount(); i++) {
            glBotones.getChildAt(i).setVisibility(View.INVISIBLE);
        }
        for (int i = 0; i < numeroBotones; i++) {
            Button b = (Button) glBotones.getChildAt(i);
            b.setVisibility(View.VISIBLE);
            if(listaPremio.contains(i)){
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!tvMostrarIntentos.getText().toString().equals("0")) {
                            Button b2 = (Button) findViewById(v.getId());
                            b2.setText(":)");
                            aciertos++;
                            restarIntento();
                            imprimirPremio();
                        }
                    }
                });
            }else{
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!tvMostrarIntentos.getText().toString().equals("0")) {
                            Button b2 = (Button) findViewById(v.getId());
                            restarIntento();
                            imprimirFallo();
                            b2.setOnClickListener(null);
                        }
                    }
                });
            }
        }
    }

    //Método que determina los botones con premio
    public void prepararPremios(){
        boolean iguales;

        do {
            iguales = false;
            for (int i = 0; i < MINAS; i++) {
                listaPremio.add(hallarRandom());
            }

            for (int i = 0; i < MINAS - 1; i++) {
                if (listaPremio.get(i).equals(listaPremio.get(i + 1))) {
                    iguales = true;
                }
            }
            if(iguales){
                listaPremio.clear();
            }
        }while (iguales);
    }

    //Método que halla un número random
    public int hallarRandom(){
        return (int)Math.floor(Math.random()*Integer.parseInt(etBotones.getText().toString()));
    }

    //Método que muestra un Toast con los botones premiados o las minas restantes
    public void imprimirPremio() {
        if(aciertos==MINAS) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.ganador)
                    + listaPremio.get(0) + " " + listaPremio.get(1), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.acierto) +(MINAS-aciertos),Toast.LENGTH_SHORT).show();
        }
    }

    //Método que muestra un Toast indicando que se ha fallado o se han terminado los intentos
    public void imprimirFallo(){
        if(tvMostrarIntentos.getText().toString().equals("0")){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.perdedor) +listaPremio.get(0) +" " +listaPremio.get(1),Toast.LENGTH_SHORT).show();
        }else if(aciertos<MINAS){
            Toast.makeText(getApplicationContext(),R.string.fallo,Toast.LENGTH_SHORT).show();
        }
    }

    //Método que escribe "?" en todos los botones, reinicia la lista de botones con premio,
    // reinicia los aciertos y devuelve los dos intentos
    public void reiniciar(){
        for(int i=0;i<numeroBotones;i++){
            Button b = (Button) findViewById(glBotones.getChildAt(i).getId());
            b.setText(R.string.bBusquedaTexto);
        }
        if(!listaPremio.isEmpty()) {
            listaPremio.clear();
        }
        tvMostrarIntentos.setText(String.valueOf(MINAS));
        aciertos = 0;
    }

    //Método que resta un intento cada vez que se pulsa un botón
    public void restarIntento(){
        int intento = Integer.parseInt(tvMostrarIntentos.getText().toString());
        intento--;
        tvMostrarIntentos.setText(String.valueOf(intento));
    }
}
