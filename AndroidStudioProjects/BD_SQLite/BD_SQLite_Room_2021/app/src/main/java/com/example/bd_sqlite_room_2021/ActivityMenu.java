package com.example.bd_sqlite_room_2021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class ActivityMenu extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);
    }

    public void abrirActivities(View v){
        Intent i;
        switch (v.getId()){

        }
    }

}
