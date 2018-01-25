package com.example.cristi.noriaejercicio17final;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Cristi on 09/01/2018.
 */

public class ConfiguracionFirebase {

    /*
     * Método que inserta una persona en la bbdd en la noria y viaje indicados
     */
    static void insertar(int idNoria, int idViaje, int idPersona, Persona persona) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("norias").child("noria" + idNoria).child("viaje" + idViaje).child("persona" + idPersona).setValue(persona);
    }

    /*
     * Método que elimina todos los datos de la bbdd
     */
    static void limpiarBBDD() {
        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseDatabase.child("norias").removeValue();
    }
}
