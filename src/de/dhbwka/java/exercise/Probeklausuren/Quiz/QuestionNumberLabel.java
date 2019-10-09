package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import javax.swing.*;

public class QuestionNumberLabel extends JLabel {

    Status status = Status.PENDING;

    public QuestionNumberLabel(){
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
    }

    public void changeStatus(Status status){
        this.status = status;
        this.setBackground(status.getColor());
    }

}
