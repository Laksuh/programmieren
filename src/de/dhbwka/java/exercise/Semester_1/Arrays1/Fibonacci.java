package de.dhbwka.java.exercise.Semester_1.Arrays1;

public class Fibonacci {

    public static void main( String[] args ) {

        int fibo[] = new int[20];

        fibo[0] = fibo[1] = 1;
        for(int i=2; i < fibo.length; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
            System.out.println(fibo[i]);
        }


    }

}
