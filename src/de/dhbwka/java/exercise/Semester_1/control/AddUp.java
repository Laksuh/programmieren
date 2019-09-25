package de.dhbwka.java.exercise.Semester_1.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AddUp {

    public static void main( String[] args ) throws IOException {
        int summe = 0;
        System.out.println("Zahlen zum Aufaddieren eingeben, abbruch mit negativer Zahl");

        while(true) {
            System.out.println("Zahl eingeben");

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String eingabe = br.readLine();
            int eing = Integer.parseInt(eingabe);

            if(eing<0){
                System.out.println(summe);
                break;
            }
            summe = summe + eing;
        }


    }

}
