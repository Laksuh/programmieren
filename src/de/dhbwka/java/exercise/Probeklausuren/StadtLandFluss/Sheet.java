package de.dhbwka.java.exercise.Probeklausuren.StadtLandFluss;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Sheet {

    JFrame frame = new JFrame();
    JButton start;
    JButton stop;
    JPanel spiel;
    JLabel capitalLetter;
    Game game;
    Player player;
    ArrayList<JTextField> jtfs = new ArrayList<>();
    ArrayList<JLabel> points = new ArrayList<>();


    public Sheet(Player player, Game game){
        this.game = game;
        this.player = player;
        frame.setTitle(player.name);
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(500,750);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3,1));
        JLabel points = new JLabel("Punkte: " +player.punktzahl);
        top.add(points);
        JLabel secs = new JLabel("verbleibende Sekunden: ");
        top.add(secs);
        capitalLetter = new JLabel("Anfangsbuchstabe: ");
        top.add(capitalLetter);
        frame.add(top);

        spiel = new JPanel();

        JLabel platzhalter = new JLabel("Kein Spiel aktiv.");
        spiel.add(platzhalter);
        frame.add(spiel);

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

    public void createColumns(){
        spiel.removeAll();
        spiel.setLayout(new GridLayout(game.columns.size(),3));
        for (ColumnType ct : game.columns){
            spiel.add(new JLabel(ct.getTitle()));
            JTextField jtf = new JTextField();
            jtfs.add(jtf);
            spiel.add(jtf);
            JLabel point = new JLabel("0");
            points.add(point);
            spiel.add(point);
        }
        capitalLetter.setText("Anfangsbuchstabe: " +game.capitalLetter);
        System.out.println(game.capitalLetter);
        frame.repaint();
    }


}
