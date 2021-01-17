package com.example.task_ovid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    // Contexto de la aplicación
    private Context mContext;

    // Array de identificadores
    private Integer[] mThumbIds = {
            R.drawable.avatar,R.drawable.avatar2, R.drawable.avatar3,
            R.drawable.avatar4,R.drawable.avatar5, R.drawable.avatar6,
            R.drawable.avatar7,R.drawable.avatar8


    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public int getThumbId(int position){return mThumbIds[position];}


    public View getView(int position, View convertView, ViewGroup parent) {
        //ImageView a retornar
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(210,210));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        //Setear la imagen desde el recurso drawable
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }


}