package com.example.task_ovid;

public class Perfil {


    private String nombre;
    private int idDrawable;


    public Perfil (String nombre, int idDrawable){
        this.nombre=nombre;
        this.idDrawable=idDrawable;
    }
    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
    public int getId(){
        return nombre.hashCode();
    }

    public static Perfil[] Perfiles={
            new Perfil("Avatar1", R.drawable.avatar),
            new Perfil("Avatar2", R.drawable.avatar2),
            new Perfil("Avatar3", R.drawable.avatar3),
            new Perfil("Avatar4", R.drawable.avatar4),
            new Perfil("Avatar5", R.drawable.avatar5),
            new Perfil("Avatar6", R.drawable.avatar6),
            new Perfil("Avatar7", R.drawable.avatar7),
            new Perfil("Avatar8", R.drawable.avatar8)
    };
    public static Perfil getPerfiles(int id){
        for (Perfil item: Perfiles){
            if(item.getId()==id){
                return item;
            }
        }
        return null;
    }
}
