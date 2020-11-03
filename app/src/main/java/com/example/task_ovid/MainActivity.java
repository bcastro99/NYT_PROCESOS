package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ListView lista;
    String[] tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar= getSupportActionBar();
        actionbar.setIcon(R.drawable.icono_app);

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
                intent = new Intent(this,MainActivity.class);//Se debe cambiar y poner actividad de Perfil
                startActivity(intent);;
            case R.id.Tienda:
                intent= new Intent(this,MainActivity.class);//Se debe cambiar y poner actividad de Tienda
                startActivity(intent);;

            case R.id.Salir:
                finishAffinity();

        }
        return super.onOptionsItemSelected(item);
    }
}