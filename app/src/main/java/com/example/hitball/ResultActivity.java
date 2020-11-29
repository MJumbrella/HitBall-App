package com.example.hitball;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String w1="";//initialize winner names
        String w2="";
        if (getIntent().hasExtra("key")){ // check if get the strings about winners from the last activity correctly
            String[] reach = getIntent().getExtras().getStringArray("key"); // get the winner info from the last activity
            w1 = reach [0]; // change the winner names to the ones from the last activities
            w2 = reach [1];
        }
        TextView win1 = (TextView) findViewById(R.id.winner1);//find the winner display window
        TextView win2 = (TextView) findViewById(R.id.winner2);
        win1.setText(w1);//display the winners!
        win2.setText(w2);
    }

    public void onBackClick(View view) {
        finish();//end
    }
}