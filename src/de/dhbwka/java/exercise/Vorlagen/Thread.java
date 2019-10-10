package de.dhbwka.java.exercise.Vorlagen;

public class Thread {

    int seconds=0;

    public static void main(String[] args){
        new Thread();
    }

    public Thread(){
        BeispielTrread();
    }

    public void BeispielTrread() {
        java.lang.Thread countTimeThread = new java.lang.Thread() {
            @Override
            public void run() {
            while (true) {
                try {
                    java.lang.Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //SACHEN MACHEN
                System.out.println(seconds++);

            }
            }

        };
        countTimeThread.start();
    }

}


