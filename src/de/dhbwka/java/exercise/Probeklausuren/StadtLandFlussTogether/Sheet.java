package de.dhbwka.java.exercise.Probeklausuren.StadtLandFlussTogether;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class Sheet {

    Game game;
    Player player;
    JFrame frame = new JFrame();
    JLabel firstLetter ;
    JPanel middle;
    JButton start;
    JButton stop;
    ArrayList<JTextField> jtfs = new ArrayList<>();
    ArrayList<JLabel> points = new ArrayList<>();

    public Sheet(Player player, Game game){
        this.game = game;
        this.player = player;
        frame.setTitle(player.name);
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(500,500);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3,1));
        JLabel points = new JLabel("Punkte: " +player.points);
        top.add(points);
        JLabel secs = new JLabel("verbleibende Sekunden: ");
        top.add(secs);
        firstLetter = new JLabel("Anfangsbuchstabe: ");
        top.add(firstLetter);
        frame.add(top);

        middle = new JPanel();

        JLabel noGame = new JLabel("Kein Spiel aktiv.");
        middle.add(noGame);
        frame.add(middle);

        JPanel bot = new JPanel();
        start = new JButton("start");
        stop = new JButton("stop");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.stopGame();
            }
        });
        stop.setEnabled(false);
        bot.add(start);
        bot.add(stop);

        frame.add(bot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void drawMiddle(){
        middle.removeAll();
        middle.setLayout(new GridLayout(game.columns.size(),3));
        for (ColumnType ct : game.columns){
            middle.add(new JLabel(ct.getTitle()));
            JTextField jtf = new JTextField();
            jtfs.add(jtf);
            middle.add(jtf);
            JLabel point = new JLabel(" 0");
            points.add(point);
            middle.add(point);
        }
        firstLetter.setText("Anfangsbuchstabe: " +game.firstLetter);
        frame.repaint();
        stop.setEnabled(true);
    }

    public void dialog(String word){
        if(JOptionPane.showConfirmDialog(frame, word +" hinzufügen?", "hinzufügen?", JOptionPane.YES_NO_CANCEL_OPTION)==0){
            try(Writer fWriter = new FileWriter("C:/users/Millo/Desktop/einsDatei", true)){
                fWriter.write(word);
            } catch(IOException ex){
                ex.printStackTrace();
            }
        };
    }

    public void updatePoints(int i, int p) {
        points.get(i).setText(p+"");
    }
}
