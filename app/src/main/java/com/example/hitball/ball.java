package com.example.hitball;

public class ball {
    private int hp; // private fields include healthpoints
    public ball(int healthpoints){ //constructor
        hp = healthpoints;
    }
    public int gethp() {//get the healthpoints;
        return hp;
    }
    public void hurt(){ // function hurt(attack)
        hp--;
    }
}
