package de.dhbwka.java.exercise.Probeklausuren;

import java.awt.*;

public class Player {

    String name;
    int punktzahl;
    PlayerStatus status;

    public Player(String name){
        this.name = name;
        this.punktzahl =0;
        this.status = PlayerStatus.WAITING;
}

    public void addPunkt(){
        this.punktzahl++;
    }

    public void setPlayerStatus(PlayerStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return   name + " ("+ punktzahl +")";
    }

    public enum PlayerStatus{
       ACTIVE(Color.ORANGE),
       WAITING(Color.BLACK),
       FINISHED(Color.GRAY);

        public Color color;

        PlayerStatus(Color color){
            this.color = color;
        }

    }
}
