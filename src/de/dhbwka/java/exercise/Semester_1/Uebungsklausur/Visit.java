package de.dhbwka.java.exercise.Semester_1.Uebungsklausur;

public class Visit {

    private Field[] fields;

    public Visit(Field[] fields) {
        if(fields.length>3){
            throw new IllegalArgumentException("Zu viele Darts geworfen!");
        }
        this.fields = fields;
    }

    public Field[] getFields(){
        return this.fields;
    }

    public int getValue(){
        int summe=0;
        for(int i=0;i<fields.length;i++){
            summe = summe +fields[i].getValue();
        }
        return summe;
    }

    public Field getLastField(){
        return fields[fields.length-1];
    }

}
