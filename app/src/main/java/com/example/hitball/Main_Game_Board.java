package com.example.hitball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//this is a message to show that wenting has pushed


public class Main_Game_Board extends AppCompatActivity {
    private int i = 100;
    private int i2 = 100;
    private int i3 = 100;
    private int iball = 100;
    private int i4 = 100; //set the counter for the player's health bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__game__board);
        TextView p1name = (TextView) findViewById(R.id.board_tv_player1); // get textview info
        TextView p2name = (TextView) findViewById(R.id.board_tv_player2);
        TextView p3name = (TextView) findViewById(R.id.board_tv_player3);
        TextView p4name = (TextView) findViewById(R.id.board_tv_player4);
        TextView p1hp = (TextView) findViewById(R.id.board_tv_health1);
        TextView p2hp = (TextView) findViewById(R.id.board_tv_health2);
        TextView p3hp = (TextView) findViewById(R.id.board_tv_health3);
        TextView p4hp = (TextView) findViewById(R.id.board_tv_health4);
        TextView balhp = (TextView) findViewById(R.id.ballhealth);


       ProgressBar pgsBar = (ProgressBar) findViewById(R.id.progressBar1); //intialize the health bar;
        pgsBar.setProgress(100);
        ProgressBar pgsBar2 = (ProgressBar) findViewById(R.id.progressBar2); //intialize the health bar;
        pgsBar2.setProgress(100);
        ProgressBar pgsBar3 = (ProgressBar) findViewById(R.id.progressBar4); //intialize the health bar;
        pgsBar3.setProgress(100);
        ProgressBar pgsBar4 = (ProgressBar) findViewById(R.id.progressBar3); //intialize the health bar;
        pgsBar4.setProgress(100);
        ProgressBar pgsBarball = (ProgressBar) findViewById(R.id.progressBar5); //intialize the health bar;
        pgsBarball.setProgress(100);


        String name1 = ""; //initialize names in string (default)
        String name2 = "";
        String name3 = "";
        String name4 = "";
        int player1hp = 5; //initialize the healthpoints of players and ball
        int player2hp = 5;
        int player3hp = 5;
        int player4hp = 5;
        int ballhp = 7;

        if (getIntent().hasExtra("key")){ // check if get the strings from the last activity correctly
            String[] reach = getIntent().getExtras().getStringArray("key"); // get the string array about player names from the last activity
            name1 = reach [0]; // change the names to the ones from the last activities
            name2 = reach [1];
            name3 = reach [2];
            name4 = reach [3];
            p1name.setText(name1); // copy the name from the last activity
            p2name.setText(name2);
            p3name.setText(name3);
            p4name.setText(name4);
        }

        ball centerball = new ball(ballhp); //initialize the center ball object
        player p1 = new player(player1hp,name1);
        player p2 = new player(player2hp,name2);
        player p3 = new player(player3hp,name3);
        player p4 = new player(player4hp,name4);

        String [] names = new String[4];//initialize a names array storing all the four names
        names[0] = p1.getname();
        names[1] = p2.getname();
        names[2] = p3.getname();
        names[3] = p4.getname();

        Button attackleft = (Button) findViewById(R.id.al); // get the four action buttons from the gameboard
        Button attackright = (Button) findViewById(R.id.ar);
        Button attackball = (Button) findViewById(R.id.ab);
        Button heals = (Button) findViewById(R.id.he);

        int[] counter = {0}; // initialize a counter
        TextView turn = (TextView) findViewById(R.id.board_your_turn); //get textview "your turn" from the board


        String[] playername = {names[counter[0] % 4]}; // get this turn's player name
        String round = "Your Turn: "+ playername[0]; // initialize the round (first round) with the first player's name
        turn.setText(round); // display the first player's turn

        String hp = "Healthpoints:"; // initialize the hp string
        p1hp.setText(hp+Integer.toString(p1.gethp())); //set healthpoints texts
        p2hp.setText(hp+Integer.toString(p2.gethp()));
        p3hp.setText(hp+Integer.toString(p3.gethp()));
        p4hp.setText(hp+Integer.toString(p4.gethp()));
        balhp.setText(hp +Integer.toString(centerball.gethp()));

        String Name1 = name1;//copy names onece again for the next clicks
        String Name2 = name2;
        String Name3 = name3;
        String Name4 = name4;

        attackleft.setOnClickListener(new View.OnClickListener() {// what happens when clik attackleft
            @Override
            public void onClick(View v) {
                String playername = names[counter[0] %4]; // get this turn's player name
                if (playername == Name1){ // attack left!
                    p2.hurt();
                }
                else if (playername == Name2) {
                    p3.hurt();
                }
                else if (playername == Name3) {
                    p4.hurt();
                }
                else{
                    p1.hurt();
                }
                if (p1.gethp()<=0 || p3.gethp()<=0){ //check if one group member dies, the other win and pass to the next activity
                    Intent nexta = new Intent(Main_Game_Board.this,ResultActivity.class);
                    String [] pass = {p2.getname(),p4.getname()};
                    nexta.putExtra("key",pass); // prepare to pass the array to the result activity
                    startActivity(nexta); // click to change to the gameboard class
                    finish();//end
                }
                else if(p2.gethp()<=0 || p4.gethp()<=0){//check if one group member dies, the other win and pass to the next activity
                    Intent nexta = new Intent(Main_Game_Board.this,ResultActivity.class);
                    String [] pass = {p1.getname(),p3.getname()};
                    nexta.putExtra("key",pass); // prepare to pass the array to the result activity
                    startActivity(nexta); // click to change to the gameboard class
                    finish();//end
                }
                p1hp.setText(hp+Integer.toString(p1.gethp())); //set healthpoints texts
                i = p1.gethp();
                i = (100/5)* i;
                pgsBar.setProgress(i);

                p2hp.setText(hp+Integer.toString(p2.gethp()));

                i2 = p2.gethp();
                i2 = (100/5)* i2;
                pgsBar2.setProgress(i2); //set the progress bar

                p3hp.setText(hp+Integer.toString(p3.gethp()));
                i2 = p3.gethp();
                i2 = (100/5)* i2;
                pgsBar3.setProgress(i2); //set the progress bar

                p4hp.setText(hp+Integer.toString(p4.gethp()));
                i2 = p4.gethp();
                i2 = (100/5)* i2;
                pgsBar4.setProgress(i2); //set the progress bar

                balhp.setText(hp +Integer.toString(centerball.gethp()));
                i2 = centerball.gethp();
                i2 = (100/7)* i2;
                pgsBarball.setProgress(i2); //set the progress bar

                counter[0] += 1;
                String newplayername = names[counter[0] %4]; // get next turn's player name
                String round = "Your Turn: "+ newplayername; // change the round with the new player name
                turn.setText(round); // display the this player's turn
            }
        });

        attackright.setOnClickListener(new View.OnClickListener() { // what happens when clik attackright
            @Override
            public void onClick(View v) {
                String playername = names[counter[0] %4]; // get this turn's player name
                if (playername == Name1){ // attack right!
                    p4.hurt();
                }
                else if (playername == Name2) {
                    p1.hurt();
                }
                else if (playername == Name3) {
                    p2.hurt();
                }
                else{
                    p3.hurt();
                }
                if (p1.gethp()<=0 || p3.gethp()<=0){ //check if one group member dies, the other win and pass to the next activity
                    Intent nexta = new Intent(Main_Game_Board.this,ResultActivity.class);
                    String [] pass = {p2.getname(),p4.getname()};
                    nexta.putExtra("key",pass); // prepare to pass the array to the result activity
                    startActivity(nexta); // click to change to the gameboard class
                    finish();//end
                }
                else if(p2.gethp()<=0 || p4.gethp()<=0){//check if one group member dies, the other win and pass to the next activity
                    Intent nexta = new Intent(Main_Game_Board.this,ResultActivity.class);
                    String [] pass = {p1.getname(),p3.getname()};
                    nexta.putExtra("key",pass); // prepare to pass the array to the result activity
                    startActivity(nexta); // click to change to the gameboard class
                    finish();//end
                }
                p1hp.setText(hp+Integer.toString(p1.gethp())); //set healthpoints texts
                i = p1.gethp();
                i = (100/5)* i;
                pgsBar.setProgress(i);

                p2hp.setText(hp+Integer.toString(p2.gethp()));

                i2 = p2.gethp();
                i2 = (100/5)* i2;
                pgsBar2.setProgress(i2); //set the progress bar

                p3hp.setText(hp+Integer.toString(p3.gethp()));
                i2 = p3.gethp();
                i2 = (100/5)* i2;
                pgsBar3.setProgress(i2); //set the progress bar

                p4hp.setText(hp+Integer.toString(p4.gethp()));
                i2 = p4.gethp();
                i2 = (100/5)* i2;
                pgsBar4.setProgress(i2); //set the progress bar

                balhp.setText(hp +Integer.toString(centerball.gethp()));
                i2 = centerball.gethp();
                i2 = (100/7)* i2;
                pgsBarball.setProgress(i2); //set the progress bar
                counter[0] += 1;
                String newplayername = names[counter[0] %4]; // get next turn's player name
                String round = "Your Turn: "+ newplayername; // change the round with the new player name
                turn.setText(round); // display the this player's turn
            }
        });

        attackball.setOnClickListener(new View.OnClickListener() {// what happens when clik attackball
            @Override
            public void onClick(View v) {
                String playername = names[counter[0] %4]; // get this turn's player name
                if (playername == Name1){ // attack the ball!
                    centerball.hurt();
                    if (p1.gethp()<=2){//activate the buff!
                        centerball.hurt();
                    }
                    p1.hurt(); //Attack the ball will result in lost of HP
                }
                else if (playername == Name2) {
                    centerball.hurt();
                    if (p2.gethp()<=2){//activate the buff!
                        centerball.hurt();
                    }
                    p2.hurt();
                }
                else if (playername == Name3) {
                    centerball.hurt();
                    if (p3.gethp()<=2){//activate the buff!
                        centerball.hurt();
                    }
                    p3.hurt();
                }
                else{
                    centerball.hurt();
                    if (p4.gethp()<=2){//activate the buff!
                        centerball.hurt();
                    }
                    p4.hurt();
                }
                if (centerball.gethp()<=0){//check if the ball has no hp to decide which team wins
                    if (playername == p1.getname() || playername == p3.getname()){
                        Intent nexta = new Intent(Main_Game_Board.this,ResultActivity.class);
                        String [] pass = {p1.getname(),p3.getname()};
                        nexta.putExtra("key",pass); // prepare to pass the array to the result activity
                        startActivity(nexta); // click to change to the gameboard class
                        finish();//end
                    }
                    else{
                        Intent nexta = new Intent(Main_Game_Board.this,ResultActivity.class);
                        String [] pass = {p2.getname(),p4.getname()};
                        nexta.putExtra("key",pass); // prepare to pass the array to the result activity
                        startActivity(nexta); // click to change to the gameboard class
                        finish();//end
                    }
                }
                else if (p1.gethp()<=0 || p2.gethp()<=0 || p3.gethp()<=0 || p4.gethp()<=0) {
                    if (p1.gethp() <= 0 || p3.gethp() <= 0) { //check if one group member dies, the other win and pass to the next activity
                        Intent nexta = new Intent(Main_Game_Board.this, ResultActivity.class);
                        String[] pass = {p2.getname(), p4.getname()};
                        nexta.putExtra("key", pass); // prepare to pass the array to the result activity
                        startActivity(nexta); // click to change to the gameboard class
                        finish();//end
                    } else if (p2.gethp() <= 0 || p4.gethp() <= 0) {//check if one group member dies, the other win and pass to the next activity
                        Intent nexta = new Intent(Main_Game_Board.this, ResultActivity.class);
                        String[] pass = {p1.getname(), p3.getname()};
                        nexta.putExtra("key", pass); // prepare to pass the array to the result activity
                        startActivity(nexta); // click to change to the gameboard class
                        finish();//end
                    }
                }
                p1hp.setText(hp+Integer.toString(p1.gethp())); //set healthpoints texts
                i = p1.gethp();
                i = (100/5)* i;
                pgsBar.setProgress(i);

                p2hp.setText(hp+Integer.toString(p2.gethp()));

                i2 = p2.gethp();
                i2 = (100/5)* i2;
                pgsBar2.setProgress(i2); //set the progress bar

                p3hp.setText(hp+Integer.toString(p3.gethp()));
                i2 = p3.gethp();
                i2 = (100/5)* i2;
                pgsBar3.setProgress(i2); //set the progress bar

                p4hp.setText(hp+Integer.toString(p4.gethp()));
                i2 = p4.gethp();
                i2 = (100/5)* i2;
                pgsBar4.setProgress(i2); //set the progress bar

                balhp.setText(hp +Integer.toString(centerball.gethp()));
                i2 = centerball.gethp();
                i2 = (100/7)* i2;
                pgsBarball.setProgress(i2); //set the progress bar
                counter[0] += 1;
                String newplayername = names[counter[0] %4]; // get next turn's player name
                String round = "Your Turn: "+ newplayername; // change the round with the new player name
                turn.setText(round); // display the this player's turn
            }
        });

        heals.setOnClickListener(new View.OnClickListener() {// what happens when clik heals
            @Override
            public void onClick(View v) {
                String playername = names[counter[0] %4]; // get this turn's player name
                if (playername == Name1){ // heals your ally!
                    p3.cure();
                }
                else if (playername == Name2) {
                    p4.cure();
                }
                else if (playername == Name3) {
                    p1.cure();
                }
                else{
                    p2.cure();
                }
                p1hp.setText(hp+Integer.toString(p1.gethp())); //set healthpoints texts
                i = p1.gethp();
                i = (100/5)* i;
                pgsBar.setProgress(i);

                p2hp.setText(hp+Integer.toString(p2.gethp()));

                i2 = p2.gethp();
                i2 = (100/5)* i2;
                pgsBar2.setProgress(i2); //set the progress bar

                p3hp.setText(hp+Integer.toString(p3.gethp()));
                i2 = p3.gethp();
                i2 = (100/5)* i2;
                pgsBar3.setProgress(i2); //set the progress bar

                p4hp.setText(hp+Integer.toString(p4.gethp()));
                i2 = p4.gethp();
                i2 = (100/5)* i2;
                pgsBar4.setProgress(i2); //set the progress bar

                balhp.setText(hp +Integer.toString(centerball.gethp()));
                i2 = centerball.gethp();
                i2 = (100/7)* i2;
                pgsBarball.setProgress(i2); //set the progress bar
                counter[0] += 1;
                String newplayername = names[counter[0] %4]; // get next turn's player name
                String round = "Your Turn: "+ newplayername; // change the round with the new player name
                turn.setText(round); // display the this player's turn
            }
        });


    }

}