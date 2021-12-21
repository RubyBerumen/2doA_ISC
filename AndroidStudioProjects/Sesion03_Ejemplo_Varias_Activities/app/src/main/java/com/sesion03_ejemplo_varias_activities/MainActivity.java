package com.sesion03_ejemplo_varias_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText cajaUsuario, cajaContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaUsuario = findViewById(R.id.caja_usuario);
        cajaContraseña = findViewById(R.id.caja_contraseña);

    }

    public void accesoLogin(View v){
        Toast.makeText(getApplicationContext(),
                cajaUsuario.getText().toString(),Toast.LENGTH_LONG).show();

        //Suponer la autenticacion correcta del USUARIO (usuario y contraseña correctos)

        Intent i = new Intent(this, ActivityMenuPrincipal.class);
        i.putExtra("usuario", cajaUsuario.getText().toString());
        startActivity(i);


    }


}