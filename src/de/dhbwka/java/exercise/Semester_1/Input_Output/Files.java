package de.dhbwka.java.exercise.Semester_1.Input_Output;

import java.io.*;

public class Files {

    public static void main(String[] args){

        File myDir = new File("myDir");
        myDir.mkdir();

        try ( Writer fWriter = new FileWriter("myDir/foo1") ) {

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try ( Writer fWriter = new FileWriter("myDir/foo2") ) {

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try ( Writer fWriter = new FileWriter("myDir/foo3") ) {

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

}
