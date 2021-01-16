package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {
    private GridView gridView;
    private TextView mTextView;
    private AdaptadorDePerfiles adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        gridView= (GridView) findViewById(R.id.grid);
        adaptador= new AdaptadorDePerfiles(this);
        gridView.setAdapter(adaptador);


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
            int id = item.getItemId();
            if(R.id.main==id) {
                Intent intent= new Intent(this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }else if (R.id.Perfil==id) {
                Intent intent = new Intent(this, PerfilActivity.class);
                startActivity(intent);
            }else if (R.id.Tienda== id) {
                Intent intent= new Intent(this,TiendaBeta.class);
                startActivity(intent);
            }else if (R.id.menuAyuda == id) {
                Intent intent= new Intent(this,menuAyuda.class);
                startActivity(intent);
            }else if(R.id.Salir==id) {
                finishAffinity();
            }

            return super.onOptionsItemSelected(item);

        }


}