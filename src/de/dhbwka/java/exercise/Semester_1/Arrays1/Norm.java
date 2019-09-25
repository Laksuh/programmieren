package de.dhbwka.java.exercise.Semester_1.Arrays1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Norm {

    public static void main( String[] args ) throws IOException {

        double x[] = new double[3];
        for(int i=0; i<3; i++) {
            System.out.println("Vektor angeben x0,x1,x2");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String eingabe = br.readLine();
            x[i] = Double.parseDouble(eingabe);
        }
        double produkt = 0;
        for(int i=0; i<3; i++) {

            produkt = produkt + x[i]*x[i];

        }
        produkt = Math.sqrt(produkt);
        System.out.println("Betrag ist " +produkt);
    }
}
