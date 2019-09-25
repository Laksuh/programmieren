package de.dhbwka.java.exercise.Semester_2.Aufzählungstypen;

public class PlayingCard implements Comparable<PlayingCard> {

    //Attribute
    public CardValue cardValue;
    public Suit suit;

    //Konstruktor
    public PlayingCard(int suit, int cardValue){
        this.suit = Suit.values()[suit];
        this.cardValue = CardValue.values()[cardValue];
    }

    //Enum für Kartenfarbe
    public enum Suit{

        Karo(0),
        Herz(1),
        Pik(2),
        Kreuz(3);

        int wert;

        Suit(int wert){
            this.wert =wert;
        }

    }

    //Enum für Kartenwert
    public enum CardValue {

        Sieben(0),
        Acht(1),
        Neun(2),
        Bube(3),
        Dame(4),
        Koenig(5),
        Zehn(6),
        Ass(7);

        int wert;

        CardValue(int wert){
            this.wert=wert;
        }

    }

    //Ausgabeformat
    @Override
    public String toString() {
        return "\nKarte: " +suit +" "+cardValue;
    }

    //Vergleichsmethode, wie vergleicht man den Kartenwert?
    public int compareTo(PlayingCard c){
        int suitDifferenz = suit.wert - c.suit.wert; //Farbe vergleichen
        int valueDifferenz =0;
        if(suitDifferenz==0){   //ist Farbe gleich, Kartenwert vergleichen
            valueDifferenz = cardValue.wert - c.cardValue.wert;
        }
        return valueDifferenz+ suitDifferenz;
    }
}
