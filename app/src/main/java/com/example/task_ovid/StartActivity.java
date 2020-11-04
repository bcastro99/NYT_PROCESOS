package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private ImageButton stbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        stbut= (ImageButton) findViewById(R.id.button_start);
        stbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Startup();
            }
        });
    }

    public void Startup(){ // Metodo para que el boton comunique con la otra pantalla
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}