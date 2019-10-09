package de.dhbwka.java.exercise.Probeklausuren.StadtLandFlussTogether;

public enum ColumnType {

    COUNTRY("Stadt"),
    LAND("Land"),
    RIVER("Fluss"),
    PROFESSION("Beruf"),
    ANIMAL("Tier"),
    NAME("Vorname"),
    SPORT("Sportart"),
    FOOD("Lebensmittel"),
    BEVERAGE("Getränk"),
    GAME("Spiel");

    private String title;

    ColumnType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}