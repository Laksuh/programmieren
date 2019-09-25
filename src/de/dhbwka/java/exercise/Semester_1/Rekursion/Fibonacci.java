package de.dhbwka.java.exercise.Semester_1.Rekursion;

public class Fibonacci {

    public static void main(String[] args){
        int n = 50;
        int x = fibonacci(n);
        System.out.println(x);
    }

    static int fibonacci(int n){
        if(n<=0){
            return 0;
        }else if (n==1) {
            return 1;
        }else{
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }

}
