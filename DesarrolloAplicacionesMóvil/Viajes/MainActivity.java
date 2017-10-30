package com.example.cristi.viajes;

/*
********Autor: Cristina Navarro*********************
********Fecha: 18/10/2017***************************
********Asignatura:D. de Aplicaciones Moviles*******
********Ejercicio:	Aplicación de una sola *********
******** actividad, que simula el presupuesto de ***
******** un viaje. Se ha añadido un listener en el**
******** el EditText para actualizar el precio si el
******** usuario selecciona antes la opción y ******
******** después el número de personas.*************
*/

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private GridLayout glGeneral;
    private TextView tvMostrarPrecio;
    private Button bNuevaActividad;
    private int[] listaPrecios = {0, 0, 0, 0};
    private final String SIMBOLOSPLIT = "-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glGeneral = (GridLayout) findViewById(R.id.glEstructuraGeneral);
        tvMostrarPrecio = (TextView) findViewById(R.id.tvMostrarPrecio);

        bNuevaActividad = (Button) findViewById(R.id.bNuevaActividad);
        bNuevaActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NuevaActividad.class);
                intent.putExtra("mensaje",tvMostrarPrecio.getText().toString());
                startActivity(intent);
            }
        });


        //Establece como seleccionado el primer RadioButton de cada RadioGroup y pone a cada EditText 1 como texto
        for (int i = 0; i < glGeneral.getChildCount(); i++) {
            GridLayout gl = (GridLayout) findViewById(glGeneral.getChildAt(i).getId());
            RadioGroup rg = (RadioGroup) findViewById(gl.getChildAt(1).getId());
            RadioButton rb = (RadioButton) findViewById(rg.getChildAt(0).getId());
            EditText et = (EditText) findViewById(gl.getChildAt(3).getId());
            et.setText("1");
            rb.setChecked(true);
        }

        //Añade listener a cada RadioGroup y EditText
        for(int i = 0; i < glGeneral.getChildCount(); i++){
            GridLayout gl = (GridLayout) findViewById(glGeneral.getChildAt(i).getId());
            RadioGroup rg = (RadioGroup) findViewById(gl.getChildAt(1).getId());
            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    calcularApartado();
                    calcularTotal();
                }
            });
            EditText et = (EditText) findViewById(gl.getChildAt(3).getId());
            et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    calcularApartado();
                    calcularTotal();
                }
            });
        }
    }

    //Métodos//////////////////////////////////////////////////////////////
    //Calcula el precio total, recorriendo los RadioGroup y los EditText
    public void calcularApartado(){
        String regex = "^[1-9]+";
        for(int i = 0; i < glGeneral.getChildCount(); i++){
            GridLayout gl = (GridLayout) findViewById(glGeneral.getChildAt(i).getId());
            RadioGroup rg = (RadioGroup) findViewById(gl.getChildAt(1).getId());
            RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

            EditText et = (EditText) findViewById(gl.getChildAt(3).getId());
            if(et.getText().toString().matches(regex)) {
                listaPrecios[i] = hallarPrecio(rb) * Integer.parseInt(et.getText().toString());
            }
        }
    }

    //Modifica el valor del TextView que muestra el precio
    public void calcularTotal(){
        int total = 0;
        for(int i = 0; i < listaPrecios.length; i++){
            total += listaPrecios[i];
        }
        tvMostrarPrecio.setText(String.valueOf(total));
    }

    //Extrae el precio del RadioButton seleccionado
    public int hallarPrecio(RadioButton rb){
        String[] precio = rb.getText().toString().split(SIMBOLOSPLIT);
        return Integer.parseInt(precio[1].substring(1,precio[1].length()));
    }
}
