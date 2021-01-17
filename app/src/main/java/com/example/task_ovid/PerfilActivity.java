package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

private ImageView imagenPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        /*
        Seteando el adaptador al GridView
         */
        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this));

        /*
        Creando una nueva escucha para los elementos del Grid
         */
        gridview.setOnItemClickListener(this);


            };

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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      ImageAdapter adapter = new ImageAdapter(this);

      MainActivity.getFotoPerfil().setImageResource(adapter.getThumbId(position));
        Intent i = new Intent(this,MainActivity.class);
      startActivity(i);
    }
}