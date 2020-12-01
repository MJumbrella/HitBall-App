package com.example.hitball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tutorial extends AppCompatActivity {

    private Button to_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        to_main = (Button) findViewById(R.id.back);
        to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backtomain();
            }
        });
    }

    public void backtomain() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}