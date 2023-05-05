package com.example.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String USUARIO = "nugget";
    private final String CONTRASENIA = "mordor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarSesion(View view){
        Intent intent = new Intent(this, InicioActivity.class);

        EditText et_usuario = (EditText) findViewById(R.id.et_usuario);
        String usuario = et_usuario.getText().toString();

        EditText et_contrasenia = (EditText) findViewById(R.id.et_contrasenia);
        String contrasenia = et_contrasenia.getText().toString();

        Toast toast = Toast.makeText(getApplicationContext(), usuario, Toast.LENGTH_SHORT);
        toast.show();

        if(usuario.equals(USUARIO) && contrasenia.equals(CONTRASENIA)){
            intent.putExtra("Usuario", usuario);
            startActivity(intent);
        }

        EditText et_apodo = (EditText) findViewById(R.id.et_apodo);
        String apodo = et_apodo.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("apodos", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("apodo", apodo);
        editor.putString("usuario", usuario);

        editor.commit();
    }
}