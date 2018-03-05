package com.example.cristi.estudioexamenandroid;
/*
********Autor: Cristina Navarro
********Fecha: 28/01/2018
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	Mi CRUD de SQLite
*/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bCreate;
    private Button bRead;
    private Button bUpdate;
    private Button bDelete;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCreate = (Button) findViewById(R.id.bCreate);
        bCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Create_Activity.class);
                startActivity(intent);
            }
        });

        bRead = (Button) findViewById(R.id.bRead);
        bRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Read_Activity.class);
                startActivity(intent);
            }
        });

        bUpdate = (Button) findViewById(R.id.bUpdate);
        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Update_Activity.class);
                startActivity(intent);
            }
        });

        bDelete = (Button) findViewById(R.id.bDelete);
        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Delete_Activity.class);
                startActivity(intent);
            }
        });
    }
}
