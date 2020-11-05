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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TiendaBeta extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String objetos[] = {"Pocion","Superpocion"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_beta);

        tv1= (TextView) findViewById(R.id.tv1);
        lv1= (ListView) findViewById(R.id.lv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.shop_style,objetos);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText("Has elegido "+lv1.getItemAtPosition(position));
            }
        });

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