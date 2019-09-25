package de.dhbwka.java.exercise.Semester_1.Rekursion;

public class Quicksort {
    public static void main(String[] args){
        int[] daten = new int[10];

        for(int i=0; i<daten.length; i++){
            daten[i] = (int)(Math.random()*10 +1);
            System.out.println(daten[i]);
        }

        quicksort(0, daten.length-1, daten);

        for(int i=0; i<daten.length; i++){
            System.out.println("------------------");
            System.out.println(daten[i]);
        }
    }

    static void quicksort(int links,int rechts, int[] daten) {
        if(links<rechts){
            int teiler = teile(links, rechts, daten);
            quicksort(links, teiler-1, daten);
            quicksort(teiler +1, rechts, daten);
        }
    }

    static int teile(int links, int rechts, int[] daten){
        int i = links;
        int j = rechts-1;
        int pivot = daten[rechts];
        while(i<j){
            while(daten[i]<=pivot & i<rechts){
                i++;
            }

            while(daten[j]>=pivot & j>links){
                j++;
            }
            if(i<j){
                int hv = daten[i];
                daten[i] = daten[j];
                daten[j] = hv;
            }
        }
        if(daten[i]>pivot){
            int hv = daten[i];
            daten[i] =daten[rechts];
            daten[rechts]= hv;
        }
        return i;
    }

}
