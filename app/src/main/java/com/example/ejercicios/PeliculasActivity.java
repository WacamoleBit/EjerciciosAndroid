package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PeliculasActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
    }

    public void guardarPelicula(View view) {
        EditText et_titulo = (EditText) findViewById(R.id.et_titulo_pelicula);
        String titulo = et_titulo.getText().toString();

        Spinner sp_generos = (Spinner) findViewById(R.id.sp_generos);
        String genero = sp_generos.getSelectedItem().toString();

        Pelicula pelicula = new Pelicula(titulo, genero);

        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("peliculas");

        DatabaseReference insert = db.push();
        insert.setValue(pelicula);
    }
}