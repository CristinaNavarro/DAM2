package com.example.cristi.databaselistview;

/*
********Autor: Cristina Navarro
********Fecha: 18/12/2017
********Asignatura:D. de Aplicaciones Móviles
********Ejercicio:	BBDD con ListView
*/


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class AdaptadorBD {

    public static final String KEY_ID = "_id";
    public static final String KEY_NOMBRE = "nombre";
    public static final String KEY_APELLIDO = "apellido";

    private static final String TAG = "AdaptadorBD";

    private static final String DATABASE_NAME = "DBPersonas";
    private static final String DATABASE_TABLE = "infopersona";
    private static final String DATABASE_TABLECOPIA = "infopersonacopia";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table if not exists " + DATABASE_TABLE +
                    "(" + KEY_ID + " integer primary key autoincrement, " +
                    KEY_NOMBRE + " text not null, "
                    + KEY_APELLIDO + " text not null);";

    private static final String DATABASECOPIA_CREATE =
            "create table if not exists " + DATABASE_TABLECOPIA +
                    "(" + KEY_ID + " integer primary key autoincrement, " +
                    KEY_NOMBRE + " text not null, "
                    + KEY_APELLIDO + " text not null);";

    private final Context context;
    private BaseDatosHelper BDHelper;
    private SQLiteDatabase bsSql;
    private String[] todasColumnas = new String[]{KEY_ID, KEY_NOMBRE, KEY_APELLIDO};

    public AdaptadorBD(Context ctx) {
        this.context = ctx;
        Log.v("3","llega al constructor");
        BDHelper = new BaseDatosHelper(context);
        Log.v("4","se tendrían que haber creado");
    }

    public AdaptadorBD open() throws SQLException {
        bsSql = BDHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close() {
        BDHelper.close();
    }

    public long insertarPersona(Persona persona) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NOMBRE, persona.getNombre());
        initialValues.put(KEY_APELLIDO, persona.getApellido());
        return bsSql.insert(DATABASE_TABLE, null, initialValues);
    }

    public long insertarPersonaCopia(String n, String a) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NOMBRE, n);
        initialValues.put(KEY_APELLIDO, a);
        return bsSql.insert(DATABASE_TABLECOPIA, null, initialValues);
    }

    public Cursor getPersonas() {
        return bsSql.query(DATABASE_TABLE, todasColumnas, null, null, null, null, null);
    }

    public Cursor getTodosPersonasCopia() {
        return bsSql.query(DATABASE_TABLECOPIA, todasColumnas, null, null, null, null, null);
    }

    public ArrayList<Persona> getAllPersonas() {

        ArrayList<Persona> listaPersonas = new ArrayList<>();
        Cursor cursor = this.getPersonas();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Persona comment = cursorToPersona(cursor);
            listaPersonas.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        return listaPersonas;
    }

    public ArrayList<Persona> getAllPersonasCopia() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        Cursor cursor = this.getTodosPersonasCopia();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Persona comment = cursorToPersona(cursor);
            listaPersonas.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        return listaPersonas;
    }

    private Persona cursorToPersona(Cursor cursor) {
        return new Persona(cursor.getString(1), cursor.getString(2));
    }

    public void borrarBD() {
        this.bsSql.delete(DATABASE_TABLE, null, null);
        this.bsSql.delete(DATABASE_TABLECOPIA, null, null);
    }


//**** CLASE PRIVADA ***/	

    private static class BaseDatosHelper extends SQLiteOpenHelper {
        BaseDatosHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASECOPIA_CREATE);
            db.execSQL(DATABASE_CREATE);
            Log.e("Creadas", "dsdsds");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Actualizando base de datos de la versi�n " + oldVersion
                    + " a "
                    + newVersion + ", borraremos todos los datos");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLECOPIA);
            onCreate(db);
        }
    }
}
