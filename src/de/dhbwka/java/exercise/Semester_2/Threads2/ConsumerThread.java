package de.dhbwka.java.exercise.Semester_2.Threads2;

public class ConsumerThread implements Runnable {

    MyBuffer b;

    public ConsumerThread(MyBuffer b){
        this.b=b;
    }

    @Override
    public void run(){
        while(true){
            get();
            try{
                int zz = (int) (Math.random()*1000);
                Thread.sleep(zz);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void get(){
        if(b.iwas.isEmpty()){
            System.out.println("Hallo?! IWAS ist leer!");
        } else{
            System.out.println("GET: " +b.iwas.pop());
        }
    }
}
