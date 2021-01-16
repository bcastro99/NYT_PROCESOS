package com.example.task_ovid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    private ArrayList<String> tareas;


    private static int maxExperiencia = 100;
    public  static int maxVida = 100;
    private static int vida;
    private int experienciaTotal = 0;
    private static ProgressBar bv;
    private TextView nivelTexto;
    private static int experiencia;
    private static int nivel;
    public  static ProgressBar be;
    private static TextView monedas;
    private ArrayAdapter<String> tareasAdapter;
    private static double resistencia=1;
    private static int monedasUsuario;
    private static int restaAux;



    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            loadUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipal);
        lista = findViewById(R.id.lista);
        this.tareas = new ArrayList<>();
        llenarTareas();
        nivelTexto = (TextView)findViewById(R.id.NombreNivel);
        nivelTexto.setText("NIVEL "+nivel);
        incrementarMonedas(0);
        bv=(ProgressBar)findViewById(R.id.Vida);
        bv.setProgress(vida);
        be=(ProgressBar)findViewById(R.id.Experiencia);
        be.setProgress(experiencia);
        tareasAdapter = new ArrayAdapter(this, R.layout.rowtext, tareas);
        lista.setAdapter(tareasAdapter);
        lista.setOnItemClickListener(this);


    }


    private void saveUser(int vida, int experiencia, int nivel, int monedasUsuario ) {

        try {

            FileWriter fichero = new FileWriter(new File (getFilesDir(), "datosUsuario.txt"));
            System.out.println(getFilesDir());
            BufferedWriter bw = new BufferedWriter(fichero);

            ArrayList<String> Datos = new ArrayList<>();

            String Svida = valueOf(vida);
            String Sexperiencia = valueOf(experiencia);
            String Snivel = valueOf(nivel);
            String SmonedasUsuario = valueOf(monedasUsuario);
            Datos.add(Svida);
            Datos.add(Sexperiencia);
            Datos.add(Snivel);
            Datos.add(SmonedasUsuario);

            for (String guardar : Datos) {
                bw.write(guardar);
                bw.newLine();
                bw.flush();
            }

            bw.close();
            fichero.close();
        } catch (IOException e) {

            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void loadUser() throws IOException {
        FileReader fichero = new FileReader(new File (getFilesDir(), "datosUsuario.txt"));
        BufferedReader br = new BufferedReader(fichero);
        String values;
        ArrayList<String> Datos = new ArrayList<>();

        while((values = br.readLine()) != null) {
            Datos.add(values);
        }
        String v1 = Datos.get(0);
        vida = Integer.parseInt(Datos.get(0));
        experiencia = Integer.parseInt(Datos.get(1));
        nivel = Integer.parseInt(Datos.get(2));
        monedasUsuario = Integer.parseInt(Datos.get(3));
        br.close();
        fichero.close();

        File ficheroABorrar = new File("datosUsuario.txt");
        ficheroABorrar.delete();

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
        parts[parts.length-1] = valueOf(cont);
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
            Toast.makeText(getApplicationContext(), "En Construccion...", Toast.LENGTH_SHORT).show();
            vida=100;
            experiencia=0;
            nivel=1;
            monedasUsuario=0;
        }else if (R.id.Tienda== id) {
            Intent intent= new Intent(this,TiendaBeta.class);
            startActivity(intent);
        }else if (R.id.menuAyuda == id) {
            Intent intent= new Intent(this,menuAyuda.class);
            startActivity(intent);
        }else if(R.id.Salir==id) {
            saveUser(vida, experiencia, nivel ,monedasUsuario);
            finishAffinity();
        }

        return super.onOptionsItemSelected(item);

    }





}