package com.example.hitball;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    AnimationDrawable startAnimation;
    MediaPlayer player;

    private Button to_tutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       to_tutorial = (Button) findViewById(R.id.tutorial);
       to_tutorial.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               player.pause();
               opentutorial();
           }
       });

        player = MediaPlayer.create(HomeActivity.this, R.raw.silence);
        player.setLooping(true);
        player.start();


        ImageButton start = (ImageButton) findViewById(R.id.Start); // initilization: get the start button
        start.setBackgroundResource(R.drawable.animation);
        startAnimation=(AnimationDrawable) start.getBackground();
        start.setOnClickListener(new View.OnClickListener() { // what happens when click
            @Override
            public void onClick(View v) {
                Intent next = new Intent(HomeActivity.this,Playerinfo.class); //set intent for going to playerinfo class
                startActivity(next); // click to continue to the next activity
                //player.pause();
            }
        });

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        startAnimation.start();
    }

    public void opentutorial() {
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }

}