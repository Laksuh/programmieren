package de.dhbwka.java.exercise.Semester_1.Klassen2;

public class Polynomial {

    //Attribute
    double a;
    double b;
    double c;

    //Konstruktor

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //Andere Methoden
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return  a + "x^2 + " +
                b + "x + " +
                c ;
    }

    public double berechneFunktionswert(double x){
        double funktionswert = a*a*x + b*x +c;
        return funktionswert;
    }

    public Polynomial addierePolynome(Polynomial zwei){
        double addiertesA = a + zwei.a;
        double addiertesB = b + zwei.b;
        double addiertesC = c + zwei.c;
        return new Polynomial(addiertesA, addiertesB, addiertesC);
    }

    public Polynomial subtrahierePolynome(Polynomial zwei){
        double subA = a - zwei.a;
        double subB = b - zwei.b;
        double subC = c - zwei.c;
        return new Polynomial(subA, subB, subC);
    }

    public Polynomial skalarmult(double s){
        double sA = s*a;
        double sB = s*b;
        double sC = s*c;
        return new Polynomial(sA,sB,sC);
    }

    public double nullstellen(int x){
        double nullstelle[] = new double[3];
        nullstelle[0] = -(b/2) + Math.sqrt(Math.pow((b/2),2)-c);
        nullstelle[1] = -(b/2) - Math.sqrt(Math.pow((b/2),2)-c);
        return nullstelle[x];
    }

    public static void main(String args[]){
        Polynomial p1 = new Polynomial(2,2,1);
        Polynomial p2 = new Polynomial(3,4,2);
        System.out.println("f(x)= "+p1);
        System.out.println("g(x)= "+p2);
        System.out.println("f(x) + g(x): " +p1.addierePolynome(p2));
        System.out.println("g(x) - f(x): " +p2.subtrahierePolynome(p1));
        System.out.println("2,5* f(x): " +p1.skalarmult(2.5));
        System.out.println("Nullstellen g(x): " +p2.nullstellen(0) +" und "+ p2.nullstellen(1));
    }

}
