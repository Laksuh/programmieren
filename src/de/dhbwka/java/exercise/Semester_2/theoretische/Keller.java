package de.dhbwka.java.exercise.Semester_2.theoretische;

import java.util.ArrayList;

public class Keller {

    int pointer;
    ArrayList<Integer> alValues = new ArrayList<>();

    public static void main(String[] args){
       Keller k = new Keller();
        k.popElement();

        k.pushElement(12);
        k.pushElement(22);
        k.pushElement(32);
        k.pushElement(42);
        k.popElement();
        k.soutAl();
    }

    public Keller(){
        this.pointer =-1;
    }

    public void pushElement(int zahl){
        pointer++;
        this.alValues.add(zahl);
        System.out.println(alValues.get(pointer) + " wird gepusht");

    }

    public void popElement(){
        if(pointer != -1) {
            System.out.println(alValues.get(pointer) + " wird gepoppt");
            alValues.remove(pointer);
            pointer--;
        } else{
            System.out.println("fuu");
        }
    }

    public void soutAl(){
        System.out.println(alValues.toString());
    }

}
