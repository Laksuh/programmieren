package de.dhbwka.java.exercise.Semester_2.Threads2;

public class ProducerThread implements Runnable {

    MyBuffer b;

    public ProducerThread(MyBuffer b){
        this.b=b;
    }

    @Override
    public void run(){

        while(true){
            put();
            try{
                int zz = (int) (Math.random()*1000);
                Thread.sleep(zz);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void put(){
        if(b.iwas.size()>=b.mAXSIZE){
            System.out.println("DAS IST VOLL OMFG");
        }else {
            int zz = (int) (Math.random()*10);
            b.iwas.push(zz);
            System.out.println("PUSH: " + zz);
        }
    }

}
