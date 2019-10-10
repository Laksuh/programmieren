package de.dhbwka.java.exercise.Probeklausuren.Quiz;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Speedy Quiz
 */
public class SpeedyQuiz {

	/**
	 * Main method, entry point of application
	 *
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		// Set cross platform LAF to get colors for sure to work on MacOS
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}

		List<Question> questionPool = loadQuestions();

		try {
			Game game = new Game(questionPool, 10);

			game.registerClient( new GameTerm("Mia", game) );
			game.registerClient( new GameTerm("Ben", game) );

			game.startGame();
		} catch (GameException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Load questions
	 *
	 * @return questions to load
	 */
	public static List<Question> loadQuestions(){
		List<Question> questions = new ArrayList<>();

		try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Millo\\IdeaProjects\\Programmieren\\src\\de\\dhbwka\\java\\exercise\\Probeklausuren\\Quiz\\questions.txt")) ) {
			while (br.ready()) {
				String line = br.readLine();
				System.out.println(line);
				//String.format(line);
				Question q = parseQuestion(line);
				if ( q != null ){
					questions.add(q);
				}
			}
		} catch(IOException ex){
			ex.printStackTrace();
			System.out.println("öhm");
		}
		/*for (int i = 1; i <= 15; i++) {
			String line = String.format("Generated question %s;Answer 1;Answer 2;Answer 3;Answer 4;0", i);
			Question q = parseQuestion(line);
			if ( q != null ){
				questions.add(q);
			}
		}*/

		return questions;
	}

	/**
	 * Parse a question from input line
	 *
	 * @param line line to parse
	 * @return created question instance
	 */
	public static Question parseQuestion( String line ){
		try {
			String[] parts = line.split(";");
				if ( parts.length == 6 ){
				String[] answers = new String[4];
				System.arraycopy(parts, 1, answers, 0, 4);
				return new Question(parts[0], answers, Integer.parseInt(parts[5]));
			}
		} catch (Exception e) {
		}
		return null;
	}

}
