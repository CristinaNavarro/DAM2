package com.example.cristi.calculadoradigitos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private EditText etNumero;
    private Button bCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = (TextView) findViewById(R.id.tvResultado);
        etNumero = (EditText) findViewById(R.id.etNumero);
        bCalcular = (Button) findViewById(R.id.bCalcular);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int suma=0;
                for(int i=0;i<etNumero.getText().length();i++){
                    suma += Integer.parseInt(etNumero.getText().toString().substring(i,i+1));
                }
                tvResultado.setText(String.valueOf(suma));
            }
        });
    }
}
