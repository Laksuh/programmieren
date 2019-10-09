package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    int anzahl;
    List<Question> questions = new ArrayList<>();
    List<GameClient> clients = new ArrayList<>();
    int questionIndex=0;

    public Game(List<Question> questionpool, int anzahl) throws GameException {
        this.anzahl = anzahl;
        pickQuestions(questionpool);

    }

    public void pickQuestions(List<Question> questionpool) throws GameException {
        Collections.shuffle(questionpool);
        if(anzahl>questionpool.size()){
            throw new GameException("Too few questions available");
        }
        for (int i = 0; i < anzahl; i++) {
            questions.add(questionpool.get(i));
        }
    }

    public void registerClient(GameClient client){
        clients.add(client);
    }

    public int getQuestionCount(){
        return anzahl;
    }

    public void startGame(){
        for(GameClient client : clients){
            client.setQuestion(questionIndex, questions.get(questionIndex));
        }
    }

    public void answerSelected(GameClient client, int index){
        if(index == questions.get(questionIndex).correctIndex) {
            client.setAnswerState(questionIndex, Status.CORRECT);
            clients.remove(client);
            for (GameClient tclient: clients){
                tclient.setAnswerState(questionIndex, Status.NO_ANSWER);
            }
            clients.add(client);
        }
        if(index != questions.get(questionIndex).correctIndex) {
            client.setAnswerState(questionIndex, Status.WRONG);
            clients.remove(client);
            for (GameClient tclient: clients){
                tclient.setAnswerState(questionIndex, Status.NO_ANSWER);
            }
            clients.add(client);
        }
        questionIndex++;
        if (questionIndex==getQuestionCount()){
            for (GameClient tclient : clients){
                tclient.gameIsOver();
            }
            scores();
            return;
        }
        for (GameClient tclient: clients){
            tclient.setQuestion(questionIndex, questions.get(questionIndex));
        }
    }

    public void scores(){
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> points = new ArrayList<>();
        String s="2";
        for (int i=0; i<names.size(); i++){
            s=s + names.get(i) +"("+points.get(i)+")";
        }
        for (GameClient client : clients){
            names.add(client.getPlayerName());
            points.add(client.getPoints());
        }
        for (GameClient client : clients){
            client.end(names, points);
        }
        try(Writer fWriter = new FileWriter("C:/users/Millo/Desktop/highscores.txt", true)){

            fWriter.write(s);
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
