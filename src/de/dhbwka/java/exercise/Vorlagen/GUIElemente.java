package de.dhbwka.java.exercise.Vorlagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIElemente {

    JFrame frame = new JFrame();
    ArrayList<JRadioButton> radioButtons = new ArrayList<>();
    ArrayList<JButton> buttons = new ArrayList<>();
    ArrayList<JTextField> textFields = new ArrayList<>();
    ArrayList<JLabel> labels = new ArrayList<>();

    public GUIElemente(){
        initGUI();
    }

    public void initGUI(){
        frame.setTitle("TITEL");
        frame.setLayout(new GridLayout(4,1));
        frame.setSize(500,200);

        frame.add(radioButtons());
        frame.add(textFields());
        frame.add(labels());
        frame.add(buttons());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JPanel radioButtons(){
        JPanel panel = new JPanel();
        ButtonGroup radioGroup = new ButtonGroup();
        for (int i=0; i<4; i++){
            radioButtons.add(new JRadioButton(i+". RadioButton"));
            int finalI = i;
            radioButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("RadioDingeTun" + finalI);
                }
            });
            radioGroup.add(radioButtons.get(i));
            panel.add(radioButtons.get(i));
        }
        return panel;
    }

    public JPanel textFields(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for (int i=0; i<4; i++){
            textFields.add(new JTextField());
            System.out.println(textFields.get(i).getText());
            panel.add(textFields.get(i));
        }
        return panel;
    }

    public JPanel buttons(){
        JPanel panel = new JPanel();
        for (int i=0; i<4; i++){
            buttons.add(new JButton("Button "+i));
            int finalI = i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(textFields.get(finalI).getText());
                }
            });
            panel.add(buttons.get(i));
        }
        return panel;
    }

    public JPanel labels(){
        JPanel panel = new JPanel();
        for (int i=0; i<4; i++){
            labels.add(new JLabel());
            labels.get(i).setText(i+"");
            panel.add(labels.get(i));
        }
        return panel;
    }

    public static void main(String[] args){
        new GUIElemente();
    }
}
