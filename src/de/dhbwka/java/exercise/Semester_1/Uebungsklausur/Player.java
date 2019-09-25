package de.dhbwka.java.exercise.Semester_1.Uebungsklausur;

public class Player {

    private String name;
    private int countDartsThrown;
    private Visit[] visits;
    private int verbleibendePunkte;
    private int nextFreeVisit = 0;

    public Player() {
    }
    public Player(String name) {
        this.name = name;
        this.countDartsThrown = 0;
        this.visits = new Visit[10];
        this.verbleibendePunkte = 501;
    }

    public int getRemainingPoints(){
        int summe =0;
        for(int i=0; i<visits.length; i++){
            summe = summe + visits[i].getValue();
        }
        return verbleibendePunkte;
    }

    public boolean addVisit(Visit visit){
        if(getRemainingPoints() < 0){
            return false;
        }
        if(getRemainingPoints() ==1){
            return false;
        }
        if(getRemainingPoints() == 0 && !visit.getLastField().isDoublefield()){
            return false;
        }
        this.countDartsThrown += visit.getFields().length;
        visits[nextFreeVisit++] = visit;
        verbleibendePunkte -= visit.getValue();
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountDartsThrown() {
        return countDartsThrown;
    }

    public void setCountDartsThrown(int countDartsThrown) {
        this.countDartsThrown = countDartsThrown;
    }

    public Visit[] getVisits() {
        return visits;
    }

    public void setVisits(Visit[] visits) {
        this.visits = visits;
    }
}
