package com.example.cristi.actividadesletras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

public class TotalVocales extends AppCompatActivity {

    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_vocales);

        Intent intent = getIntent();
        int[] lista = intent.getIntArrayExtra("lista");

        grid = (GridLayout) findViewById(R.id.grid);
        int arrayContador = 0;
        for(int i = 0; i < grid.getChildCount(); i++){
            if(i%2 != 0){
                TextView tv = (TextView) findViewById(grid.getChildAt(i).getId());
                tv.setText(""+lista[arrayContador]);
                arrayContador++;
            }
        }
    }
}
