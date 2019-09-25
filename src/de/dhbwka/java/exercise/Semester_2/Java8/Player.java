package de.dhbwka.java.exercise.Semester_2.Java8;

public class Player implements Comparable<Player> {

    private int number;
    private String name;
    private String position;
    private String birthday;
    private String club;
    private int games;
    private int goals;

    public Player(String number, String name, String position, String birthday, String club, String games, String goals) {
        this.number = Integer.parseInt(number);
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.club = club;
        this.games = Integer.parseInt(games);
        this.goals = Integer.parseInt(goals);
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }

    public Player(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
