package de.dhbwka.java.exercise.Semester_2.Probeklausur;

public class Gebot {

    //Attribute
    double hoechstbetrag;
    Bieter bieter = new Bieter("---","");

    public void setHoechstbetrag(double hoechstbetrag) {
        this.hoechstbetrag = hoechstbetrag;
    }

    public Gebot(double wert, Bieter bieter){
        this.hoechstbetrag=wert;
        this.bieter=bieter;
    }

    public Gebot(){

    }

}
