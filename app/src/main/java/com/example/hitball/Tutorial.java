package com.example.hitball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tutorial extends AppCompatActivity {

    private Button to_main;
    MediaPlayer player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        player2 = MediaPlayer.create(Tutorial.this, R.raw.silence);
        player2.setLooping(true);
        player2.start();

        to_main = (Button) findViewById(R.id.back);
        to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player2.pause();
                backtomain();
            }
        });
    }

    public void backtomain() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}