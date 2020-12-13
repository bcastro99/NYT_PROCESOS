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
    private TextView hp;
    private TextView hpMax;
    private TextView coins;
    private int vidaAux;
    private int monedasAux;
    private int vidaMaxAux;
    private MainActivity x;
    private double resAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_beta);

        p1=(ImageButton)findViewById(R.id.pocion1);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocima(vidaAux, vidaMaxAux, monedasAux);
            }
        });
        p2=(ImageButton)findViewById(R.id.pocion2);
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocimasuper(vidaAux, vidaMaxAux, monedasAux);
            }
        });
        m1=(ImageButton)findViewById(R.id.masc1);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascarilla(monedasAux, resAux);
            }
        });
        m2=(ImageButton)findViewById(R.id.masc2);
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supermascarilla(monedasAux, resAux);
            }
        });
        hp = (TextView)findViewById(R.id.vida);
        hp.setText(vidaAux);
        hpMax = (TextView)findViewById(R.id.maxvida);
        hpMax.setText(vidaMaxAux);
        coins = (TextView)findViewById(R.id.monedas);
        coins.setText(monedasAux);

        x=new MainActivity();
        this.vidaAux = x.getVida();
        this.monedasAux = x.getMonedasUsuario();
        this.vidaMaxAux = x.getMaxVida();
        this.resAux = x.getResistencia();
    }


    public void pocima(int vidaAux, int vidaMaxAux, int monedasAux){
        if (vidaAux < vidaMaxAux){
            if (monedasAux >= 100){
                if (vidaMaxAux - vidaAux < 20){
                    vidaAux = vidaMaxAux;
                }else{
                    vidaAux = vidaAux + 20;
                }
                x.setVida(vidaAux);
            }else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
            monedasAux = monedasAux-100;
            x.setMonedasUsuario(monedasAux);
        }else{
            Toast.makeText(getApplicationContext(), "Ya estás a tope jefe de equipo", Toast.LENGTH_LONG).show();
        }
    }

    public void pocimasuper(int vidaAux, int vidaMaxAux, int monedasAux){
        if (vidaAux < vidaMaxAux){
            if (monedasAux >= 300){
                if (vidaMaxAux - vidaAux < 60){
                    vidaAux = vidaMaxAux;
                }else{
                    vidaAux = vidaAux + 60;
                }
                x.setVida(vidaAux);
            }else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
            monedasAux = monedasAux-300;
            x.setMonedasUsuario(monedasAux);
        }else{
            Toast.makeText(getApplicationContext(), "Ya estás a tope jefe de equipo", Toast.LENGTH_LONG).show();
        }
    }

    public void mascarilla(int monedasAux, double resAux){
        if (resAux == 1){
            if (monedasAux >= 200) {
                resAux = resAux + 0.1;
                monedasAux = monedasAux -200;
                x.setMonedasUsuario(monedasAux);
                x.setResistencia(resAux);
            } else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ya tienes una, para que quieres mas", Toast.LENGTH_LONG).show();
        }
    }

    public void supermascarilla(int monedasAux, double resAux){
        if (resAux == 1){
            if (monedasAux >= 1500) {
                resAux = resAux + 0.5;
                monedasAux = monedasAux -1500;
                x.setMonedasUsuario(monedasAux);
                x.setResistencia(resAux);
            } else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ya tienes una, para que quieres mas", Toast.LENGTH_LONG).show();
        }
    }

}
