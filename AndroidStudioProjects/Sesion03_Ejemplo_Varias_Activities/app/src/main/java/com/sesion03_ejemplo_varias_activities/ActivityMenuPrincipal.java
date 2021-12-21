package com.sesion03_ejemplo_varias_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ActivityMenuPrincipal extends Activity {

    TextView titulo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Intent i = getIntent();
        String u = i.getStringExtra("usuario");

        titulo = findViewById(R.id.textView_titulo_menu);

        titulo.setText("Bienvenido " +u+ " "+titulo.getText().toString() );

    }

    public void abrirCalculadoras(View v){

        Intent i = null;
        if(v.getId() == R.id.btn_calc_senc){
            i = new Intent(this, CalculadoraSencilla.class);
        }else if(v.getId() == R.id.btn_calc_cient){
            i = new Intent(this, CalculadoraCientifica.class);
        }

        startActivity(i);
    }

    public void abrirCalculadoraCient(View v){
        Intent i = new Intent(this, CalculadoraSencilla.class);
        startActivity(i);
    }
}
