package com.example.cristi.noriaejercicio17final;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearMain;
    private ArrayList<Noria> arrayListNoria = new ArrayList<>();
    private Handler mHandler = new Handler();
    private ConstraintLayout cFondo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearMain = (LinearLayout) findViewById(R.id.linearMain);
        cFondo = (ConstraintLayout) findViewById(R.id.cFondo);

        /*
         * Creación e inclusión de Norias en ListView
         */
        final ListView listNorias = (ListView) linearMain.getChildAt(1);
        for (int i = 1; i <= ConfiguracionLocal.MAXIMONORIAS; i++) {

            arrayListNoria.add(new Noria(i, "noria" + i));
        }
        AdaptadorListViewNorias adaptador = new AdaptadorListViewNorias(this, arrayListNoria);
        listNorias.setAdapter(adaptador);

        /*
         * Envío de información de otra actividad dependiendo del elemento del ListView seleccionado
         */
        listNorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ActHorarioNoria.class);
                Bundle b = new Bundle();
                b.putInt("nombreNoria", ConfiguracionLocal.codigoNoria[position]);
                b.putInt("idnoria", position + 1);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        /*
         * Eventos de botones
         * case 2: muestra otra actividad con datos estadísticos
         * case 3: elimina información de la bbdd
         */
        for (int i = 2; i < linearMain.getChildCount(); i++) {
            Button button = (Button) linearMain.getChildAt(i);
            switch (i) {
                case 3:
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder ventana = new AlertDialog.Builder(MainActivity.this, R.style.myDialog);
                            ventana.setTitle(getResources().getString(R.string.confirmacion));
                            ventana.setMessage(getResources().getString(R.string.borrar));
                            ventana.setCancelable(false);
                            ventana.setPositiveButton(getResources().getString(R.string.confirmar), new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {
                                    ConfiguracionFirebase.limpiarBBDD();
                                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.datosBorrados), Toast.LENGTH_SHORT).show();
                                }
                            });
                            ventana.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo1, int id) {
                                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.datosNoBorrados), Toast.LENGTH_SHORT).show();
                                }
                            });
                            ventana.show();
                        }
                    });
                    break;
                case 2:
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), ActEstadisticasNoria.class);
                            startActivity(intent);
                        }
                    });
                    break;
            }
        }

        /*
         * Hilo que modificará el fondo del menú principal
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                     puenteAccionHilo();

                }
            }
        }).start();
    }


    /*
     * Método que permite modificar los datos desde la actividad en la que se ha
     * iniciado el hilo
     */
    public void puenteAccionHilo() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                // This gets executed on the UI thread so it can safely modify Views
                Random random = new Random();
                cFondo.setBackground(getResources().getDrawable(ConfiguracionLocal.codigoFondo[random.nextInt(5)]));
            }
        });
    }
}
