package com.example.cristi.estudioexamenandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update_Activity extends AppCompatActivity {

    private EditText etNombreAntiguo;
    private EditText etNombreNuevo;
    private EditText etApellidoNuevo;

    private Button bActualizar;

    private AdaptadorBD adaptadorBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);

        etNombreAntiguo = (EditText) findViewById(R.id.etNombreAntiguo);
        etNombreNuevo = (EditText) findViewById(R.id.etNombreNuevo);
        etApellidoNuevo = (EditText) findViewById(R.id.etApellidoNuevo);

        bActualizar = (Button) findViewById(R.id.bActualizar);
        bActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptadorBD = new AdaptadorBD(getApplicationContext());
                adaptadorBD.open();
                adaptadorBD.modificarPersona(etNombreNuevo.getText().toString(),etApellidoNuevo.getText().toString(),etNombreAntiguo.getText().toString());
                adaptadorBD.close();
            }
        });



    }
}
