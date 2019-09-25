package de.dhbwka.java.exercise.Semester_2.Probeklausur;

public class Bieter {

    //Attribute
    String vorname;
    String nachname;

    public Bieter(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getFullName(){
        return vorname+" " +nachname;
    }
}
