package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {

    String questionText;
    ArrayList<String> answers = new ArrayList<>();
    int correctIndex;

    public Question(){

    }

    public Question(String questionText, String[] answers, int correctIndex) {
        this.questionText = questionText;
        this.answers = new ArrayList<> (Arrays.asList(answers));
        this.correctIndex = correctIndex;
    }

    @Override
    public String toString() {
        return  questionText;
    }
}
