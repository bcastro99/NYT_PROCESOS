package com.example.task_ovid;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormatSymbols;


public class PantallaPrincipal extends AppCompatActivity {
    ListView lista;
    String[] tareas;

    public PantallaPrincipal() {
        lista = findViewById(R.id.lista);
        tareas =new DateFormatSymbols().getMonths();
        ArrayAdapter<String> tareasAdapter = new ArrayAdapter<>(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        setContentView(R.layout.activity_pantallaprincipal);

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

        switch(item.getItemId()) {
            case R.id.Tareas:
                return true;
            case R.id.Perfil:
                return true;

            case R.id.Salir:
                finishAffinity();

        }
        return super.onOptionsItemSelected(item);
    }


}
