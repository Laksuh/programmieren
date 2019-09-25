package de.dhbwka.java.exercise.Semester_1.Strings;

import java.util.Scanner;

public class CrossTotal {

    public static void main(String[] args){

        System.out.println("Bitte Zahl zur Quersummenberechnung eingeben");

        Scanner scan = new Scanner(System.in);
        String zahl = scan.next();
        String[] zahlen = zahl.split("");
        int quersumme=0;

        for(int i = 0; i<zahlen.length; i++){
            quersumme = quersumme + Integer.parseInt(zahlen[i]);
        }

        System.out.println("Quersumme von "+ zahl +" ist " +quersumme);

    }

}
