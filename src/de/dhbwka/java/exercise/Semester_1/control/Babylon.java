package de.dhbwka.java.exercise.Semester_1.control;

public class Babylon{
    public static void main( String[] args ) {

        double a = 625;
        double x_last = a;
        double x = a;

        do {
            x_last = x;
            x = (x_last + a/x_last)/2;
            System.out.println(x);
        }while(Math.abs(x-x_last) > 0.0000001);

    }
}