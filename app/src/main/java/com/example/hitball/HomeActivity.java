package com.example.hitball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton start = (ImageButton) findViewById(R.id.Start); // initilization: get the start button
        start.setOnClickListener(new View.OnClickListener() { // what happens when click
            @Override
            public void onClick(View v) {
                Intent next = new Intent(HomeActivity.this,Playerinfo.class); //set intent for going to playerinfo class
                startActivity(next); // click to continue to the next activity
            }
        });
    }
}