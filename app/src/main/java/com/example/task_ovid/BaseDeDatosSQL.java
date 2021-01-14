package com.example.task_ovid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatosSQL extends SQLiteOpenHelper{

    private static final String CREAR_TABLA_USUARIO = "CREATE TABLE USUARIO(Vida INTEGER, Experiencia INTEGER)";
    private static final String CREAR_TABLA_TAREAS = "CREATE TABLE TAREAS(NombreTarea TEXT, Lista INTEGER)";
    private MainActivity x;
    private static int AuxVida;
    private static int AuxExperiencia;


    public BaseDeDatosSQL(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DB){

        DB.execSQL(CREAR_TABLA_USUARIO);
        DB.execSQL(CREAR_TABLA_TAREAS);

        x = new MainActivity();
        this.AuxVida = x.getVida();
        this.AuxExperiencia = x.getExperiencia();


        DB.execSQL("INSERT INTO USUARIO VALUES(AuxVida,AuxExperiencia)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ranking");
        onCreate(db);
    }
}
