package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaCancionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);

        CancionesHelper dbHelper = new CancionesHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query(
                CancionesContract.CancionesTab.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List listaCanciones = new ArrayList<>();
        while (cursor.moveToNext()) {
            String cancion = cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionesTab._ID)) + " " +
                    cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionesTab.COLUMN_TITULO)) + " " +
                    cursor.getString(cursor.getColumnIndexOrThrow(CancionesContract.CancionesTab.COLUMN_CANTANTE));

            listaCanciones.add(cancion);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listaCanciones
        );

        ListView lv_canciones = (ListView) findViewById(R.id.lv_canciones);
        lv_canciones.setAdapter(arrayAdapter);
    }
}