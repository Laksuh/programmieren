package de.dhbwka.java.exercise.Semester_1.Arrays2;

public class Pascal {

    public static void main(String[] args){

        int[][] pd = new int[5][];

        for (int i = 0; i < pd.length; i++) {

            pd[i] = new int[i + 1];
            pd[i][0] = 1;

            for (int j = 1; j < i; j++) {

                pd[i][j] = pd[i-1][j-1] + pd[i-1][j];

            }

            pd[i][i]=1;

        }

        for (int i = 0; i < pd.length; i++) {

            for (int j = 0; j < pd[i].length; j++) {

                System.out.print(pd[i][j] + " ");

            }

            System.out.println();

        }
    }
}
