package com.example.task_ovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

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



}