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
import android.widget.Toast;

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(R.id.main==id) {
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }else if (R.id.Perfil==id) {
            Toast.makeText(getApplicationContext(), "En Construccion...", Toast.LENGTH_SHORT).show();

        }else if (R.id.Tienda== id) {
            Intent intent2= new Intent(this,TiendaBeta.class);
            startActivity(intent2);
        }else if(R.id.Salir==id) {
            finishAffinity();
        }

        return super.onOptionsItemSelected(item);

    }


}