package de.dhbwka.java.exercise.Semester_1.Uebungsklausur;

import java.text.FieldPosition;

public class Board {

    private Field[] fields = new Field[63];

    public Board() {
        int j=0;
        for(int i=0; i<=19; i++){
            fields[j++] = new Field(""+i,i,false);
            fields[j++] = new Field("D"+i,2*i,true);
            fields[j++] = new Field("T"+i,3*i,false);
        }
        fields[j++] =  new Field("Single Bull", 25, false);
        fields[j++] =  new Field("BULL",50,true);
        fields[j++] =  new Field("x",0,false);
    }

    public Field parseField(String label){
        for(int i=0;i<fields.length;i++) {
            if (this.fields[i].getLabel().equalsIgnoreCase(label)) {
                return fields[i];
            }
        }
        return null;
    }
}
