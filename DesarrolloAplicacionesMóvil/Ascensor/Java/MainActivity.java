package com.example.cristi.ascensor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private LinearLayout linearEstructura;
    private TextView tvMostrarDireccion;
    private TextView tvMostrarPiso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creacion de linearLayout y textView
        linearEstructura = (LinearLayout) findViewById(R.id.linearEstructura);
        tvMostrarDireccion = (TextView) findViewById(R.id.tvMostrarDireccion);
        tvMostrarPiso = (TextView) findViewById(R.id.tvMostrarPiso);


        //Creacion de botones y asignacion de listener
        for (int i = 0; i < linearEstructura.getChildCount(); i++) {
            linearEstructura.getChildAt(i).setOnClickListener(
                    new View.OnClickListener() {
                        //@Override
                        public void onClick(View v) {
                            Button b = (Button) findViewById(v.getId()); //boton virtual que permite
                                                                        // reconocer cual ha sido pulsaldo
                            modificar(b);
                        }
                    });
        }
    }

    //modificacion de los textview segun el boton pulsado
    public void modificar(Button button) {
        if (button.getText().toString().equals(tvMostrarPiso.getText().toString())) {
            tvMostrarDireccion.setText(R.string.noSeMueve);
        } else if (Integer.parseInt(button.getText().toString()) > Integer.parseInt(tvMostrarPiso.getText().toString())) {
            tvMostrarDireccion.setText(R.string.sube);
            tvMostrarPiso.setText(button.getText().toString());
        } else {
            tvMostrarDireccion.setText(R.string.baja);
            tvMostrarPiso.setText(button.getText().toString());
        }
    }
}
