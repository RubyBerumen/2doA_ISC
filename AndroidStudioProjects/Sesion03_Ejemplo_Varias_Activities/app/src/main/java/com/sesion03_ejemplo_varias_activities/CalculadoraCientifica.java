package com.sesion03_ejemplo_varias_activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class CalculadoraCientifica extends Activity implements View.OnClickListener {

    RadioButton radioB, radioO, radioH, radioD;

    Button btnVerificar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_cientifica);

        radioB = findViewById(R.id.radio_binario);
        radioO = findViewById(R.id.radio_octal);
        radioH = findViewById(R.id.radio_hex);
        radioD = findViewById(R.id.radio_dec);

        btnVerificar = findViewById(R.id.btn_verificar);
        btnVerificar.setOnClickListener(this);

    }

    public void verificar(View v){
        if(radioB.isChecked())
            Toast.makeText(this, "BINARIO", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Log.i("MSJ->", "Esto tambien se ejecuta");
        if(radioB.isChecked())
            Toast.makeText(this, "BINARIO", Toast.LENGTH_LONG).show();
    }

    //Metodo para el evento CLIC de los radiobuttons
    public void presionarRadioButton(View v){

        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()) {
            case R.id.radio_binario:
                if (checked)
                    Toast.makeText(this, "BINARIO", Toast.LENGTH_LONG).show();
                    break;
            case R.id.radio_octal:
                if (checked)
                    Toast.makeText(this, "OCTAL", Toast.LENGTH_LONG).show();
                    break;
        }
    }

}
