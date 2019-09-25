package de.dhbwka.java.exercise.Semester_1.Strings;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args){

        System.out.println("Bitte Wort zur Palindromüberprüfung eingeben");
        boolean p = true;
        Scanner scan = new Scanner(System.in);
        String wort = scan.next();
        String[] buchstaben = wort.split("");
        String[] verdrehteBS = new String[buchstaben.length];
        int j = 0;
        for(int i = buchstaben.length-1; i>=0; i--){
            verdrehteBS[i] = buchstaben[j];
            /*if(verdrehteBS[i] != buchstaben[j]){
                p =false;
            }*/
            j++;
        }

        for(int i=0; i<buchstaben.length; i++){
            System.out.println(buchstaben[i] + " " + verdrehteBS[i]);
        }


       for(int i=0; i<buchstaben.length; i++){
            if(!buchstaben[i].equals(verdrehteBS[i])){
                System.out.println(wort +" ist leider kein Palindrom");
                p = false;
                break;
            }
        }
        if (p == true){
            System.out.println(wort +" ist ein Palindrom");
        }



    }

}
