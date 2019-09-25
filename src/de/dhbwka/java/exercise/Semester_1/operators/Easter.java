package de.dhbwka.java.exercise.Semester_1.operators;

public class Easter {

    public static void main(String[] args) {

        int jahr = 2017;
        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int k = jahr / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int ostern = (22 + d + e); //(bezogen auf 1. März)

        if(ostern > 31){
            ostern = ostern - 31;
            System.out.println(ostern +". April " +jahr);
        } else {
            System.out.println(ostern +". März " +jahr);
        }



    }



}
