package de.dhbwka.java.exercise.Semester_2.Java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Soccer {

    static ArrayList<Player> players;
    public static void main(String args[]){

        Path p = Paths.get("C:\\Users\\Millo\\Desktop\\aufgabe.txt");
        List<String> lines = null;
        try{
            lines = Files.readAllLines(p);
            System.out.println(lines);
        } catch(IOException e){
            e.printStackTrace();
        }

        String[] fields= null;

        for(String s : lines){
           fields = s.split(";");
        }
        players.add(new Player(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]));

        //for(int i=0; i<22;i++) {
          //  players.add(new Player(fields.get(0), fields.get(1), fields.get(2),fields.get(3),fields.get(5),fields.get(6), fields.get(7)));
        //}
        System.out.println(players);
    }

    public int comparePlayerNumber(Player p1, Player p2){
        return Integer.compare(p1.getNumber(), p2.getNumber());
    }

    public int comparePlayerName(Player p1, Player p2){
        return p1.compareTo(p2);
    }

}