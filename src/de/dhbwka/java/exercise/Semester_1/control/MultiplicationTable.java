package de.dhbwka.java.exercise.Semester_1.control;

public class MultiplicationTable {
    public static void main( String[] args ) {

        for(int i = 1; i<=10; i++){

            for(int k = 1; k<=10; k++){
                System.out.printf("%4d", k*i );
            }
            System.out.println(" ");

        }

    }
}
