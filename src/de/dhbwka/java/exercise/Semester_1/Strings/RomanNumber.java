package de.dhbwka.java.exercise.Semester_1.Strings;

import java.util.Scanner;

public class RomanNumber {

    public static void main(String[] args){

        System.out.println("Bitte Römische Zahl eingeben");

        Scanner scan = new Scanner(System.in);
        String zahl = scan.next();
        zahl = zahl +"0";
        String[] zahlen = zahl.split("");
        int ergebnis = 0;

        for(int i=0; i<zahlen.length; i++){
            switch (zahlen[i]){
                case "M":
                    ergebnis = ergebnis +1000;
                    break;
                case "D":
                    ergebnis = ergebnis +500;
                    break;
                case "C": if(zahlen[i+1].equals("M")){
                    ergebnis = ergebnis +900;
                    i++;
                } else{
                    ergebnis = ergebnis +100;
                } break;
                case "L": if(zahlen[i+1].equals("D")){
                    ergebnis = ergebnis +450;
                    i++;
                } else{
                    ergebnis = ergebnis +50;
                } break;
                case "X": if(zahlen[i+1].equals("C")){
                    ergebnis = ergebnis +90;
                    i++;
                } else{
                    ergebnis = ergebnis +10;
                } break;
                case "V":if(zahlen[i+1].equals("L")){
                    ergebnis = ergebnis +45;
                    i++;
                } else{
                    ergebnis = ergebnis +5;
                } break;
                case "I": if(zahlen[i+1].equals("V")){
                    ergebnis = ergebnis +4;
                    i++;
                } else if (zahlen[i+1].equals("X")){
                    ergebnis = ergebnis +9;
                    i++;
                } else {
                    ergebnis = ergebnis+1;
                    break;
                }
            }
        }
        System.out.println(ergebnis);


    }

}
