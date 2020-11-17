package com.example.task_ovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadScreenActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        pb=(ProgressBar)findViewById(R.id.progress_bar);
        tv=(TextView) findViewById(R.id.text_view);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pb.setMax(100);
        pb.setScaleY(3f);

        progressAnimation();
    }

    public void progressAnimation(){
        PBAnimation anim= new PBAnimation(this, pb, tv, 0f, 100f);
        anim.setDuration(8000);
        pb.setAnimation(anim);
    }

}