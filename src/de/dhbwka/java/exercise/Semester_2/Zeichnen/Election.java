package de.dhbwka.java.exercise.Semester_2.Zeichnen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Election extends JComponent {

    //Attribute
    static int width = 1500;
    static int height = 1000;
    static ArrayList<Party> parteien = new ArrayList<>();

    static Party cdu = new Party("CDU",28.9, Color.BLACK);
    static Party spd = new Party("SPD", 15.8, Color.RED);
    static Party afd = new Party("AFD", 11.0, Color.BLUE);
    static Party fdp = new Party("FDP", 5.4, Color.YELLOW);
    static Party linke = new Party("Linke", 5.5, Color.MAGENTA);
    static Party gruene = new Party ("Grüne", 20.5, Color.GREEN);
    static Party diePartei = new Party("Die PARTEI", 2.4, Color.PINK);
    static Party sonstige = new Party("Sonstige", 16.5, Color.GRAY);

    public static void main(String args[]){
        parteien.add(cdu);
        parteien.add(spd);
        parteien.add(afd);
        parteien.add(fdp);
        parteien.add(linke);
        parteien.add(gruene);
        parteien.add(diePartei);
        parteien.add(sonstige);

        initFrame(width, height);

    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth()+25,this.getHeight());
        int ya= 0;
        for(int j=0;j<10;j++){
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(5,this.getHeight()/10 *(10-j) -100,this.getWidth()-5,this.getHeight()/10 *(10-j) -100);
            g.drawString(ya+"",5,this.getHeight()/10 *(10-j)-1 -100);
            ya+=5;
        }

        int i=0;
        for(Party p : parteien) {
            double d = p.getPercentage();
            int x = (int) d;
            g.setColor(p.getColor());
            g.fillRect(this.getWidth()/8*i+25, this.getHeight()-100-(int)(d*20), (this.getWidth() / 9), (int)(d*20));
            g.setColor(Color.black);
            g.setFont(new Font("Helvetica", Font.BOLD, 16));
            g.drawString(p.getName()+" ("+p.getPercentage()+"%)",(this.getWidth()/8*i+35), this.getHeight()-70);

            i++;
        }

    }


    //Konstruktor
    public Election(){

    }

    public static void initFrame(int w, int h){
        JFrame frame = new JFrame("Europawahl 2019");
        frame.setSize(w+25,h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Election());


        frame.setVisible(true);
    }

}
