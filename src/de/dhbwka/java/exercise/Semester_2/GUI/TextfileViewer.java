package de.dhbwka.java.exercise.Semester_2.GUI;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextfileViewer {

    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser();

        fc.setFileFilter(new FileFilter() {
            @Override public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            } @Override public String getDescription() {
                return "Text Files"; } });
        int state = fc.showOpenDialog(null);

        if (state == JFileChooser.APPROVE_OPTION){
            System.out.println(fc.getSelectedFile().getAbsolutePath());
            ArrayList<String> lines = new ArrayList<>();
            try ( BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile().getAbsolutePath())) ) {
                while (br.ready()) {
                    String line = br.readLine();
                    lines.add(line);
                }
                System.out.println(lines);
                System.out.println(lines.get(1));
            } catch(IOException ex){
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("gg");
            frame.setSize(1000, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea jta = new JTextArea(10,10);
            jta.setText(lines.toString());
            jta.setWrapStyleWord(true);
            jta.setLineWrap(true);
            frame.setVisible(true);
            //frame.add(jta);
            frame.add(new JScrollPane(jta));

        } else { System.out.println("No selection");
        }
    }



}
