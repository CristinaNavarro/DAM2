package com.example.cristi.ejercicioslayout;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private Spinner spNombre;
    private EditText etIntroprimero;
    private EditText etIntroSegundo;
    private Button bPulsa;
    private TextView tvResultadoHipotenusa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
       /* ACTIVITY_MAIN*********************************************************
        int ot = getResources().getConfiguration().orientation;
        switch (ot) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
        }

        spNombre = (Spinner) findViewById(R.id.spNombre);


        List<String> lista =  new ArrayList<String>();
        lista.add(getString(R.string.nombreConcoja));
        lista.add(getString(R.string.nombreOtro));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNombre.setAdapter(adapter);
        */

        /*ACTIVITY2********************************************************************
        int ot = getResources().getConfiguration().orientation;
        switch (ot) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity2_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity2);
                break;
        }*/

        /*ACTIVITY3*********************************************************************/

        etIntroprimero = (EditText) findViewById(R.id.etIntroPrimero);
        etIntroSegundo = (EditText) findViewById(R.id.etIntroSegundo);
        bPulsa = (Button) findViewById(R.id.bPulsa);
        tvResultadoHipotenusa = (TextView) findViewById(R.id.tvResultadoHipotenusa);

        bPulsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Calculado",Toast.LENGTH_LONG).show();
               tvResultadoHipotenusa.setText("Resultado: "+Math.sqrt(Math.pow(Double.parseDouble(etIntroprimero.toString()),Double.parseDouble(etIntroprimero.toString()))+Math.pow(Integer.parseInt(etIntroSegundo.toString()),Integer.parseInt(etIntroSegundo.toString()))));
            }
        });

        int ot = getResources().getConfiguration().orientation;
        switch (ot) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity3_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity3);
                break;
        }





    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);

       /*ACTIVITY_MAIN*******************************************************************
        int ot = getResources().getConfiguration().orientation;
        switch (ot) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity_main_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity_main);
                break;
        }*/


       /*ACTIVITY2***************************************************************************

        int ot = getResources().getConfiguration().orientation;
        switch (ot) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity2_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity2);
                break;
        }*/

       /* ACTIVITY3*************************************************************************/
       int ot = getResources().getConfiguration().orientation;
        switch (ot) {
            case Configuration.ORIENTATION_LANDSCAPE:
                setContentView(R.layout.activity3_land);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                setContentView(R.layout.activity3);
                break;
        }
    }
}
