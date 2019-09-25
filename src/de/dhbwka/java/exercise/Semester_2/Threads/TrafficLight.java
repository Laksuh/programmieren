package de.dhbwka.java.exercise.Semester_2.Threads;

import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JComponent implements Runnable {

    static LightPhase actualLightPhase;

    public static void main(String args[]){

        LightPhase gelb = new LightPhase("rot", false, true, false, 2000);
        LightPhase gruen = new LightPhase("rot", false, false, true, 3000, gelb );
        LightPhase rotgelb = new LightPhase("rot", true, true, false, 1000, gruen);
        LightPhase rot = new LightPhase("rot", true, false, false, 3000, rotgelb );
        gelb.setNext(rot);

        actualLightPhase = rot;

        TrafficLight tl = new TrafficLight();


        JFrame f = new JFrame("TrafficLight");
        f.add(tl);
        f.setSize(109,435);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        new Thread(tl).start();
    }

    @Override
    public void run(){

        while(1==1){
            try {
                Thread.sleep(actualLightPhase.getDuration());
            } catch(InterruptedException e){
                System.out.println(e);
            }
            actualLightPhase = actualLightPhase.getNext();
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(5,5,134,380);

        g.setColor(Color.gray);
        g.fillOval(22,20, 100, 100);
        if(actualLightPhase.isRed()) {
            g.setColor(Color.red);
            g.fillOval(27, 25, 90, 90);
        }
        g.setColor(Color.gray);
        g.fillOval(22,140, 100, 100);
        if(actualLightPhase.isYellow()) {
            g.setColor(Color.yellow);
            g.fillOval(27, 145, 90, 90);
        }
        g.setColor(Color.gray);
        g.fillOval(22,260, 100, 100);
        if(actualLightPhase.isGreen()) {
            g.setColor(Color.green);
            g.fillOval(27, 265, 90, 90);
        }
    }
}
