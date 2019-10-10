package de.dhbwka.java.exercise.Vorlagen;

import java.util.ArrayList;

public interface Interface {

    public String getPlayerName();
    public int getPoints();
    public void setRemainingSeconds(int seconds);
    public void gameIsOver();
    public void end(ArrayList<String> names, ArrayList<Integer> points);

}