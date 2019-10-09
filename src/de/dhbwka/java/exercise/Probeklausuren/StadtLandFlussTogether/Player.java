package de.dhbwka.java.exercise.Probeklausuren.StadtLandFlussTogether;

public class Player {

    String name;
    int points;

    public Player(String name){
        this.name = name;
        points = 0;
    }

    public void addPoints(int i) {
        points += i;
    }
}
