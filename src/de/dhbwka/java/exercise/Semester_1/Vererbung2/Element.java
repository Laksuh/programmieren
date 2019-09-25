package de.dhbwka.java.exercise.Semester_1.Vererbung2;

public class Element {

    //Attribute
    String name;
    String symbol;
    int ordinal;
    char shell;
    int phase;
    boolean main;

    //Methoden
    //Konstruktoren
    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean main) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.main = main;
    }
    //Standardkontruktor
    public Element(){

    }

    //weitere Methoden
    public boolean equals(Object o){
        if(o.getClass().getSimpleName() == "Element"){
            o = (Element) o;
            if(((Element) o).ordinal == this.ordinal){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //toString
    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", ordinal=" + ordinal +
                ", shell=" + shell +
                ", phase=" + phase +
                ", main=" + main +
                '}';
    }

    //Getter+Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public char getShell() {
        return shell;
    }

    public void setShell(char shell) {
        this.shell = shell;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
}
