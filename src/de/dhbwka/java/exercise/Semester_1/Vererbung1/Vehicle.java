package de.dhbwka.java.exercise.Semester_1.Vererbung1;

public class Vehicle {

    //Attribute
    int wheels = 0;
    double vmax = 0;
    double posX = 0;
    double vatm = 0;


    //Methoden
    //Konstruktoren
    public Vehicle(){

    }

    public Vehicle(int wheels, double vmax, double posX, double vatm) {
        this.wheels = wheels;
        this.vmax = vmax;
        this.posX = posX;
        this.vatm = vatm;
    }

    public Vehicle(int wheels, double vmax) {
        this.wheels = wheels;
        this.vmax = vmax;
    }
    public Vehicle(double v) {
        this.vatm = v;
    }

    //Weitere Methoden
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getVmax() {
        return vmax;
    }

    public void setVmax(double vmax) {
        this.vmax = vmax;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setSpeed(double speed){
        if(speed>this.vmax){
            this.vatm = vmax;
        } else {
            this.vatm = speed;
        }
    }

    public double getVatm() {
        return vatm;
    }

    public void setVatm(double vatm) {
        this.vatm = vatm;
    }

    public void drive(double minutes){
        if(this.vatm>vmax) {
            vatm = vmax;
        }
            posX = posX + (vatm*minutes)/60;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                " wheels=" + wheels +
                ", vmax=" + vmax +
                ", posX=" + posX +
                ", vatm=" + vatm +
                '}';
    }
}
