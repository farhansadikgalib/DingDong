package com.farhan.dingdong;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
         final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.x_dingtone);
        //final MediaPlayer  mediaPlayer = MediaPlayer.create(this,R.raw.nokia_ringtone);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Start DingDong",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

            }
        });

    }
}
