package de.dhbwka.java.exercise.Probeklausuren.SoederMemory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MemoryGameTerm  implements Runnable{

    int runden=0;
    int gedrueckt=0;
    int karte1;
    int karte2;
    int counter;
    ArrayList<JLabel> labels = new ArrayList<>();
    JToggleButton jtb1;
    JToggleButton jtb2;
    MemoryGame game;
    JFrame frame;

    public MemoryGameTerm(MemoryGame game){

        this.game = game;
        frame = new JFrame("Soeder Memory");
        frame.setSize(1550,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(game.spieler.size(),1));
        for (int i=0; i<game.spieler.size(); i++) {
            JLabel lbl = new JLabel(game.spieler.get(i)+"");
            top.add(lbl);
            labels.add(lbl);
        }
        frame.add(top,BorderLayout.NORTH);

        JPanel gaame = new JPanel();
        gaame.setLayout(new GridLayout(game.spalten, game.zeilen+1));
        labels.get(game.spieler.indexOf(game.actualplayer)).setForeground(Player.PlayerStatus.ACTIVE.color);
        for (int i=0; i<game.bilder.size(); i++) {

            JToggleButton jtb = new JToggleButton(MemoryImages.getBackside());
            int finalI = i;

            jtb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jtb.setIcon(game.bilder.get(finalI).getImage());
                    gedrueckt(finalI, jtb);
                }
            });

            /* jtb.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.SELECTED){
                        jtb.setIcon(game.bilder.get(finalI).getImage());
                        gedrueckt(finalI, jtb);
                    } else {
                        jtb.setIcon(MemoryImages.getBackside());
                    }
                }
            });*/
            gaame.add(jtb);
        }

        if (game.isBlankRequired()){
            JToggleButton jtb = new JToggleButton(MemoryImages.getBackside());
            jtb.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if(jtb.isSelected()){
                        jtb.setIcon(MemoryImages.getBlank());
                        gedrueckt(game.bilder.size()-1, jtb);
                    } else {
                        jtb.setIcon(MemoryImages.getBackside());
                    }
                }
            });
            gaame.add(jtb);
        }

        frame.add(gaame);










        frame.setVisible(true);
    }

    public void gedrueckt(int i, JToggleButton jtb){
        System.out.println(gedrueckt);
        if(this.gedrueckt == 1){
            runden++;
            this.jtb2 = jtb;
            this.karte2 = i;
            gedrueckt=0;
            pruefeKarten();
        } else{
            this.jtb1 = jtb;
            this.karte1 = i;
            gedrueckt++;
        }
    }

    public void pruefeKarten(){
        if (game.bilder.get(karte1) == game.bilder.get(karte2)){
            game.actualplayer.addPunkt();
            labels.get(game.spieler.indexOf(game.actualplayer)).setText(game.actualplayer.toString());
            jtb1.setEnabled(false);
            jtb2.setEnabled(false);
            counter++;
            System.out.println(game.getKartenanzahlDruch2()+ "AAAAANZAHL KARTEN<-- COUNTER-->" +counter );
            if(game.getKartenanzahlDruch2() == counter){
                System.out.println("yAAAAAAY FINISH");
                for (int i=0; i<game.spieler.size(); i++) {
                    labels.get(i).setForeground(Player.PlayerStatus.FINISHED.color);
                }
                finished();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Falsche Karten ", "Noin", JOptionPane.ERROR_MESSAGE);
            jtb1.setIcon(MemoryImages.getBackside());
            jtb2.setIcon(MemoryImages.getBackside());
            labels.get(game.spieler.indexOf(game.actualplayer)).setForeground(Player.PlayerStatus.WAITING.color);
            game.nextPlayer();
            labels.get(game.spieler.indexOf(game.actualplayer)).setForeground(Player.PlayerStatus.ACTIVE.color);
        }
    }

    public void finished(){
        ArrayList<String> lines = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader("C:/users/Millo/Desktop/memory.txt")) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line +"\n");
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }

        String s = "Last games: \n"+ Arrays.toString(lines.toArray());
        String guteLoesung ="";

        try(Writer fWriter = new FileWriter("C:/users/Millo/Desktop/memory.txt", true)){
           guteLoesung += "Game ends after " +runden +" rounds, scores: ";
            for (int i=0; i<game.spieler.size(); i++){
                guteLoesung += game.spieler.get(i).toString() +", " ;
            }
            guteLoesung += "\n";
            fWriter.write(guteLoesung);
        } catch(IOException ex){
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(frame,guteLoesung +"\n"+ s, "Ende", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void run(){
        final long createdMillis = System.currentTimeMillis();

        while(1==1){
            long nowMillis = System.currentTimeMillis();
            int time = (int)((nowMillis - createdMillis) / 1000);
            frame.setTitle("Soeder Memory ("+ time +")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
