package de.dhbwka.java.exercise.Semester_1.Vererbung1;

public class Ambulance extends Car {

    //Attribute
    boolean siren = false;

    //Methoden
    //Konstruktoren
    public Ambulance() {

    }

    public Ambulance(double v, boolean siren) {
        super(v);
        this.siren = siren;
    }

    public boolean isSiren() {
        return siren;
    }

    public void setSiren(boolean siren) {
        this.siren = siren;
    }
}
