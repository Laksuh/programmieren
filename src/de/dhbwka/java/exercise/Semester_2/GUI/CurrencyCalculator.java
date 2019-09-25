package de.dhbwka.java.exercise.Semester_2.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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
        bot.add(new JButton("Euro > Dollar"));
        bot.add(new JButton("Dollar > Euro"));
        bot.add(jbtnCancel);

        frame.add(bot);

        frame.setVisible(true);
    }

}
