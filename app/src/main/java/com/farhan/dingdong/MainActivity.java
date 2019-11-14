package com.farhan.dingdong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.textView);
        progressBar.setMax(100);
        progressBar.setScaleX(1f);
        progressAnimation();
    }

    public void progressAnimation(){

        ProgressbarAnimation progressbarAnimation = new ProgressbarAnimation(this,progressBar,textView,0f,100f);
        progressbarAnimation.setDuration(5000);
        progressBar.setAnimation(progressbarAnimation);
    }

}
