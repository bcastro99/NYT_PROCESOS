package com.example.task_ovid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;


public class AdaptadorDePerfiles extends BaseAdapter {
    private Context context;
    public AdaptadorDePerfiles (Context context){
        this.context= context;
    }
    @Override
    public int getCount(){
        return Perfil.Perfiles.length;
    }
    public Perfil getItem(int position){
        return Perfil.Perfiles[position];
    }
    @Override
    public long getItemId(int position){
        return getItem(position).getId();
    }
    @Override
    public View getView (int position, View view, ViewGroup viewGroup){
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item,viewGroup,false);
        }
        ImageButton imagenAvatar = (ImageButton) view.findViewById(R.id.imagen_Perfil);
        TextView nombreAvatar = (TextView) view.findViewById(R.id.nombre_perfil);
        final Perfil item = Perfil.getPerfiles(position);
        imagenAvatar.setImageResource(item.getIdDrawable());
        nombreAvatar.setText(item.getNombre());
        return view;
    }
}
