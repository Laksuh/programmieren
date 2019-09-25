package de.dhbwka.java.exercise.Semester_2.GUI;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame {

    JFrame frame;
    String[] models = new String[5];


    public static void main(String args[]){
        new ComponentFrame();
    }

    public ComponentFrame(){
        models[0] = "A180";
        models[1] = "C63 AMG";
        models[2] = "AMG GT";
        models[3] = "C 200";
        models[4] = "SLS AMG";

        this.frame = new JFrame();
        this.frame.setSize(1000, 500);
        this.frame.setTitle("ComponentFrame Mercedes Benz AMG");
        this.frame.setLayout(new FlowLayout());

        this.frame.add(new JLabel("Suchen"));

        JPasswordField jtf = new JPasswordField();
        jtf.setColumns(20);

        this.frame.add(jtf);

        this.frame.add(new Button("Suchen"));

        this.frame.add(new JToggleButton("Toggle"));

        this.frame.add(new Checkbox("JCheckbox"));

        this.frame.add(new JComboBox(models));

        JRadioButton jrb0 = new JRadioButton("KEKSE", false);
        JRadioButton jrb1 = new JRadioButton("KEKSEESSEN", true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb0);
        bg.add(jrb1);
        this.frame.add(jrb0);
        this.frame.add(jrb1);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
}
