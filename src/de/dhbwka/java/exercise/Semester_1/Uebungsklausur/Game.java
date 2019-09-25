package de.dhbwka.java.exercise.Semester_1.Uebungsklausur;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

    Board board;
    Player[] players;
    String[] checkouts;

    public Game() {
    }

    public Game(Board b, Player[] players) {
        this.board = b;
        this.players = players;
        this.checkouts = getCheckouts();
    }

    public void start(){
        for(int runde=0;runde<10;runde++){
            for(Player p : players){
                System.out.println("Spieler" + p.getName() +", ");
                System.out.println(p.getRemainingPoints() +"Punkte");

                if(p.getRemainingPoints() < 170){
                    System.out.println("Mögliche Checkouts: " +getCheckouts());
                }

                System.out.println("Würfe eingeben: ");
                Scanner scan = new Scanner(System.in);
                String vi = scan.next();
                String[] input = vi.split(" ");
                Field[] newFields = new Field[input.length];
                for(int j=0;j<input.length;j++){
                    newFields[j] = board.parseField(input[j]);
                }
                Visit currentVisit = new Visit(newFields);
                if(p.addVisit(currentVisit)){
                    System.out.println("geworfen: " +currentVisit.getValue());
                    if(p.getRemainingPoints() == 0){
                        System.out.println(p.getName() +" hat gewonnen");
                        highScore(p.getName() +" gewann mit" +p.getCountDartsThrown() +" Darts.");
                        System.exit(0);
                    }
                }
                System.out.println("-----------------------------------");
            }

        }
        System.out.println("10 Runden beendet, Spiel vorbei...");
    }

    public void highScore(String s){
        try(PrintWriter pw = new PrintWriter(new FileWriter("highscore.txt", true))){
            pw.println(s);
        } catch(IOException e){
            System.err.println("Fehler");
        }
    }

    public String[] getCheckouts(){
        String[] ergebnis = new String[171];
        ergebnis[0] = "";
        try(BufferedReader br = new BufferedReader(new FileReader("checkouts.txt"))){
            for(int i=1; i<=170; i++){
                ergebnis[i] = br.readLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return ergebnis;
    }

}
