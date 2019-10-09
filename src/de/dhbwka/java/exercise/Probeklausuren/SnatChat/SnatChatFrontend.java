package de.dhbwka.java.exercise.Probeklausuren.SnatChat;

public interface SnatChatFrontend {
	public void receiveMessage(Message msg);
	public void receiveMessage(String msg);
	public Account getAccount();
}
