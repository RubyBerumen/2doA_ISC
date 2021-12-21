package com.sesion03_ejemplo_varias_activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CalculadoraSencilla extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerOperaciones;
    EditText cajaPrimerNumero, cajaSegundoNumero, cajaResultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_sencilla);

        cajaPrimerNumero = findViewById(R.id.caja_primer_numero);
        cajaSegundoNumero = findViewById(R.id.caja_segundo_numero);
        cajaResultado = findViewById(R.id.caja_resultado);

        spinnerOperaciones = findViewById(R.id.spinner_operaciones);

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.operaciones,
                android.R.layout.simple_spinner_item);

        spinnerOperaciones.setAdapter(adaptador);

        spinnerOperaciones.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.spinner_operaciones )
            Log.i("MSJ --> ", "SPINNER 1");

        Log.i("MSJ --> ", parent.toString());
        Log.i("MSJ --> ", parent.getItemAtPosition(position).toString());

        switch (parent.getItemAtPosition(position).toString()){
            case "+": Toast.makeText(getBaseContext(), "A sumar se ha dicho", Toast.LENGTH_LONG).show();
                        cajaResultado.setText("resultado");
                        break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
