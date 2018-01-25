package com.example.cristi.noriaejercicio17final;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ActClientesNoria extends AppCompatActivity {

    private LinearLayout linearClientes;
    private int idNoria;
    private int idViaje;
    private LinearLayout linearIntroduccionCliente;
    private ArrayList<Persona> arrayListPersona = new ArrayList<>();
    private TextView textView;
    private boolean[] plazaOcupada = new boolean[ConfiguracionLocal.MAXIMOPERSONAS];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_noria);

        Intent intentRecibido = getIntent();
        Bundle bRecibido = intentRecibido.getExtras();

        idNoria = bRecibido.getInt("idnoria", 1);
        idViaje = bRecibido.getInt("idviaje", 1);
        linearClientes = (LinearLayout) findViewById(R.id.linearClientes);


        /*
         * Bucle que recorre los distintos elementos del layout principal de la actividad
         * case 0 y 1: recoge información sobre la noria y el viaje.
         * case 2: incluye la información sobre la persona a añadir.
         * case 3: incluye el listener del listView, permitiendo eliminar a la persona haciendo
         *         click encima de su nombre. Se ha añadido un listener necesario para seleccionar
         *         un nodo por el nombre de la persona en lugar de su id.
         */
        for (int i = 0; i < linearClientes.getChildCount(); i++) {
            switch (i) {
                case 0:
                    modificarTextView(i, getResources().getString(ConfiguracionLocal.codigoNoria[idNoria-1]));
                    break;
                case 1:
                    modificarTextView(i, ConfiguracionLocal.horas[idViaje-1]);
                    break;
                case 3:
                    final ListView listView = (ListView) linearClientes.getChildAt(i);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            LinearLayout linearLayout = (LinearLayout) parent.getChildAt(position);
                            final TextView persona = (TextView) linearLayout.getChildAt(0);
                            DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
                            final Query query = firebaseDatabase.child("norias").child("noria" + idNoria).child("viaje"+idViaje).orderByChild("nombre").equalTo(persona.getText().toString());
                            query.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                        Persona persona = snap.getValue(Persona.class);
                                        int numeroPlaza = Integer.parseInt(snap.getKey().substring(7));
                                        plazaOcupada[numeroPlaza - 1] = false;
                                        eliminarPersona(persona.getNombre());
                                        actualizar();
                                        snap.getRef().removeValue();
                                        modificarTextView(4, getResources().getString(R.string.plazasOcupadas) + ": " + numeroPlazasOcupadas() + "/" + ConfiguracionLocal.MAXIMOPERSONAS);
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                    });
                    break;
                case 4:
                    textView = (TextView) linearClientes.getChildAt(i);
                    textView.setText(numeroPlazasOcupadas());
                default:
                    break;
            }
        }


        /*
         * Listener de cada una de las personas del viaje seleccionado, que permitirá recoger y presentar
         * en el listView la información de la base de datos.
         */
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("norias").child("noria" + idNoria).child("viaje" + idViaje);
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Persona persona = dataSnapshot.getValue(Persona.class);
                int numeroPlaza = Integer.parseInt(dataSnapshot.getKey().substring(7));
                plazaOcupada[numeroPlaza - 1] = true;
                arrayListPersona.add(persona);
                actualizar();
                modificarTextView(4, getResources().getString(R.string.plazasOcupadas) +": " + numeroPlazasOcupadas() + "/" + ConfiguracionLocal.MAXIMOPERSONAS);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*
         * Listener del botón destinado a añadir a una persona en el viaje
         */
        linearIntroduccionCliente = (LinearLayout) linearClientes.getChildAt(2);
        Button button = (Button) linearIntroduccionCliente.getChildAt(1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout layout = (TextInputLayout) linearIntroduccionCliente.getChildAt(0);
                FrameLayout frame = (FrameLayout) layout.getChildAt(0);
                TextInputEditText textInputEditText = (TextInputEditText) frame.getChildAt(0);
                if (!nombreRepetido(textInputEditText.getText().toString()) && textInputEditText.getText().toString().length() > 0) {
                    int idPersona = plazaLibre();
                    if (idPersona != -1) {
                        ConfiguracionFirebase.insertar(idNoria, idViaje, idPersona, new Persona(textInputEditText.getText().toString()));
                        textInputEditText.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), R.string.plazasCompletas, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), R.string.nombreRepetido, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
     * Método que actualiza los elementos visibles en el listView.
     */
    void actualizar() {
        ListView listView = (ListView) findViewById(R.id.listClientes);
        AdaptadorListViewPersonas adaptador = new AdaptadorListViewPersonas(this, arrayListPersona);
        listView.setAdapter(adaptador);
    }


    /*
     * Método que elimina del arrayList de personas aquella que ha sido seleccionada en el listView.
     */
    void eliminarPersona(String nombre) {
        boolean encontrado = false;
        int posicionBorrado = -1;
        for (Persona persona : arrayListPersona) {
            if (persona.getNombre().equals(nombre) && !encontrado) {
                posicionBorrado = arrayListPersona.indexOf(persona);
                encontrado = true;
            }
        }
        if (posicionBorrado != -1)
            arrayListPersona.remove(posicionBorrado);
    }


    /*
     * Método que recorre el array plazaOcupada, encontrando la primera plaza libre del viaje elegido.
     */
    int plazaLibre() {
        for (int i = 0; i < plazaOcupada.length; i++) {
            if (!plazaOcupada[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    /*
     * Método que recorre las personas existentes en un viaje para comprobar que el nombre a introducir
     * no existe ya en dicha lista, evitando problemas al borrar un registro.
     */
    boolean nombreRepetido(String nombre) {
        for (Persona persona : arrayListPersona) {
            if (persona.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Método que calcula el número de plazas ocupadas mediante un array de boolean que indican si
     * una determinada plaza está ocupada (true) o no (false)
     */
    String numeroPlazasOcupadas() {
        int contOcupada = 0;
        for (boolean ocupada : plazaOcupada) {
            if (ocupada) {
                contOcupada++;
            }
        }
        return String.valueOf(contOcupada);
    }

    /*
     * Método que modifica el texto de los distintos TextViews del LinearLayout
     */
    void modificarTextView(int posicionLayout, String texto) {
        textView = (TextView) linearClientes.getChildAt(posicionLayout);
        textView.setText(texto);
    }


}
