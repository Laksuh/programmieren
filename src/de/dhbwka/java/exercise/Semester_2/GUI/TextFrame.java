package de.dhbwka.java.exercise.Semester_2.GUI;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TextFrame {

    JFrame frame;

    public static void main(String[] args){
        new TextFrame();
    }

    public TextFrame(){
        this.frame = new JFrame();
        JTextArea jta = new JTextArea();

        try(Writer fWriter = new FileWriter("C:/users/Millo/Desktop/einsDatei")){
            fWriter.write("Die erste Zeile in diesem Dokument\r\n");
            fWriter.write("Die zweite Zeile AMK\n");
        } catch(IOException ex){
            ex.printStackTrace();
        }
        ArrayList<String> lines = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader("C:/users/Millo/Desktop/einsDatei")) ) {
            while (br.ready()) {
                String line = "\n"+br.readLine();
                lines.add(line);
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }

        jta.setText(lines.toString());

        this.frame.add(jta);
        this.frame.setSize(1000, 500);
        this.frame.setTitle("einsDatei.txt");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

}
