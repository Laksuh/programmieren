package de.dhbwka.java.exercise.Probeklausuren;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryGame{

    int zeilen;
    int spalten;
    List<Player> spieler = new ArrayList<>();
    List<MemoryImages.MemoryImage> bilder = new ArrayList<>();
    Player actualplayer;

    public MemoryGame(List<Player> spieler, List<MemoryImages.MemoryImage> bilder, int zeilen, int spalten) {
        this.zeilen = zeilen;
        this.spalten = spalten;
        System.out.println(zeilen*spalten);
        if(spieler.size()>=2) {
            this.spieler = spieler;
        } else {
            try {
                throw new MemoryException("At least two players required");
            } catch (MemoryException e) {
                e.printStackTrace();
            }
        }
        Collections.shuffle(bilder);
        for (int i=0; i<zeilen*spalten/2;i++){
            this.bilder.add(bilder.get(i));
            this.bilder.add(bilder.get(i));
        }

        Collections.shuffle(this.bilder);
        actualplayer = spieler.get(0);
    }

    public Player getCurrentPlayer(){
        return actualplayer;
    }

    public boolean isBlankRequired(){
        if (zeilen*spalten %2 == 0){
            return false;
        }

        return true;

    }

    public void nextPlayer(){
        System.out.println(actualplayer);
        this.actualplayer.setPlayerStatus(Player.PlayerStatus.WAITING);
        this.actualplayer = this.spieler.get((this.spieler.indexOf(this.actualplayer) + 1)%this.spieler.size());
        this.actualplayer.setPlayerStatus(Player.PlayerStatus.ACTIVE);
    }

    /*if (actualplayer == spieler.get(spieler.size()-1)){
        actualplayer = spieler.get(0);
    }else {
        actualplayer = spieler.get(spieler.indexOf(actualplayer)+1);
    }*/
    public int getKartenanzahlDruch2(){
        return zeilen*spalten/2;
    }

}
