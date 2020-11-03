package com.example.task_ovid;

public class Tareas {
    private int contador;
    private String name;


    public Tareas(String name) {
        this.name = name;
        this.contador = 0;
    }


    public int getContador(){
        return this.contador;
    }

    public String getName(){
        return this.name;
    }

    public void aumentarContador(){
        contador++;
    }


   /* public void disminuirVida(){

    } */







}
