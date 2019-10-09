package de.dhbwka.java.exercise.Probeklausuren.SnatChat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {

	private String roomName;
	private List<SnatChatFrontend> frontends = new ArrayList<>();
	
	public SnatChatRoom(String name) {
		roomName = name;
	}

	public String getRoomName() {
		return roomName;
	}
	
	public void register(SnatChatFrontend frontend) {
		this.frontends.add(frontend);
		
		try ( BufferedReader br = new BufferedReader(new FileReader(roomName + ".txt")) ){
			List<String> lines = new ArrayList<String>();
			while ( br.ready() ) {
				lines.add(br.readLine());
			}
			while ( lines.size() > 10 ) {
				lines.remove(0);
			}
			for ( String line : lines ) {
				frontend.receiveMessage(Message.rot13(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void unregister(SnatChatFrontend frontend) {
		this.frontends.remove(frontend);
	}
	
	public void sendMessage(Message msg) {
		for (SnatChatFrontend snatChatFrontend : frontends) {
			snatChatFrontend.receiveMessage(msg);
		}
		logMessage(msg.getSender().getName() + ": " + msg.getText());
	}
	
	public void sendMessage(String text) {
		for (SnatChatFrontend snatChatFrontend : frontends) {
			snatChatFrontend.receiveMessage(text);
		}
		logMessage(text);
	}
	
	private void logMessage(String text) {
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(this.roomName+".txt", true))){
			bw.write(Message.rot13(text));
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
