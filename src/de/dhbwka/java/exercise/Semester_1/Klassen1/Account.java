package de.dhbwka.java.exercise.Semester_1.Klassen1;

public class Account {

    //Attribute
    int kontonummer;
    String kontoinhaber;
    double kontostand;
    double limit;

    //Konstruktor
    public Account(int kontonummer, String kontoinhaber, double kontostand, double limit) {
        this.kontonummer = kontonummer;
        this.kontoinhaber = kontoinhaber;
        this.kontostand = kontostand;
        this.limit = limit;
    }

    //Andere Methoden
    public static void main(String args[]){
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.processDeposit(200);
        System.out.println(account);
        account.processPayment(400);
        System.out.println(account);
        account.processPayment(2000);
        System.out.println(account);
    }

    public double getKontostand(){
        return this.kontostand;
    }

    public void processDeposit(double betrag){
        if(kontostand+betrag<=limit) {
            this.kontostand = kontostand + Math.abs(betrag);
        } else{
            System.err.println("Nöö, mach ich nicht!");
        }
    }

    public void processPayment(double betrag){
        if(kontostand-betrag >= 0) {
            this.kontostand = kontostand - Math.abs(betrag);
        } else {
            System.err.println("Nöö, mach ich nicht!");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "kontonummer=" + kontonummer +
                ", kontoinhaber='" + kontoinhaber + '\'' +
                ", kontostand=" + kontostand +
                ", limit=" + limit +
                '}';
    }
}
