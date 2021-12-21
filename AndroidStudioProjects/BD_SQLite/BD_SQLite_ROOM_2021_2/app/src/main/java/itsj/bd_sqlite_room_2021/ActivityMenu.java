package itsj.bd_sqlite_room_2021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class ActivityMenu extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
    }

    public void abrirActivities (View v){
        Intent i=null;
        switch (v.getId()){
            case R.id.btn_agregar: i = new Intent(this, ActivityAltas.class);break;
            case R.id.btn_eliminar: i = new Intent(this, ActivityBajas.class);break;
        }
        startActivity(i);
    }

}
