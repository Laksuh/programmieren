package de.dhbwka.java.exercise.Semester_2.Probeklausur;

import java.util.Calendar;

public class Auktion {

    //Attribute
    Ware ware = new Ware();
    Gebot gebot = new Gebot();
    double aktuellerPreis= 0.0;
    Calendar ende = Calendar.getInstance();

    public static final double increment = 1.0;

    public Auktion(Ware ware, int dauer){
        this.ware=ware;
    }

    public boolean gebotAbgeben(Gebot g){
        boolean b=false;
        if(g.hoechstbetrag<(aktuellerPreis+increment)){
            System.out.println("gebot Abgelehnt");
            return false;
        }
        if(aktuellerPreis==0.0){
            aktuellerPreis = increment;
            //gebot.setHoechstbetrag(g.hoechstbetrag);
            gebot=g;
            return true;
        }
        if(gebot.bieter.equals(g.bieter) & g.hoechstbetrag > gebot.hoechstbetrag){
            gebot.hoechstbetrag = g.hoechstbetrag;
        }
        if(g.hoechstbetrag >= (aktuellerPreis+increment) && g.hoechstbetrag <= gebot.hoechstbetrag){
            aktuellerPreis = Math.min(g.hoechstbetrag+increment, this.gebot.hoechstbetrag);
        }
        if(g.hoechstbetrag >= (aktuellerPreis+increment) && g.hoechstbetrag > gebot.hoechstbetrag){
            aktuellerPreis = Math.min(g.hoechstbetrag, this.gebot.hoechstbetrag + increment);
            gebot=g;
            return true;
        }
        return b;
    }
}
