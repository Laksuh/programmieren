package de.dhbwka.java.exercise.Semester_2.Aufzählungstypen;

import java.util.*;

public class Cardgame {

    //Attribute
    ArrayList<PlayingCard> deck = new ArrayList<PlayingCard>();
    int kartenanzahl= 0;
    PlayingCard h7 = new PlayingCard(1,0);

    //Konstruktor
    public Cardgame(){
        //Karten erzeugen
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                if(i==1 && j==0){
                    deck.add(h7); //Herz 7 seperat erzeugen, zum vergleichen
                } else {
                    deck.add(new PlayingCard(i, j));
                }
                kartenanzahl++;
            }
        }
        all();
    }

    //Deck mischen
    public void shuffle(){
        Collections.shuffle(deck);
    }
    //Deck sortieren
    public void sort(){
        Collections.sort(deck);
    }

    //Oberste Karte ziehen
   public PlayingCard get(){
        PlayingCard pc = deck.get(kartenanzahl-1);
        deck.remove(kartenanzahl-1);
        kartenanzahl--;
        return pc;
    }

    //Deck ausgeben
    public List<PlayingCard> all(){
        return deck;
    }

}
