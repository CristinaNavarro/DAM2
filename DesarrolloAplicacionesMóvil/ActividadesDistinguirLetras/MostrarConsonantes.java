package com.example.cristi.actividadesletras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarConsonantes extends AppCompatActivity {

    private TextView tvConsonantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_consonantes);

        tvConsonantes = (TextView) findViewById(R.id.tvConsonantes);
        Intent intent = getIntent();
        String recibo = intent.getStringExtra("letras");
        tvConsonantes.setText(recibo);
    }
}
