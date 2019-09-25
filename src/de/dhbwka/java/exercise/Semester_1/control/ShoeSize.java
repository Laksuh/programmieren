package de.dhbwka.java.exercise.Semester_1.control;

public class ShoeSize {

    public static void main( String[] args )  {


        for(double g = 19.33; g <=33; g = g+ (2./3.) ){
           double ng = g+(2./3.);
            System.out.println(g +" - " +ng +" | " + Math.round(ng*1.5));
        }

    }

}
