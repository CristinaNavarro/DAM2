package com.example.cristi.viajes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NuevaActividad extends AppCompatActivity {

    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_actividad);

        Intent intent = getIntent();

        tvMensaje = (TextView) findViewById(R.id.tvMensaje);
        tvMensaje.setText(intent.getStringExtra("mensaje"));

    }
}
