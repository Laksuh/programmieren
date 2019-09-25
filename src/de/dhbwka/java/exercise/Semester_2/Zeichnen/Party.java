package de.dhbwka.java.exercise.Semester_2.Zeichnen;

import java.awt.*;

public class Party {

    //Attribute
    String name;
    double percentage;
    Color color;

    //Konstruktoren
    public Party(){

    }
    public Party(String name, double percentage, Color color){
        this.name = name;
        this.percentage = percentage;
        this.color = color;
    }

    //toString
    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                ", color=" + color +
                '}';
    }

    //Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
