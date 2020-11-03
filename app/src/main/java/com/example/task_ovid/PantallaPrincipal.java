package com.example.task_ovid;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;


public class PantallaPrincipal extends AppCompatActivity {
    ListView lista;
    private final ArrayList<Tareas> tareas;


    public PantallaPrincipal() {
        lista = findViewById(R.id.lista);
        this.tareas = new ArrayList<>();
        ArrayAdapter<String> tareasAdapter = new ArrayAdapter<>(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        setContentView(R.layout.activity_pantallaprincipal);
        lista.setClickable(true);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onClick(View v, AdapterView<?>adapter, int position) {
                Tareas item = adapter.getItemAtPosition(position);
            }
        });

       /* lista = findViewById(R.id.lista);
        tareas =new DateFormatSymbols().getMonths();
        ArrayAdapter<String> tareasAdapter = new ArrayAdapter<>(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        setContentView(R.layout.activity_pantallaprincipal); */

        /* listview.setOnItemClickListener(new OnItemClickListener() {​​​​​
            @Overridepublic void onItemClick(AdapterView<?>adapter,View v, int position) {​​​​​
                ItemClicked item = adapter.getItemAtPosition(position);
                //Añade el código que quieras para tu item
            }​​​​​
        }​​​​​); */
    }

    private void llenarTareas(){
        tareas.add(new Tareas("mascarilla"));
        tareas.add(new Tareas("salir"));
        tareas.add(new Tareas("lavarse manos"));
        tareas.add(new Tareas("taparse la boca"));
        tareas.add(new Tareas("no escupir"));
    }


}