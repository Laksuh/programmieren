package de.dhbwka.java.exercise.Semester_1.Arrays1;

public class StandardDeviation {

    public static void main( String[] args ) {

        int zahlen[] = new int[100];
        double summe = 0;

        for(int i = 0; i<100; i++){
            zahlen[i] = (int) (Math.random() * 11);
            summe = summe + zahlen[i];
            System.out.println(zahlen[i]);
        }
        System.out.println(summe/100);
    }


}
