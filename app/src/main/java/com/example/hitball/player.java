package com.example.hitball;

public class player {
    private int hp; // private fields include healthpoints and name
    private String name;
    public player(int healthpoints, String pname){ //constructor
        hp = healthpoints;
        name = pname;
    }
    public String getname(){ // get the name;
        return name;
    }
    public int gethp(){//get the healthpoints;
        return hp;
    }
    public void hurt(){ // function hurt(attack)
        hp--;
    }
    public void cure(){ // function cure(heals)
        hp++;
    }
}
