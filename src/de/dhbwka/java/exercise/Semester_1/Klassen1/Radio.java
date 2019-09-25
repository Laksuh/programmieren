package de.dhbwka.java.exercise.Semester_1.Klassen1;

public class Radio {

    //Attribute
    boolean on;
    int volume;
    double frequency;

    //Konstruktoren
    public Radio() {

    }

    public Radio(boolean on, int volume, double frequency) {
        this.on = on;
        this.volume = volume;
        this.setFrequency(frequency);
    }

    //Methoden
    void incVolume(){
        if(on==true){
            if(volume!=10) {
                volume += 1;
            }
        }
    }

    void decVolume(){
        if(on==true){
            if(volume!=0) {
                volume -= 1;
            }
        }
    }

    void turnOn(){
        this.on = true;
    }

    void turnOff(){
        this.on = false;
    }

    void setFrequency(double frequency){
       if(frequency >= 85.0){
           if(frequency <= 110.0){
               this.frequency = frequency;
           } else{
               this.frequency = 99.9;
           }
       }
    }

    @Override
    public String toString() {
        return "Radio{" +
                "on=" + on +
                ", volume=" + volume +
                ", frequency=" + frequency +
                '}';
    }

    public static void main(String args[]){
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume(); radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }

}
