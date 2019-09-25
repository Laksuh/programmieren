package de.dhbwka.java.exercise.Semester_2.Aufzählungstypen;

import java.util.Calendar;

public class Months {

    public enum Month{
        JANUAR (31, "Hartung, Eismond"),
        FEBRUAR(28, "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
        MAERZ(31,"Lenzing, Lenzmond"),
        APRIL (30, "Launing, Ostermond"),
        MAI(31,"Winnemond, Blumenmond"),
        JUNI(30, "Brachet, Brachmond"),
        JULI(31,"Heuert, Heumond"),
        AUGUST(31,"Ernting, Erntemond, Bisemond"),
        SEPTEMBER(30,"Scheiding, Herbstmond"),
        OKTOBER(31,"Gilbhart, Gilbhard, Weinmond"),
        NOVEMBER(30, "Nebelung, Windmond, Wintermond"),
        DEZEMBER(31,"Julmond, Heilmond, Christmond, Dustermond");

        int tage;
        String alterName;

        Month(int tage, String alterName){
            this.tage = tage;
            this.alterName = alterName;
        }

    }

    public static void main(String args[]){
        System.out.println("Der Monat "+Month.values()[Calendar.getInstance().get(Calendar.MONTH)]);
        System.out.println("hat "+Month.values()[Calendar.getInstance().get(Calendar.MONTH)].tage+" Tage");
        System.out.println("und hieß früher " +Month.values()[Calendar.getInstance().get(Calendar.MONTH)].alterName);
    }
}
