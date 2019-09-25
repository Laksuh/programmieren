package de.dhbwka.java.exercise.Semester_1.Arrays1;

public class Eratosthenes {

    public static void main(String[] arg){

        boolean[] sieb = new boolean[120];

        for(int i =2; i<sieb.length; i++){
            sieb[i] = true;
        }

        for(int i =2; i<sieb.length; i++){
            if(sieb[i] == true){
                for(int j = 2*i; j<sieb.length; j+=i){
                    sieb[j] = false;
                }
            }
        }

        for(int i = 2; i<sieb.length; i++){
            if(sieb[i] == true) {
                System.out.println(i);
            }
        }

    }
}
