package de.dhbwka.java.exercise.Semester_2.Threads2;

import java.util.LinkedList;

public class MyBuffer {

    int mAXSIZE = 3;
    LinkedList<Integer> iwas = new LinkedList<>();

    public static void main(String[] args){

        MyBuffer b = new MyBuffer();
        ProducerThread pt = new ProducerThread(b);
        ConsumerThread ct = new ConsumerThread(b);

        new Thread(pt).start();
        new Thread(ct).start();

    }

}
