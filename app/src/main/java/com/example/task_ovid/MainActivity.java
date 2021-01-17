package com.example.task_ovid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private ArrayList<String> tareas;


    private static int maxExperiencia = 100;
    public  static int maxVida = 100;
    private static int vida = maxVida;
    private int experienciaTotal = 0;
    private static ProgressBar bv;
    private TextView nivelTexto;
    private static int experiencia=0;
    private static int nivel=1;
    public  static ProgressBar be;
    private static TextView monedas;
    private ArrayAdapter<String> tareasAdapter;
    private static double resistencia=1;
    private static int monedasUsuario=0;
    private static int restaAux;
    public  ImageView fotoPerfil;




    public MainActivity() {

    }

    public  ImageView getFotoPerfil() {
        return fotoPerfil;
    }

    public  void setFotoPerfil(ImageView fotoPerfil) {
       this.fotoPerfil=fotoPerfil;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipal);
        lista = findViewById(R.id.lista);
        this.tareas = new ArrayList<>();
        llenarTareas();
        tareasAdapter = new ArrayAdapter(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        lista.setOnItemClickListener(this);
        fotoPerfil=(ImageView) findViewById(R.id.imageView);;
        int valor=0 ;
        try {
             valor = getIntent().getExtras().getInt("fotoPerfil");
             fotoPerfil.setImageResource(valor);
        } catch (Exception e){

        }




    }
    private void llenarTareas(){ //este método es para rellenar las listas, el 0 simboliza el contador
        tareas.add("* Hacer PCR 0");
        tareas.add("+ salir con mascarilla 0");
        tareas.add("+ lavarse las manos 0");
        tareas.add("+ desinfectarse 0");
        tareas.add("+ evitar aglomeraciones 0");
        tareas.add("+ quedarse en casa 0");
        tareas.add("- olvidarse la mascarilla 0");
        tareas.add("- Llegar a casa y no lavarme las manos 0");
        tareas.add("- Frotarme los ojos o llevarme las manos a la boca en la calle 0");
        tareas.add("- Estar con mis amigos sin mascarilla 0");
        tareas.add("- Salir de fiesta 0");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String t = parent.getItemAtPosition(position).toString();
        //divide el string para poder cambiar el contador
        String[] parts = t.split(" ");
        //incrementar el contador y actualizar el string
        int cont = Integer.parseInt(parts[parts.length-1]) + 1;
        parts[parts.length-1] = String.valueOf(cont);
        //une el string de nuevo para colocarlo en la lista
        String string = "";
        for (int i = 0; i <= parts.length-1; i++){
            if (i == 0){
                string = parts[i];
            }else{
                string = string + " "+parts[i];
            }
        }
        //actualiza la lista
        tareas.set(position,string);
        tareasAdapter.notifyDataSetChanged();

        bv=(ProgressBar)findViewById(R.id.Vida);
        bv.setMax(maxVida);
        if (t.contains("-")){
            restaAux = (int)(25 * resistencia);
            int vidaAux = vida - restaAux;
            setVida(vidaAux);
            bv.setProgress(vida,true);
            if (vidaAux<=0){
                Toast.makeText(getApplicationContext(), "Con estos habitos te vas a contagiar ;(", Toast.LENGTH_LONG).show();
            }
        }else{
            incrementarExperiencia(t);
        }

    }

//Acción que se ejecuta cuando se realiza una buena acción
    public void incrementarExperiencia(String t){
        be=(ProgressBar)findViewById(R.id.Experiencia);
        be.setMax(maxExperiencia);
        if(t.contains("+")){
            experiencia += 10;
            experienciaTotal +=10;

        }else{
            experiencia += 50;
            experienciaTotal += 10;
        }
        subirNivel();
        be.setProgress(experiencia,true);
    }
//Cuando sube de nivel el usuario se establece la barra de nivel y las monedas
    public void subirNivel(){
        if (experiencia>=maxExperiencia){
            int extra = experiencia-maxExperiencia;
            nivel ++;
            experiencia = extra;
            maxExperiencia += 20;
            be.setMax(maxExperiencia);
            nivelTexto = (TextView)findViewById(R.id.NombreNivel);
            nivelTexto.setText("NIVEL "+nivel);
            Toast.makeText(getApplicationContext(), "Has subido de nivel. Enhorabuena", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "Has ganado 100 monedas", Toast.LENGTH_LONG).show();

            incrementarMonedas(100);
        }
        bv.setProgress(vida,true);
    }
//Incrementa las monedas, se usa al subir de nivel
    public void incrementarMonedas(int cantidad){
        monedas = (TextView)findViewById(R.id.monedasActuales);
        monedasUsuario+=cantidad;
        monedas.setText(""+ monedasUsuario);

    }

//Establece la vida del jugador al salir de la tienda
    public static void setVida(int v) {
        if (vida>=0) {
            vida = v;
        }else{
            vida = 0;
        }
        bv.setProgress(vida,true);
    }
    public static int getMaxExperiencia(){
        return maxExperiencia;
    }
    public static int getVida(){
        return vida;
    }
    public static int getNivel(){
        return nivel;
    }
    public static int getExperiencia(){
        return experiencia;
    }

    public static int getMaxVida() {
        return maxVida;
    }

    public static int getMonedasUsuario() {
        return monedasUsuario;
    }

    public  static void setMonedasUsuario(int m) {
        monedasUsuario = m;
        monedas.setText(""+ monedasUsuario);
    }

    public static double getResistencia() {
        return resistencia;
    }

    public  void setResistencia(double resistencia) {
        this.resistencia = resistencia;
    }

//Para mostrar el menu de opciones
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
            Intent intent= new Intent(this,PerfilActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(intent, 0);
        }else if (R.id.Tienda== id) {
            Intent intent= new Intent(this,TiendaBeta.class);
            startActivity(intent);
        }else if (R.id.menuAyuda == id) {
            Intent intent= new Intent(this,menuAyuda.class);

            fotoPerfil.setImageResource(R.drawable.avatar2);
            startActivity(intent);
        }else if(R.id.Salir==id) {

                finishAffinity();


        }

                return super.onOptionsItemSelected(item);

    }







}