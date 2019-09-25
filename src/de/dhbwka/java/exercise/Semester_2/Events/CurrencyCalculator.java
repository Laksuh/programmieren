package de.dhbwka.java.exercise.Semester_2.Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculator {

    public static void main(String[] args){

        JFrame frame = new JFrame("CurrencyCalculator ");
        frame.setSize(400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout(5,5));
        JTextField jtf = new JTextField();
        JButton jbtnETD = new JButton("Euro > Dollar");
        JButton jbtnDTE = new JButton("Dollar > Euro");
        JButton jbtnCancel = new JButton("Cancel");

        JPanel bot = new JPanel();
        bot.setLayout(new FlowLayout());

        frame.add(jtf, BorderLayout.NORTH);
        bot.add(jbtnDTE);
        bot.add(jbtnETD);
        bot.add(jbtnCancel);
        frame.add(bot);

        jbtnETD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double zahl = Double.parseDouble(jtf.getText());
                zahl = zahl * 1.14;
                jtf.setText(Double.toString(zahl));
                System.out.println("OK");

            }
        });
        jbtnDTE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double zahl = Double.parseDouble(jtf.getText());
                zahl = zahl / 1.14;
                jtf.setText(zahl + "");
                System.out.println("OK");
            }
        });

        jbtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

}