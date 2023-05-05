package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        cargarDatos();
    }

    private void cargarDatos() {
        SharedPreferences sharedPreferences = getSharedPreferences("apodos", MODE_PRIVATE);
        String apodo = sharedPreferences.getString("apodo", "");

        Intent intent = getIntent();
        String usuario = intent.getStringExtra("Usuario");
        TextView tv_usuario = (TextView) findViewById(R.id.tv_usuario);
        tv_usuario.setText(apodo);
    }

    public void iniciarCancionesActivity(View view) {
        Intent intent = new Intent(this, CancionesActivity.class);
        startActivity(intent);
    }

    public void iniciarPeliculasActivity(View view) {
        Intent intent = new Intent(this, PeliculasActivity.class);
        startActivity(intent);
    }
}