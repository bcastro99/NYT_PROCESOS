package com.example.task_ovid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.zip.DataFormatException;


public class MainActivity extends AppCompatActivity {
    ListView lista;
    String[] tareas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_pantallaprincipal);
        lista = findViewById(R.id.lista);
        tareas = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> tareasAdapter = new ArrayAdapter<>(this, R.layout.rowtext,tareas);
        lista.setAdapter(tareasAdapter);


    }
}