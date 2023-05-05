package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CancionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);
    }

    public void guardarCanciones(View view) {
        EditText et_titulo = (EditText) findViewById(R.id.et_titulo_cancion);
        EditText et_cantante = (EditText) findViewById(R.id.et_cantante_cancion);
        String titulo = et_titulo.getText().toString();
        String cantante = et_cantante.getText().toString();

        CancionesHelper dbHelper = new CancionesHelper(getApplicationContext());
        SQLiteDatabase baseDeDatos = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CancionesContract.CancionesTab.COLUMN_TITULO, titulo);
        valores.put(CancionesContract.CancionesTab.COLUMN_CANTANTE, cantante);

        long nuevoIdAccion = baseDeDatos.insert(CancionesContract.CancionesTab.TABLE_NAME, null, valores);
        String idCancion = Long.toString(nuevoIdAccion);

        Toast toast = Toast.makeText(getApplicationContext(), idCancion, Toast.LENGTH_LONG);
        toast.show();

        Intent intent = new Intent(this, ListaCancionesActivity.class);
        startActivity(intent);
    }
}