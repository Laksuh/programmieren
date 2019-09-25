package de.dhbwka.java.exercise.Semester_1.control;

import static jdk.nashorn.internal.parser.TokenType.AND;

public class LeapYear {

    public static void main( String[] args ) {
        int jahr = 2100;
        int vier = jahr % 4;
        int hundert = jahr % 100;
        int vierhundert = jahr % 400;
        boolean schaltjahr = false;

        if(vier == 0) {
            schaltjahr = true;
            if(hundert == 0){
                schaltjahr = false;
                if(vierhundert == 0){
                    schaltjahr = true;
                }
            }
        }
        System.out.println(jahr +" " +schaltjahr);
    }
}
//System.out.println(jahr +" ist ein Schaltjahr");