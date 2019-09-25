package de.dhbwka.java.exercise.Semester_2.Datenstrukturen;

public class Book {

    int id;
    String title;
    String author;
    int year;
    String publisher;

    public Book(String title, String author, int year, String publisher, int id){
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
        this.id=id;
    }

    @Override
    public String toString() {
        return  "\n" +
                "Buch " +id +
                " Titel: " + title + " "+
                ", Author: " + author + " " +
                ", Jahr: " + year + " " +
                ", Herusgeber: " + publisher + "\n";
    }
}
