package com.example.task_ovid;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

}
