package de.dhbwka.java.exercise.Probeklausuren.StadtLandFluss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

    char capitalLetter;
    List<ColumnType> columns = new ArrayList<>();
    List<ColumnType> wcolumns = new ArrayList<>();
    List<Sheet> sheets = new ArrayList<>();

    int duration = 0;
    boolean running;

    public Game(int min, int max, int seconds){
        if(min<=3){
            min =3;
            if(max<min){
                max = min;
            }
        }
        capitalLetter = createFirstCharacter();
        createColumns(min, max);
        System.out.println(capitalLetter);
    }

    char createFirstCharacter(){
        int z = (int) ((Math.random()*26)+65);
        System.out.println(z);
        return (char) z;
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
        System.out.println(Arrays.toString(columns.toArray()));
    }

    public void register(Sheet sheet){
        sheets.add(sheet);
    }

    public void startGame(){
        createFirstCharacter();
        for (Sheet sheet: sheets ) {
            sheet.start.setEnabled(false);
            sheet.stop.setEnabled(true);
            sheet.createColumns();
        }
    }

    public void stopGame(){
        for (Sheet sheet: sheets ) {
            sheet.start.setEnabled(true);
            sheet.stop.setEnabled(false);
        }
        auswerten();
    }

    public void auswerten(){

        for (Sheet sheet: sheets ) {
            ArrayList<String> words = new ArrayList<>();
            for (int i=0; i< sheet.jtfs.size(); i++){
                words.add(sheet.jtfs.get(i).getText());
                sheet.player.words = words;
            }

        }

        for (int i=0; i<sheets.get(0).jtfs.size(); i++){
            for (int j=1; j<sheets.get(0).jtfs.size();j++){
                if(sheets.get(i).player.words.get(j).equals(sheets.get(i).player.words.get(j-1))){
                    sheets.get(i).player.punktzahl +=5;
                } else {
                    sheets.get(i).player.punktzahl +=10;
                }
            }
            System.out.println(sheets.get(i).player.punktzahl);
        }

    }

}
