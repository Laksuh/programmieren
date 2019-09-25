package de.dhbwka.java.exercise.Semester_1.Vererbung1;

public class Car extends Vehicle {

    //Methoden
    //Konstruktoren
    public Car(){
        this.wheels = 4;
        this.vmax = 140;
    }

    public Car(double v) {
        super(v);
        this.wheels = 4;
        this.vmax = 140;
    }
}
