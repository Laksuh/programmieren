package de.dhbwka.java.exercise.Semester_2.theoretische;

import java.util.Arrays;

public class Quicksort {

    public static void main(String arg[]){
        int[] z = new int[10];
        erzeugeZahlen(z);
        System.out.println(Arrays.toString(z));

        int pivot = z[0];
        int[] kl = kleiner(pivot, z);
        int[] gl = groesser(pivot, z);
        int pk = kl[0];
        kleiner(pk, kl);
        int pg = gl[0];
        groesser(pg, gl);
    }

    public static int[] erzeugeZahlen(int[] zahlen){
        int i=0;
        while(i<=9){
            zahlen[i] = (int)(Math.random()*10+1);
            ++i;
        }
        return zahlen;
    }
    public static int[] kleiner(int pivot, int[] z){
       int[] k = new int[10];
       int j=0;
        for(int i=1;i<z.length;i++){
            if(z[i]<=pivot){
                k[j]=z[i];
                j++;
            }
        }
        k[j]=pivot;
        j++;
        System.out.println(Arrays.toString(k));
        int[] kf = new int[j];
        for(int i=0;i<j;i++){
            kf[i]=k[i];
        }
        System.out.println(Arrays.toString(kf));
        return kf;
    }

    public static int[] groesser(int pivot, int[] z){
        int[] g = new int[10];
        int j=0;
        for(int i=1;i<z.length;i++){
            if(z[i]>pivot){
                g[j]=z[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(g));
        int[] gf = new int[j];
        for(int i=0;i<j;i++){
            gf[i]=g[i];
        }
        System.out.println(Arrays.toString(gf));
        return gf;
    }

}
