package de.dhbwka.java.exercise.Semester_1;


    public class Primfaktorzerlegung {
        public static void main( String[] args ) {
            long nr = 2222222222222222222L;
            int counter = 2;

            while ( counter <= ( int ) Math.sqrt( nr ) && nr > 1 ) {
                if ( nr % counter == 0 ) {
                    nr /= counter;
                    System.out.printf( "%s %s", counter, nr == 1 ? "" : "* " );
                }
                else {
                    counter++;
                }
            }
            if ( nr != 1 ) {
                System.out.println( nr );
            }
        }
    }

    //C paar Sekunden?
    //D Bis es länger als 1s dauert, mit einem i5 8300H, braucht man einen größeren Datentyp als Long
    // Länger als 1h ist mir unvorstellbar
    //E sehr gute Frage


