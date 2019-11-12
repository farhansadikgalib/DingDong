package com.farhan.dingdong;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends Activity {


    int[] sounds={R.raw.xp_error_mix, R.raw.yeahyeah, R.raw.toads, R.raw.dingdong};

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn =  findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random r = new Random();
                int Low = 0;
                int High = 4;
                int rndm = r.nextInt(High-Low)/1+1;
                final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), sounds[rndm]);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        mp.pause();
                        mp.stop();
                        mp.release();
                    }
                });
                mediaPlayer.start();


            }
        });





        //final MediaPlayer mp = MediaPlayer.create(this, R.raw.blackberry.mp3);

        //Button play_button = (Button)this.findViewById(R.id.play_button);
        //play_button.setOnClickListener(new View.OnClickListener() {
        // public void onClick(View v) {

        // mp.start();
        //}
        // });

    }



}