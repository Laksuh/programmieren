package de.dhbwka.java.exercise.Semester_1.Input_Output;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.stream.Stream;

public class lesen_schreiben {

    public static void main(String[] args) {

        try(Writer fWriter = new FileWriter("C:/users/Millo/Desktop/einsDatei")){
            fWriter.write("Die erste Zeile in diese Dokument\r\n");
            fWriter.write("Die zweite Zeile AMK\n");
        } catch(IOException ex){
            ex.printStackTrace();
        }
        ArrayList<String> lines = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader("C:/users/Millo/Desktop/einsDatei")) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
            System.out.println(lines);
            System.out.println(lines.get(1));
        } catch(IOException ex){
            ex.printStackTrace();
        }

    }

}
