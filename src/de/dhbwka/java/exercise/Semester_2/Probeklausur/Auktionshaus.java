package de.dhbwka.java.exercise.Semester_2.Probeklausur;

import java.util.ArrayList;
import java.util.List;

public class Auktionshaus {

    List<Auktion> auktionsliste = new ArrayList<>();
    List<BieterTerminal> terminals = new ArrayList<>();

    public void addAuktion(Auktion a){
        auktionsliste.add(a);
    }

    public void removeAuktion(Auktion a){
        auktionsliste.remove(a);
    }

    public List<Auktion> getAuktionen(){
        return auktionsliste;
    }

    void register(BieterTerminal bt){
        terminals.add(bt);
    }

    void unregister(BieterTerminal bt){
        terminals.remove(bt);

    }

    void updateTerminals(){
        for(BieterTerminal bt : terminals){
            bt.update();
        }
    }
}
