package de.dhbwka.java.exercise.Semester_2.Aufzählungstypen;

import javax.swing.*;

public class TestGame {

    public static void main(String[] args){
        //erzeuge Kartenspiel
        Cardgame cg = new Cardgame(); //Refferenzattribut cg
        System.out.println(cg.all());
        System.out.println("verbleibende Karten: "+cg.kartenanzahl );
        //Kartenspiel mischen
        cg.shuffle();
        System.out.println(cg.all());

        //Ziehe 10 Karten und vergliche sie mit Herz 7
        for(int i=0; i<10;i++){
            PlayingCard card = cg.get();
            if(card.compareTo(cg.h7)>0){ //positiver Wert heißt größer
                System.out.println(card +" ist größer als Herz Sieben");
            } else if (card.compareTo(cg.h7)<0) { //negativ, kleiner
                System.out.println(card +" ist kleiner als Herz Sieben");
            } else { //0 bedeutet Herz 7
                System.out.println("\nDie Karte ist Herz Sieben");
            }
        }
        //Sortiere verbleibendes Deck
        cg.sort();

        //restliches Deck +Kartenanzahl ausgeben
        //System.out.println(cg.all());
        JOptionPane.showMessageDialog(null, cg.all() +"\n\nverrbleibende Karten: " +cg.kartenanzahl , "Kartenspiel", JOptionPane.PLAIN_MESSAGE);
    }
}
