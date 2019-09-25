package de.dhbwka.java.exercise.Semester_2.Threads;

public class LightPhase {

    private String name;
    private boolean red;
    private boolean yellow;
    private boolean green;
    private int duration;
    private LightPhase next;

    public LightPhase getNext() {
        return this.next;
    }

    public LightPhase(String name, boolean red, boolean yellow, boolean green, int duration, LightPhase next) {
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isYellow() {
        return yellow;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNext(LightPhase next) {
        this.next = next;
    }

    public LightPhase(String name, boolean red, boolean yellow, boolean green, int duration) {
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
    }
}
