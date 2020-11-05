package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private ArrayList<String> tareas;
    ArrayAdapter<String> tareasAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipal);
        lista = findViewById(R.id.lista);
        this.tareas = new ArrayList<>();
        llenarTareas();
        tareasAdapter = new ArrayAdapter(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        lista.setOnItemClickListener(this);
    }
    private void llenarTareas(){ //este método es para rellenar las listas, el 0 simboliza el contador
        tareas.add("salir con mascarilla 0");
        tareas.add("olvidarse la mascarilla 0");
        tareas.add("lavarse las manos 0");
        tareas.add("desinfectarse 0");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String t = parent.getItemAtPosition(position).toString();
        //divide el string para poder cambiar el contador
        String[] parts = t.split(" ");
        //incrementar el contador y actualizar el string
        int cont = Integer.parseInt(parts[parts.length-1]) + 1;
        parts[parts.length-1] = String.valueOf(cont);
        //une el string de nuevo para colocarlo en la lista
        String string = "";
        for (int i = 0; i <= parts.length-1; i++){
            if (i == 0){
                string = parts[i];
            }else{
                string = string + " "+parts[i];
            }
        }
        //actualiza la lista
        tareas.set(position,string);
        tareasAdapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {

            case R.id.Inicio:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);;
            case R.id.Perfil:
                intent = new Intent(this,TiendaBeta.class);//Se debe cambiar y poner actividad de Perfil
                startActivity(intent);;
            case R.id.Tienda:
                intent= new Intent(this,TiendaBeta.class);//Se debe cambiar y poner actividad de Tienda
                startActivity(intent);
            case R.id.Salir:
                finishAffinity();

        }
        return super.onOptionsItemSelected(item);
    }
}