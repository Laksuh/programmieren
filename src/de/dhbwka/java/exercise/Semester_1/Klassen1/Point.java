package de.dhbwka.java.exercise.Semester_1.Klassen1;

public class Point {

    //Attribute
    private double x = 5;
    private double y = 4;

    //Konstruktoren
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(){

    }

    //Methoden
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistance(Point A){
        double distance = Math.sqrt((Math.pow((A.x-x),2)+ Math.pow((A.y-y),2)));
        return distance;
    }

    public double getDistanceToOrigin(){
        return getDistance(new Point(0,0));
    }

    public Point mirrorOrigin(){
        Point B = new Point(-x,-y);
        return B;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String args[]){
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.getDistance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.getDistance(pointB));
        System.out.println("A Abstand zu Ursprung: " + pointA.getDistanceToOrigin());
        System.out.println("B Abstand zu Ursprung: " + pointB.getDistanceToOrigin());

    }
}
