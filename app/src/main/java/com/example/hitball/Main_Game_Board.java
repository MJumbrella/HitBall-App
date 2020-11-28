package com.example.hitball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Game_Board extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__game__board);

    }

    public void onBackClick(View view) {
        startActivity(new Intent(this, ResultActivity.class));
        finish();//end

    }
}