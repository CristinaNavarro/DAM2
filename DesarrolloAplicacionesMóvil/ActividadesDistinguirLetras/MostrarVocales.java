package com.example.cristi.actividadesletras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarVocales extends AppCompatActivity {

    private TextView tvVocales;
    private Button bTotalVocales;
    private int[] listaVocales = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_vocales);

        tvVocales = (TextView) findViewById(R.id.tvVocales);
        Intent intent = getIntent();
        String recibo = intent.getStringExtra("letras");
        Toast.makeText(getApplicationContext(),"Se recibe " + recibo,Toast.LENGTH_SHORT).show();
        tvVocales.setText(recibo);

        bTotalVocales = (Button) findViewById(R.id.bTotalVocales);
        bTotalVocales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TotalVocales.class);
                for(int i = 0; i < tvVocales.getText().toString().length(); i++){
                    switch (tvVocales.getText().toString().charAt(i)){
                        case 'a':
                            listaVocales[0]++;
                            break;
                        case 'e':
                            listaVocales[1]++;
                            break;
                        case 'i':
                            listaVocales[2]++;
                            break;
                        case 'o':
                            listaVocales[3]++;
                            break;
                        default:
                            listaVocales[4]++;
                            break;
                    }
                }
                intent.putExtra("lista",listaVocales);
                startActivity(intent);
            }
        });
    }
}
