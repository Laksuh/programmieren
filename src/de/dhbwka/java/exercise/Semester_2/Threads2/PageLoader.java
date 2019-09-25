package de.dhbwka.java.exercise.Semester_2.Threads2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageLoader implements Runnable {

    static boolean pageloaded =false;
    String url;

    public PageLoader(String url){
        this.url = url;
        System.out.println("Ahoi");
    }

    @Override
    public void run(){
        System.out.println(getPageContent(url, "UTF-8"));

    }

    public boolean pageLoaded(){

        return pageloaded;
    }

    public String getPageContent(){
        return "inhalt";
    }

    public static String getPageContent( String url, String encoding ) {
        pageloaded=false;
        StringBuilder buffer = new StringBuilder();
        String line = null;
        try ( BufferedReader br = new BufferedReader(
                new InputStreamReader( new URL( url ).openStream(), encoding ) ) ) {
            while ( (line = br.readLine() ) != null ) {
                buffer.append( line ).append( System.lineSeparator() );
            }
        } catch ( IOException ex ) { }
        pageloaded=true;
        return buffer.toString();
    }

}
