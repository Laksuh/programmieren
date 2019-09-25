package de.dhbwka.java.exercise.Semester_1.control;

public class TemperatureTable {
    public static void main( String[] args ) {

        for(int i = 0; i <= 300; i = i+20){
            double celsius = (5./9.)*(i-32);
            System.out.println(i +" | " +celsius);
        }

    }
}
