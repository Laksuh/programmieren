package de.dhbwka.java.exercise.Semester_1.Vererbung2;

public class Metal extends Element {

    boolean metalloid;
    double conductivity;


    //Methoden
    //Konstruktoren
    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean main, boolean metalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, main);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }
     //toString
    @Override
    public String toString() {
        return "Metal{" +
                "metalloid=" + metalloid +
                ", conductivity=" + conductivity +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", ordinal=" + ordinal +
                ", shell=" + shell +
                ", phase=" + phase +
                ", main=" + main +
                '}';
    }

    //Getter + Setter
    public boolean isMetalloid() {
        return metalloid;
    }

    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    public double getConductivity() {
        return conductivity;
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }
}
