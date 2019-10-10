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
    int questionIndex = 0;
    int time = 10;
    int duration = 0;

    public Game(List<Question> questionpool, int anzahl) throws GameException {
        this.anzahl = anzahl;
        pickQuestions(questionpool);

    }

    public void pickQuestions(List<Question> questionpool) throws GameException {
        Collections.shuffle(questionpool);
        if (anzahl > questionpool.size()) {
            throw new GameException("Too few questions available");
        }
        for (int i = 0; i < anzahl; i++) {
            questions.add(questionpool.get(i));
        }
    }

    public void registerClient(GameClient client) {
        clients.add(client);
    }

    public int getQuestionCount() {
        return anzahl;
    }

    public void startGame() {
        setSetSeconds();
        countTime();
        for (GameClient client : clients) {
            client.setQuestion(questionIndex, questions.get(questionIndex));
            client.setRemainingSeconds(10);
        }
    }

    public void answerSelected(GameClient client, int index) {
        time=10;
        if (index == questions.get(questionIndex).correctIndex) {
            client.setAnswerState(questionIndex, Status.CORRECT);
            clients.remove(client);
            for (GameClient tclient : clients) {
                tclient.setAnswerState(questionIndex, Status.NO_ANSWER);
            }
            clients.add(client);
        }
        if (index != questions.get(questionIndex).correctIndex) {
            if (index == 5){
                for (GameClient tclient : clients) {
                    tclient.setAnswerState(questionIndex, Status.NO_ANSWER);
                }
            }else {
                client.setAnswerState(questionIndex, Status.WRONG);
                clients.remove(client);
                for (GameClient tclient : clients) {
                    tclient.setAnswerState(questionIndex, Status.NO_ANSWER);
                }
                clients.add(client);
            }
        }
        questionIndex++;
        if (questionIndex == getQuestionCount()) {
            for (GameClient tclient : clients) {
                tclient.gameIsOver();
            }
            scores();
            return;
        }
        for (GameClient tclient : clients) {
            tclient.setQuestion(questionIndex, questions.get(questionIndex));
            tclient.setRemainingSeconds(time);
        }
    }

    public void scores() {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> points = new ArrayList<>();
        String s = "Dauer: " + duration + "s ";
        for (int i = 0; i < names.size(); i++) {
            s = s + names.get(i) + "(" + points.get(i) + ")";
        }
        for (GameClient client : clients) {
            names.add(client.getPlayerName());
            points.add(client.getPoints());
        }
        for (GameClient client : clients) {
            client.end(names, points);
        }
        try (Writer fWriter = new FileWriter("C:/users/Millo/Desktop/highscores.txt", true)) {

            fWriter.write(s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void countTime() {
        Thread countTimeThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    duration++;
                }
            }

        };
        countTimeThread.start();
    }

    public void setSetSeconds() {
        Thread setSeconds = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (time == 0) {
                        time = 10;
                        for (GameClient client : clients) {
                            client.setRemainingSeconds(time);
                            client.setAnswerState(questionIndex,Status.NO_ANSWER);
                        }
                        answerSelected(clients.get(0), 5);
                    } else {
                        time--;
                        for (GameClient client : clients) {
                            client.setRemainingSeconds(time);
                        }
                    }
                }
            }

        };
        setSeconds.start();
    }
}


