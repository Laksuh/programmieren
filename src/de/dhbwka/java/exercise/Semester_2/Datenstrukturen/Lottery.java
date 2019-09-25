package de.dhbwka.java.exercise.Semester_2.Datenstrukturen;

import java.util.*;

public class Lottery {

    public static void main(String[] args){

        ArrayList lottozahlen = new ArrayList<Integer>();

        lottozahlen = erzeugeZahlen(lottozahlen);
        Set lz = macheSet(lottozahlen);
        System.out.println("Lottozahlen lauten: " +Arrays.toString(lz.toArray()) +" mit der Zusatzzahl: " +lottozahlen.indexOf(7));
    }

    public static ArrayList<Integer> erzeugeZahlen(ArrayList<Integer> lottozahlen){
        for(int i=1; i<50;i++){
            lottozahlen.add(i);
        }
        System.out.println(lottozahlen.toString());
        Collections.shuffle(lottozahlen);
        return lottozahlen;
    }

    public static Set macheSet(ArrayList<Integer> lottozahlen){
        Set lz = new HashSet();
        for(int i=1; i<7;i++){
            lz.add(lottozahlen.indexOf(i));
        }
        return lz;
    }

}
