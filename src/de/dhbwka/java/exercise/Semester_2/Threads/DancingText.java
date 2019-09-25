package de.dhbwka.java.exercise.Semester_2.Threads;

import javax.swing.*;
import java.awt.*;

public class DancingText extends JComponent implements Runnable{

    Graphics g;


    public static void main(String args[]){
        DancingText dt = new DancingText();
        new Thread(dt).start();
    }

    public void run(){
        System.out.println("Thread started");
        JFrame f = new JFrame("Dancing Text");
        f.add(this);
        f.setSize(500,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        while(1==1){
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            repaint();
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setFont(new Font("HELVETICA", Font.BOLD, 40));
        g.setColor(Color.BLUE);
        int x = 0;
        int[] y = new int[11];
        for(int i=0; i<11; i++){
            y[i] =  (int)(Math.random()*50) +75;
        }
        g.drawString("D", x+=30, y[0]);
        g.drawString("A", x+=30, y[1]);
        g.drawString("N", x+=30, y[2]);
        g.drawString("C", x+=30, y[3]);
        g.drawString("I", x+=35, y[4]);
        g.drawString("N", x+=20, y[5]);
        g.drawString("G", x+=30, y[6]);
        g.drawString("T", x+=60, y[7]);
        g.drawString("E", x+=30, y[8]);
        g.drawString("X", x+=30, y[9]);
        g.drawString("T", x+=30, y[10]);
    }

}
