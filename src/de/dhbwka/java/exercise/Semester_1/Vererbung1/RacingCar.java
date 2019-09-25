package de.dhbwka.java.exercise.Semester_1.Vererbung1;

public class RacingCar extends Car {

    //Methoden
    //Konstruktoren
    public RacingCar(){
        this.vmax = 220;
    }

    public RacingCar(double v) {
        super(v);
        this.vmax = 220;
    }
}
