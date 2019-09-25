package de.dhbwka.java.exercise.Semester_2.Probeklausur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class BieterTerminal{

    Bieter bieter;
    Auktionshaus ah;
    Label uhrzeit = new Label(Calendar.getInstance().getTime().toString());

    new Thread(new Runnable(){
        public void run(){
            while(true) {
                try {
                    Thread.sleep(1000);
                    this.uhrzeit.setText(Calendar.getInstance().getTime().toString());

                } catch(Exception e) {
                    System.out.println("error");
                }
                }
            }
        }
    }).start();

    BieterTerminal(Bieter bieter, Auktionshaus ah){
        this.bieter=bieter;
        this.ah=ah;
        ah.register(this);

        JFrame frame = new JFrame(bieter.getFullName());
        frame.setSize(750,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,1));

        JPanel time = new JPanel();
        time.add(new JLabel(Calendar.getInstance().getTime().toString()));
        frame.add(time);

        for(Auktion auktion : ah.getAuktionen()){

        }

        for(int i=0; i<ah.getAuktionen().size();i++) {
            JPanel pnlWare = new JPanel();
            pnlWare.setLayout(new GridLayout(1,5,10,10));
            pnlWare.add(new Label(ah.getAuktionen().get(i).ware.titel));
            double preis = ah.getAuktionen().get(i).aktuellerPreis;
            pnlWare.add(new Label(Double.toString(preis)));
            pnlWare.add(new Label(ah.getAuktionen().get(i).gebot.bieter.getFullName()));
            pnlWare.add(new Label(ah.getAuktionen().get(i).ende.getTime().toString()));
            JButton jbtnGebot = new JButton("Gebot");
            pnlWare.add(jbtnGebot);

            final Auktion ding = ah.getAuktionen().get(i);

            jbtnGebot.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double wert = Double.parseDouble(JOptionPane.showInputDialog(null,"Neues gebot eingeben (Mindestgebot: 2 Euro)"));

                    ding.gebotAbgeben(new Gebot(wert,new Bieter("a", "a")));
                }
            });
            frame.add(pnlWare);
        }
        frame.setVisible(true);


    }

    public void update(){

    }

}
