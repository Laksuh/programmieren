package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import java.awt.*;

public enum Status {

    ACTIVE(Color.ORANGE),
    CORRECT(Color.GREEN),
    WRONG(Color.RED),
    PENDING(Color.WHITE),
    NO_ANSWER(Color.GRAY);

    Color color;

    private Status(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
