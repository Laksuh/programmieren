package de.dhbwka.java.exercise.Semester_2.Datenstrukturen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Library {

    static int id=0;
    static ArrayList<Book> buecher = new ArrayList<Book>();

    public static void main(String[] args){

    JFrame frame = initFrame();
    insertBook("Harry Potter und der Stein der Weisen", "JK Rowling", 1997, "Carlsen Verlag");
    insertBook("Harry Potter und die Kammer des Schreckens", "JK Rowling", 1998, "Carlsen Verlag");
    insertBook("Harry Potter und der Gefangene von Askaban", "JK Rowling", 1999, "Carlsen Verlag");
    insertBook("Harry Potter und der Feuerkelch", "JK Rowling", 2000, "Carlsen Verlag");
    insertBook("Harry Potter und der Orden des Phoenix", "JK Rowling", 2003, "Carlsen Verlag");
    insertBook("Harry Potter und Halbblutprinz", "JK Rowling", 2005, "Carlsen Verlag");
    insertBook("Harry Potter und die Heiligtümer des Todes", "JK Rowling", 2007, "Carlsen Verlag");

    frame.setVisible(true);
    }

    public static void insertBook(String title, String author, int year, String publisher){
        id++;
        buecher.add(new Book(title, author, year, publisher, id));
        System.out.println(buecher.toString());
    }

    public static JFrame initFrame(){
        JFrame frame = new JFrame("Library");
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6,1));

        JLabel title = new JLabel("Title");
        JLabel author = new JLabel("Author");
        JLabel year = new JLabel("Year");
        JLabel publisher = new JLabel("Publisher");
        JLabel textoutput = new JLabel("Text output: ");

        JTextField jtfTitle = new JTextField();
        JTextField jtfAuthor = new JTextField();
        JTextField jtfYear = new JTextField();
        JTextField jtfPublisher = new JTextField();

        JButton jbtnSaveEntry = new JButton("SaveEntry in a way of long text");
        JButton jbtnTitle = new JButton("Title");
        JButton jbtnAuthor = new JButton("Author");
        JButton jbtnYear = new JButton("Year");
        JButton jbtnPublisher = new JButton("Publisher");

        JPanel jpnlTitle = new JPanel();
        JPanel jpnlAuthor = new JPanel();
        JPanel jpnlYear = new JPanel();
        JPanel jpnlPublisher = new JPanel();
        JPanel jpnlBot = new JPanel();

        jpnlTitle.setLayout(new GridLayout(1,2));
        jpnlAuthor.setLayout(new GridLayout(1,2));
        jpnlYear.setLayout(new GridLayout(1,2));
        jpnlPublisher.setLayout(new GridLayout(1,2));

        jpnlBot.add(textoutput);
        jpnlBot.add(jbtnTitle);
        jpnlBot.add(jbtnAuthor);
        jpnlBot.add(jbtnYear);
        jpnlBot.add(jbtnPublisher);

        jpnlTitle.add(title);
        jpnlTitle.add(jtfTitle);
        jpnlAuthor.add(author);
        jpnlAuthor.add(jtfAuthor);
        jpnlYear.add(year);
        jpnlYear.add(jtfYear);
        jpnlPublisher.add(publisher);
        jpnlPublisher.add(jtfPublisher);

        frame.add(jpnlTitle);
        frame.add(jpnlAuthor);
        frame.add(jpnlYear);
        frame.add(jpnlPublisher);
        frame.add(jbtnSaveEntry);
        frame.add(jpnlBot);


        jbtnSaveEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertBook(jtfTitle.getText().toString(), jtfAuthor.getText().toString(), Integer.parseInt(jtfYear.getText().toString()), jtfPublisher.getText().toString());
            }
        });

        jbtnTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });

        jbtnAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });

        jbtnYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });

        jbtnPublisher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });

        return frame;
    }

    public static void showList() {
        JOptionPane.showMessageDialog(null, buecher.toString(), "Buecher", JOptionPane.PLAIN_MESSAGE);
    }
}
