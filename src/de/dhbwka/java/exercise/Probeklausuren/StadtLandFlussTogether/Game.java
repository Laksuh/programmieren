package de.dhbwka.java.exercise.Probeklausuren.StadtLandFlussTogether;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    char firstLetter;
    List<ColumnType> columns = new ArrayList<>();
    List<ColumnType> wcolumns = new ArrayList<>();
    List<Sheet> registeredSheets = new ArrayList<>();
    ArrayList<String> acceptedWords= new ArrayList<>();
    ArrayList<String> playerwords= new ArrayList<>();

    int remainingSeconds;
    boolean running = false;
    int min;
    int max;


    public Game(int min, int max, int seconds){

        if (min <=3){
            min =3;
        }
        if (max < min){
            max = min;
        }
        this.min = min;
        this.max = max;
        remainingSeconds = seconds;
        createColumns(this.min, this.max);
        acceptedWords=readInWords();
    }

    void createColumns(int min, int max){
        int z = (int) ((Math.random()*(max-min))+min);
        System.out.println(z);
        columns.add(ColumnType.COUNTRY);
        columns.add(ColumnType.LAND);
        columns.add(ColumnType.RIVER);
        wcolumns.add(ColumnType.BEVERAGE);
        wcolumns.add(ColumnType.SPORT);
        wcolumns.add(ColumnType.ANIMAL);
        wcolumns.add(ColumnType.PROFESSION);
        wcolumns.add(ColumnType.NAME);
        wcolumns.add(ColumnType.FOOD);
        wcolumns.add(ColumnType.GAME);
        Collections.shuffle(wcolumns);
        for (int i=3; i<=z; i++){
            columns.add(wcolumns.get(i));
        }
    }

    private char createFirstCharacter(){
        char character = 'A';
        Random rand = new Random();
        character += rand.nextInt(26);
        return character;
    }

    public void startGame(){
        if (!running){
            running = true;
            firstLetter = createFirstCharacter();
            for (Sheet sheet: registeredSheets ) {
                sheet.drawMiddle();
            }
        }
    }

    public void stopGame(){
        for (Sheet sheet: registeredSheets ) {
            sheet.start.setEnabled(true);
            sheet.stop.setEnabled(false);
            running = false;
            gatherResults();
        }
    }

    public void register(Sheet sheet) {
        registeredSheets.add(sheet);
    }

    public void gatherResults(){
        List<List<String>> allResults = new ArrayList<>();
        List<String> playerResults = new ArrayList<>();
        for (Sheet sheet :
                registeredSheets) {
            for (JTextField jtf : sheet.jtfs) {
               playerResults.add(jtf.getText());
            }


            allResults.add(playerResults);
        }

        for(int i = 0; i<columns.size(); i++)
        {
            List<String> littleList = new ArrayList<>();

            for(int j = 0; j<registeredSheets.size(); j++)
            {
                littleList.add(allResults.get(j).get(i));
            }

            for (int k = 0; k<littleList.size(); k++){
                if(littleList.get(k).equals(" ")) {
                    registeredSheets.get(k).player.addPoints(0);
                    registeredSheets.get(k).updatePoints(i,0);
                    //System.out.println("NULL Punkte " + " " + sheetList.get(k).getPlayer().getPlayername() + ", " + littleList.get(k));
                    continue;
                }
                String temp = littleList.get(k);
                littleList.remove(k);
                if(littleList.contains(temp)){
                    registeredSheets.get(k).player.addPoints(5);
                    registeredSheets.get(k).updatePoints(i,5);
                    //System.out.println("FÜNF Punkte" + " " + sheetList.get(k).getPlayer().getPlayername() + ", " + temp);

                }
                if(!littleList.contains(temp)){
                    registeredSheets.get(k).player.addPoints(10);
                    registeredSheets.get(k).updatePoints(i, 10);
                    //System.out.println("ZEHN Punkte" + " " + sheetList.get(k).getPlayer().getPlayername() + ", " + temp);

                }
                if(onlyBlanks(littleList)){
                    registeredSheets.get(k).player.addPoints(20);
                    registeredSheets.get(k).updatePoints(i, 20);
                    //System.out.println("ZWANZIG Punkte" + " " + sheetList.get(k).getPlayer().getPlayername() + ", " + temp);
                }
                littleList.add(k,temp);
            }

        }

    }

    private boolean onlyBlanks(List<String> list){

        boolean onlyblanks = true;
        for (String blank :
                list) {
            if(!blank.equals(" ")){
                onlyblanks = false;
            }
        }
        return onlyblanks;
    }

    public boolean checkWord(String word){
        if (word.length() > 1) {
            char letter = word.charAt(0);
            if (letter == firstLetter){
                if (acceptedWords.contains(word)){
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> readInWords(){
        ArrayList<String> lines = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader("C:/users/Millo/Desktop/einsDatei.txt")) ) {
            while (br.ready()) {
                String line = br.readLine();
                lines.add(line);
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return lines;
    }
}
