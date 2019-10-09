package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import java.util.ArrayList;

public interface GameClient {
    public String getPlayerName();
    public int getPoints();
    public void setQuestion(int questionIndex, Question q);
    public void setRemainingSeconds(int seconds);
    public void gameIsOver();
    public void setAnswerState(int questionIndex, Status status);
    public void end(ArrayList<String> names, ArrayList<Integer> points);
}