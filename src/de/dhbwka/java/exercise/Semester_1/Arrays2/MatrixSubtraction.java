package de.dhbwka.java.exercise.Semester_1.Arrays2;

    public class MatrixSubtraction {

        public static void main(String[] args) {


            int m1[][] = new int[4][4];
            int m2[][] = new int[4][4];

               for(int i =0; i<4; i++){

                   for(int j=0; j<4; j++){
                       m1[i][j] = (int) (Math.random() * 101);
                       System.out.printf("%4d",m1[i][j]);
                   }
                   System.out.println("");
               }

            System.out.println("");

            for(int i =0; i<4; i++){

                for(int j=0; j<4; j++){
                    m2[i][j] = (int) (Math.random() * 101);
                    System.out.printf("%4d",m2[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");

            for(int i =0; i<4; i++){

                for(int j=0; j<4; j++){
                    m2[i][j] = m2[i][j] - m1[i][j];
                    System.out.printf("%4d",m2[i][j]);
                }
                System.out.println("");
            }



        }

}
