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
    private static int vidaAux;
    private static int monedasAux;
    private static int vidaMaxAux;
    private MainActivity x;
    private static double resAux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_beta);
//Para conseguir las monedas del main
        x=new MainActivity();
        this.vidaAux = x.getVida();
        this.monedasAux = x.getMonedasUsuario();
        this.vidaMaxAux = x.getMaxVida();
        this.resAux = x.getResistencia();
//Estos métodos esperan a que hagas click sobre los productos de la tienda
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
        hp.setText(String.valueOf(vidaAux));
        hpMax = (TextView)findViewById(R.id.maxvida);
        hpMax.setText(String.valueOf(vidaMaxAux));
        coins = (TextView)findViewById(R.id.monedas);
        coins.setText(String.valueOf(monedasAux));


    }

//Comprueba la vida del usuario y si es menor que 100 vende la pócima, igual con la pócima super
    public void pocima(int vidaAux, int vidaMaxAux, int monedasAux){
        if (vidaAux < vidaMaxAux){
            if (monedasAux >= 100){
                if (vidaMaxAux - vidaAux < 20){
                    vidaAux = vidaMaxAux;
                }else{
                    vidaAux = vidaAux + 20;
                }
                x.setVida(vidaAux);
                hp.setText(String.valueOf(vidaAux));
            }else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
            monedasAux = monedasAux-100;
            x.setMonedasUsuario(monedasAux);
            coins.setText(String.valueOf(monedasAux));
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
                hp.setText(String.valueOf(vidaAux));
            }else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
            monedasAux = monedasAux-300;
            x.setMonedasUsuario(monedasAux);
            coins.setText(String.valueOf(monedasAux));
        }else{
            Toast.makeText(getApplicationContext(), "Ya estás a tope jefe de equipo", Toast.LENGTH_LONG).show();
        }
    }
//Igual que las pocimas pero suma resistencia al usuario
    public void mascarilla(int monedasAux, double resAux){
        if (resAux == 1){
            if (monedasAux >= 200) {
                resAux = resAux + 0.1;
                monedasAux = monedasAux -200;
                x.setMonedasUsuario(monedasAux);
                x.setResistencia(resAux);
                coins.setText(String.valueOf(monedasAux));
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
                coins.setText(String.valueOf(monedasAux));
            } else{
                Toast.makeText(getApplicationContext(), "Estás pobre BRO", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ya tienes una, para que quieres mas", Toast.LENGTH_LONG).show();
        }
    }
//Para implementar el menu de la app
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
            Toast.makeText(getApplicationContext(), "En Construccion...", Toast.LENGTH_SHORT).show();
        }else if (R.id.menuAyuda == id) {
                Intent intent= new Intent(this,menuAyuda.class);
                startActivity(intent);
        }else if(R.id.Salir==id) {
            finishAffinity();
        }

        return super.onOptionsItemSelected(item);

    }

}
