package com.example.task_ovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button stbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        stbut=(Button)findViewById(R.id.button_start);
        stbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Startup();
            }
        });
    }

    public void Startup(){ // Metodo para que el boton comunique con la otra pantalla
        Intent intent = new Intent(this,LoadScreenActivity.class);
        startActivity(intent);
    }
}