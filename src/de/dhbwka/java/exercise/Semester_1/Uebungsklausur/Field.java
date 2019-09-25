package de.dhbwka.java.exercise.Semester_1.Uebungsklausur;

public class Field {

    private String label;
    private int value;
    private boolean doublefield;

    public Field(){
    }

    public Field(String label, int value, boolean doublefield) {
        this.label = label;
        this.value = value;
        this.doublefield = doublefield;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isDoublefield() {
        return doublefield;
    }

    public void setDoublefield(boolean doublefield) {
        this.doublefield = doublefield;
    }
}
