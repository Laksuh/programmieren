package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameTerm implements GameClient{

    String name;
    Game game;
    ArrayList<QuestionNumberLabel> labels = new ArrayList<>();
    ArrayList<JButton> buttons = new ArrayList<>();
    JLabel question = new JLabel();
    JLabel remainingTime = new JLabel();
    GameTerm gt =this;
    int points=0;

    JFrame frame = new JFrame();

    public GameTerm(String name, Game game) {
        this.name = name;
        this.game = game;

        frame.setTitle(name);
        frame.setLayout(new GridLayout(4,1));
        frame.setSize(500,200);

        JPanel top = new JPanel();
        for (int i=0; i<game.anzahl; i++){
            labels.add(new QuestionNumberLabel());
            labels.get(i).setText(" . "+i+" . ");
            top.add(labels.get(i));
        }
        frame.add(top);
        frame.add(question);
        remainingTime.setText("30");
        frame.add(remainingTime);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,2));
        for (int i=0; i<4; i++) {
            buttons.add(new JButton("sample"));
            bottom.add(buttons.get(i));
            int finalI = i;
            buttons.get(finalI).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.answerSelected(gt, finalI);
                }
            });
        }
        frame.add(bottom);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public String getPlayerName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    public void setQuestion(int questionIndex, Question q){
        question.setText(q.toString());
        labels.get(questionIndex).changeStatus(Status.ACTIVE);
        for (int i=0;i<4;i++){
            buttons.get(i).setText(q.answers.get(i));
        }
    }

    public void setRemainingSeconds(int seconds){
        remainingTime.setText(seconds+"");
    }

    public void gameIsOver(){
        for (int i=0; i<4; i++)
            buttons.get(i).setEnabled(false);
    }

    public void setAnswerState(int questionIndex, Status status){
        labels.get(questionIndex).changeStatus(status);
        if (status == Status.WRONG){
            points--;
        }
        if (status == Status.CORRECT){
            points++;
        }
    }

    public void end(ArrayList<String> names, ArrayList<Integer> points){
        String s="";
        for (int i=0; i<names.size(); i++){
            s=s + names.get(i) +"("+points.get(i)+")";
        }
        JOptionPane.showMessageDialog(frame,"Dauer: "+game.duration + "s Punkte: "+s, "Ende", JOptionPane.INFORMATION_MESSAGE);

    }


}
