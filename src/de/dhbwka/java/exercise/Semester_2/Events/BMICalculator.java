package de.dhbwka.java.exercise.Semester_2.Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {

    public static void main(String[] args){

        JFrame frame = new JFrame("BMICalculator ");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(6,2));

        JTextField jtfWeight = new JTextField(8);
        JTextField jtfHeight = new JTextField(8);
        JTextField jtfBMI = new JTextField(16);
        JTextField jtfDescription = new JTextField(32);
        JLabel jlWeight = new JLabel("Weight");
        JLabel jlHeight = new JLabel("Height");
        JRadioButton jrbMale = new JRadioButton("Male");
        JRadioButton jrbFemale = new JRadioButton("Female");
        JButton jbtnCalculate = new JButton("Calculate");

        frame.add(jlHeight);
        frame.add(jtfHeight);
        frame.add(jlWeight);
        frame.add(jtfWeight);
        frame.add(jrbMale);
        frame.add(jrbFemale);
        frame.add(jbtnCalculate);
        frame.add(new JPanel());
        frame.add(jtfBMI);
        frame.add(jtfDescription);

        jbtnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gewicht = Double.parseDouble(jtfWeight.getText());
                double groesse = Double.parseDouble(jtfHeight.getText());
                double bmi = gewicht/(Math.pow(groesse, 2));
                jtfBMI.setText(Double.toString(bmi));

            }
        });


        frame.setVisible(true);

    }


}
