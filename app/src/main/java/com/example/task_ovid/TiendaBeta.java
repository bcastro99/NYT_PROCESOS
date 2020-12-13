package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TiendaBeta extends AppCompatActivity {

    private ImageButton p1;
    private ImageButton p2;
    private ImageButton m1;
    private ImageButton m2;
    private int vidaAux;
    private int expAux;
    private MainActivity x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_beta);

        p1=(ImageButton)findViewById(R.id.pocion1);
        p2=(ImageButton)findViewById(R.id.pocion2);
        m1=(ImageButton)findViewById(R.id.masc1);
        m2=(ImageButton)findViewById(R.id.masc2);
    }

    public void generar(){
        x=new MainActivity();
        this.vidaAux = x.getVida();

    }



}
