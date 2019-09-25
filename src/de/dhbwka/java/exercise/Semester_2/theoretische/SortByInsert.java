package de.dhbwka.java.exercise.Semester_2.theoretische;

import java.util.Arrays;
import java.util.Date;

public class SortByInsert {



    public static void main(String[] args){
        int n =100000;
        int[] A = new int[n];
        A = macheZahlen(A);
        System.out.println(Arrays.toString(A));
        Date davor = new Date();
        for (int i=1;i <= n-1;i++){
            int x = A[i];
            int j=i;
            while(j>0 && A[j-1]> x){
                A[j] =A[j-1];
                j=j-1;
                A[j] = x;
            }
        }
        System.out.println(Arrays.toString(A));
        Date danach = new Date();
        System.out.println(danach.getMinutes()-davor.getMinutes() + danach.getSeconds()-davor.getSeconds());
    }

    public static int[] macheZahlen(int[] werte){
        for(int i =0; i< werte.length; i++){
            werte[i] = (int) (Math.random()*15);
        }
        return werte;
    }
    public void einfuege(){

    }


}
