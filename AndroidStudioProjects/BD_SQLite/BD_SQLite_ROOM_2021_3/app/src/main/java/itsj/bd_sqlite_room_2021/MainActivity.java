package itsj.bd_sqlite_room_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void abrirMenu(View v){
        Intent i = new Intent(this,ActivityMenu.class);
        startActivity(i);
    }

}