package com.example.hitball;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Playerinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerinfo);
        EditText p1 = (EditText) findViewById(R.id.p1); // get the names from user
        EditText p2 = (EditText) findViewById(R.id.p2);
        EditText p3 = (EditText) findViewById(R.id.p3);
        EditText p4 = (EditText) findViewById(R.id.p4);

        p1.setTextColor(Color.parseColor("#FFFFFF"));
        p2.setTextColor(Color.parseColor("#FFFFFF"));
        p3.setTextColor(Color.parseColor("#FFFFFF"));
        p4.setTextColor(Color.parseColor("#FFFFFF"));

        Button next = (Button) findViewById(R.id.Continue); // initilization: get the continue button
        next.setOnClickListener(new View.OnClickListener() { // what happens when click
            @Override
            public void onClick(View v) {
                Intent nexta = new Intent(Playerinfo.this,Main_Game_Board.class); //set intent for going to gameboard class
                String s1 = p1.getText().toString(); // convert the names to string
                String s2 = p2.getText().toString();
                String s3 = p3.getText().toString();
                String s4 = p4.getText().toString();
                String[] pass = new String[4]; // initiate a string array
                pass[0] = s1; // put names to the array
                pass[1] = s2;
                pass[2] = s3;
                pass[3] = s4;
                nexta.putExtra("key",pass); // prepare to pass the array to the gameboard activity
                startActivity(nexta); // click to change to the gameboard class
                finish();//end
            }
        });
    }
}