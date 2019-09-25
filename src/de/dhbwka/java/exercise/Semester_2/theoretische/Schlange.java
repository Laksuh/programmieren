package de.dhbwka.java.exercise.Semester_2.theoretische;

import java.util.Arrays;

public class Schlange {
    int pPush;
    int pPop;
    int schla[] = new int[5];
    public static void main(String[] args){
        Schlange s = new Schlange();
        s.push(10);
        s.push(2);
        s.push(3);

        s.pop();
        s.pop();
        s.pop();
        s.push(5);

        System.out.println(Arrays.toString(s.schla));
        System.out.println(s.pPop);
    }

    public Schlange(){
        this.pPush = 0;
        this.pPop = 0;
    }


    public void push(int zahl){
        if (this.pPush - this.pPop < this.schla.length) {
            int tmp = this.pPush;
            tmp = (tmp) % this.schla.length;
            this.schla[tmp] = zahl;
            this.pPush++;
            System.out.println(this.schla[tmp] + " rein schreiben");
        }else{
            System.out.println("geht nicht");
        }
    }

    public  void pop(){
        if (this.pPop != this.pPush){
            int tmp = this.pPop;
            tmp = (tmp + 1) % this.schla.length;
            System.out.println(this.schla[this.pPop] + " ausgeben");
            this.pPop++;
        }

    }



}
