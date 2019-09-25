package de.dhbwka.java.exercise.Semester_2.GUI;

import javax.swing.*;

public class EditorSimple {

    public static void main(String[] args){

        JFrame frame = new JFrame("EditorSimple");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000,1000);
        JMenuBar jmb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu stuff = new JMenu("Stuff");

        JMenuItem stuffItem0 = new JMenuItem("sum stuff");
        JMenuItem stuffItem1 = new JMenuItem("another stuff");

        stuff.add(stuffItem0);
        stuff.add(stuffItem1);

        file.add(new JMenuItem("Save    STRG+S"));
        file.add(new JMenuItem("Save as STRG+SHIFT+S"));
        file.add(new JMenuItem("Open    STRG+O"));
        file.add(stuff);

        edit.add(new JMenuItem("Coupé   STRG+C"));
        edit.add(new JMenuItem("Pasta   STRG+V"));
        edit.add(new JMenuItem("Search  STRG+F"));


        jmb.add(edit);
        jmb.add(file);

        frame.setJMenuBar(jmb);
        frame.setVisible(true);

    }

}
