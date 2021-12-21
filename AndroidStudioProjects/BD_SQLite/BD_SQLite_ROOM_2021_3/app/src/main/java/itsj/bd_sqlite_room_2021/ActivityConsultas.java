package itsj.bd_sqlite_room_2021;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import baseDeDatos.EscuelaBD;
import entidades.Alumno;

public class ActivityConsultas extends Activity {

    ListView lista;
    List<Alumno> ListaAlumnos;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        //---------------Listview-------------------
        lista = findViewById(R.id.listview);

        new Thread(new Runnable() {
            @Override
            public void run() {
                EscuelaBD conexion = EscuelaBD.gettAppDatabase(getBaseContext());
                ListaAlumnos = conexion.alumnoDAO().obtenerTodos();
                for (Alumno a: ListaAlumnos) {
                    Log.d("DATOS->",a.toString());
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter adaptador = new ArrayAdapter(getBaseContext(),
                                                                    android.R.layout.simple_list_item_1,
                                                                    ListaAlumnos);
                        lista.setAdapter(adaptador);
                    }
                });


            }
        }).start();



        //---------------Recyclerview----------------
        recyclerView = findViewById(R.id.recyclerview1);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String nombres[] = {"Clara", "Ruby"};
        adapter = new AdaptadorRegistros();

        recyclerView.setAdapter(adapter);




    }//OnCreate
}


class AdaptadorRegistros extends RecyclerView.Adapter<AdaptadorRegistros.MyViewHolder>{

private String[] mDataset;

    public AdaptadorRegistros() {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;
    public MyViewHolder(TextView t) {
        super(t);
        textView = t;
    }
}

    public AdaptadorRegistros(String [] mDataset){
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public AdaptadorRegistros.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_recyclerview,
                parent, false);
        MyViewHolder vh = new MyViewHolder(tv);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
