package de.dhbwka.java.exercise.Probeklausuren.SnatChat;


import java.awt.Color;
import java.util.Random;

public class Account {

	private String name;
	private State state;
	private Color color;
	
	public Account(String name) {
		this.name = name;
		this.state = State.AVAILABLE;
		
		Random r = new Random();
		this.color = new Color(r.nextInt(201),r.nextInt(201),r.nextInt(201));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
	

}
