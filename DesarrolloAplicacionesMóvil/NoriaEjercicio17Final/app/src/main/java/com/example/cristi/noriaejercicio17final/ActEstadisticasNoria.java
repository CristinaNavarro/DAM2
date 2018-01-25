package com.example.cristi.noriaejercicio17final;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Random;

public class ActEstadisticasNoria extends AppCompatActivity {

    private ArrayList<TextView> listTextView = new ArrayList<>();
    int totalPersonas;
    private long[] totales = new long[ConfiguracionLocal.MAXIMONORIAS];
    private LinearLayout linearSeleccionDatosMostrar;
    private BarChart graph;
    private String[] numeroNorias = new String[ConfiguracionLocal.MAXIMONORIAS];
    private String[] numeroViajes = new String[ConfiguracionLocal.MAXIMOVIAJES];
    private Spinner spinnerViaje;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas_noria);
        Toast.makeText(getApplicationContext(), R.string.cargandoInformacion, Toast.LENGTH_SHORT).show();

        listTextView.add((TextView) findViewById(R.id.tvPrueba));
        listTextView.add((TextView) findViewById(R.id.tvBusquedaConcreta));

        graph = (BarChart) findViewById(R.id.graph);

        rellenarDatos();

        /*
         * Carga y actualización a tiempo real de los datos mostrados en la gráfica
         */
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("norias");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                for (DataSnapshot snapshotViaje : dataSnapshot.getChildren()) {
                    switch (dataSnapshot.getKey()) {
                        case "noria1":
                            totales[0] += snapshotViaje.getChildrenCount();
                            break;
                        case "noria2":
                            totales[1] += snapshotViaje.getChildrenCount();
                            break;
                        case "noria3":
                            totales[2] += snapshotViaje.getChildrenCount();
                            break;
                    }
                }
                totalPersonas = (int) (totales[0] + totales[1] + totales[2]);
                listTextView.get(0).setText(getResources().getString(R.string.totalPersonas) + ": " + totalPersonas);
                actualizarGrafica(totales);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                reiniciarTotales(dataSnapshot.getKey());
                this.onChildAdded(dataSnapshot, s);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Spinner spinner;
        ArrayAdapter<String> adapter;

        /*
         * LinearLayout que contiene las distintas norias y horas para conocer cuántas personas han
         * comprado un billete en determinada noria y hora
         */
        linearSeleccionDatosMostrar = (LinearLayout) findViewById(R.id.linearSeleccionDatosMostrar);
        for (int i = 0; i < linearSeleccionDatosMostrar.getChildCount(); i++) {
            switch (i) {
                case 0:
                    spinner = (Spinner) linearSeleccionDatosMostrar.getChildAt(i);
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numeroNorias);
                    spinner.setAdapter(adapter);
                    break;
                case 1:
                    spinner = (Spinner) linearSeleccionDatosMostrar.getChildAt(i);
                    adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numeroViajes);
                    spinner.setAdapter(adapter);
                    break;
                case 2:
                    Button button = (Button) linearSeleccionDatosMostrar.getChildAt(i);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Spinner spinnerNoria = (Spinner) linearSeleccionDatosMostrar.getChildAt(0);
                            spinnerViaje = (Spinner) linearSeleccionDatosMostrar.getChildAt(1);
                            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("norias/noria" + (spinnerNoria.getSelectedItemPosition() + 1));



                            ref.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    if (dataSnapshot.getKey().equals("viaje" + (spinnerViaje.getSelectedItemPosition() + 1))) {
                                     listTextView.get(1).setText(getResources().getString(R.string.busquedaNoria)+ " \""
                                             + getResources().getString(ConfiguracionLocal.codigoNoria[spinnerNoria.getSelectedItemPosition()]) +"\" " +getResources().getString(R.string.busquedaViaje)
                                             + " \"" +ConfiguracionLocal.horas[spinnerViaje.getSelectedItemPosition()] + "\" "
                                             + getResources().getString(R.string.busquedaClientes) + " " + dataSnapshot.getChildrenCount() + " "
                                             + getResources().getString(R.string.plazas));
                                    }
                                }

                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                                }

                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) {

                                }

                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }
                    });
            }
        }
    }






    /*
     * Método que reinicia el valor del total de personas de un viaje
     * para que no exista solapamiento de información
     */
    void reiniciarTotales(String key) {
        int posicion = Integer.parseInt(key.substring(5));
        totales[posicion-1] = 0;
    }

    /*
     * Método que actualiza la información mostrada en la gráfica a tiempo real
     */
    void actualizarGrafica(long[] totales) {
        ArrayList<BarEntry> listValores = new ArrayList<>();
        listValores.add(new BarEntry(1f, totales[0]));
        listValores.add(new BarEntry(2f, totales[1]));
        listValores.add(new BarEntry(3f, totales[2]));

        BarDataSet barDataSet = new BarDataSet(listValores, "datos");
        cambiarColorGrafica(barDataSet);


        barDataSet.setLabel(getResources().getString(R.string.noria1) + " -- " + getResources().getString(R.string.noria2) + " -- " + getResources().getString(R.string.noria3));


        BarData barData = new BarData();
        barData.setValueTextColor(R.color.azulOscuro);
        barData.addDataSet(barDataSet);
        graph.removeAllViews();
        graph.setData(barData);
        graph.getDescription().setText("");
    }

    /*
     * Método que cambia los colores de las barras de la gráfica
     */
    void cambiarColorGrafica(BarDataSet dataSet) {
        int[] colors = {hallarColor(),hallarColor(),hallarColor()};
        dataSet.setColors(colors);
    }

    /*
     * Método que halla un color para la barra de la gráfica, evitando
     * colores azules
     */
    int hallarColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), 0);
    }

    /*
     * Método que rellena los Spinner de la información sobre las norias y los horarios de viajes
     */
    void rellenarDatos() {
        for (int i = 0; i < numeroViajes.length; i++) {
            if (ConfiguracionLocal.MAXIMONORIAS > i) {
                numeroNorias[i] = getResources().getString(ConfiguracionLocal.codigoNoria[i]);
            }
            numeroViajes[i] = ConfiguracionLocal.horas[i];
        }
    }

}
