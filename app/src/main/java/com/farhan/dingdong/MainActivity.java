package com.farhan.dingdong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   private Button button;
   private MediaPlayer player;
    AnimationDrawable animationDrawable;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        button = findViewById( R.id.btn );

        ImageView img = findViewById(R.id.image);
        img.setBackgroundResource(R.drawable.anim);
        animationDrawable = (AnimationDrawable) img.getBackground();

        final int[] sound= {R.raw.xp_error_mix,R.raw.yeahyeah,R.raw.dingdong,R.raw.dingdong};

        button.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction()== MotionEvent.ACTION_DOWN) {
                    animationDrawable.start();

                    Random random = new Random();
                    int low=0;
                    int high=3;
                    int rnd = random.nextInt(high-low)+low;

                    player= MediaPlayer.create( MainActivity.this,sound[rnd] );
                    player.start();

                    v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                    v.invalidate();
                }
                else if(event.getAction()==MotionEvent.ACTION_UP){
                    animationDrawable.stop();
                    animationDrawable.selectDrawable(0);
                    player.stop();
                    player.release();

                    v.getBackground().clearColorFilter();
                    v.invalidate();
                }
                return true;

            }

        } );


    }

 @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }





    @Override


    public boolean onOptionsItemSelected(MenuItem item){


        switch (item.getItemId()) {

            case R.id.shareme:

                Intent i = new Intent(
                        android.content.Intent.ACTION_SEND);

                i.setType("text/plain");

                startActivity(Intent.createChooser(i, "Share Via"));

                break;

        }
        return super.onOptionsItemSelected(item);

    }

}

