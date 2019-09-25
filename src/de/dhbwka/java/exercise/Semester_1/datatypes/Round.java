package de.dhbwka.java.exercise.Semester_1.datatypes;

import java.util.regex.Pattern;

public class Round {

    public static void main(String[] args) {

        //Attribute
        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = 2.7182818; // Naeherung der Eulerschen Zahl e
        double wert = e;
        boolean gerade = true; //zur Fallunterscheidung positiv/negativ

        if(wert <0){ //ist Zahl negativ?
            gerade = false;
        }

        System.out.println("Zahl: " +wert);

        //Zahl in String umwandeln, String bei Komma spalten und die erste Stelle der Nachkommazahl beachten
        String zahl = String.valueOf(wert);
        String[] teil = zahl.split( Pattern.quote( "." ) );
        String rundstelle = String.valueOf(teil[1].charAt(0));

        if(gerade == true){
            if(Integer.valueOf(rundstelle) > 4){
                System.out.println("gerundet: " + (Integer.valueOf(teil[0])+1));
            } else{
                System.out.println("gerundet: " + Integer.valueOf(teil[0]));
            }
        } else {
            if(Integer.valueOf(rundstelle) > 4){
                System.out.println("gerundet: " + (Integer.valueOf(teil[0])-1));
            } else{
                System.out.println("gerundet: " + Integer.valueOf(teil[0]));
            }
        }
        System.out.println("Die Lösung funktioniert, ist aber hart unnötig lang!");

        //ANDERE/BESSERE LÖSUNG, FUNKTIONIERT ABER NUR BEI POSITIVEN ZAHLEN
        int x =  (int)wert;
        double y = wert - x;

        if(y >= 0.5){
            System.out.println(x +1);
        } else {
            System.out.println(x);
        }



    }



}
