package de.dhbwka.java.exercise.Semester_2.Threads2;

public class SearchEngine {

   static String[] urls = new String[20];
   static int threadCounter = 0;

    public static void main( String[] args ) {
        urls[0] = "https://www.google.com";
        urls[1] = "https://www.zdf.de/comedy/neo-magazin-mit-jan-boehmermann";
        urls[2] = "https://9gag.com";
        urls[3] = "https://de.wikipedia.org/wiki/Wikipedia:Hauptseite";
        for (int i=0; i<urls.length; i++){
            PageLoader pl = new PageLoader(urls[i]);
            threadCounter++;
            new Thread(pl).start();
        }

    }

}
