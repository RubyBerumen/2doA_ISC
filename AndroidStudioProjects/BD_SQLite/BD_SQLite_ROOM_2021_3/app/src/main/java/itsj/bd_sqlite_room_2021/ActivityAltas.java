package itsj.bd_sqlite_room_2021;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import baseDeDatos.EscuelaBD;
import entidades.Alumno;

public class ActivityAltas extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
    }

    public void agregarAlumno(View v) {

        EscuelaBD conexionBD = EscuelaBD.gettAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {

                conexionBD.alumnoDAO().insertarAlumno(new Alumno("3", "1", "1", "1", (byte) 1, (byte) 1, "1"));

                /*
                String cad=edad.getText().toString();
                int edad=Integer.parseInt(cad);
                cad="";
                cad=semestre.getText().toString();
                int semestre =Integer.parseInt(cad);
                Alumno alu=new Alumno(noControl.getText().toString(),nombre.getText().toString(),primerap.getText().toString(),segundaAp.getText().toString(),(byte)edad,(byte)semestre,carrera.getText().toString());
                 */

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "Agregado con EXITO", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();




    }
}
