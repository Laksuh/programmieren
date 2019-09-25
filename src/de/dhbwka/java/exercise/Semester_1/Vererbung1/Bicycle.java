package de.dhbwka.java.exercise.Semester_1.Vererbung1;

public class Bicycle extends Vehicle {

    //Methoden
    //Konstruktoren
    public Bicycle() {
        this.wheels = 2;
        this.vmax = 30;
    }

    public Bicycle(double v) {
        super(v);
        this.wheels = 2;
        this.vmax = 30;
    }
}
