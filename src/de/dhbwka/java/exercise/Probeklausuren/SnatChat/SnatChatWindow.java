package de.dhbwka.java.exercise.Probeklausuren.SnatChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SnatChatWindow extends JFrame implements SnatChatFrontend {

	private SnatChatRoom room;
	private Account account;
	private ChatMessagesComponent messagesComponent = new ChatMessagesComponent();
	private JTextField textfield = new JTextField();
	
	public SnatChatWindow(SnatChatRoom room, Account account) {
		this.room = room;
		this.account = account;
		
		this.initUI();
	}

	private void initUI() {
		this.setTitle(account.getName() + " (" + room.getRoomName() + ")");
		this.setLayout(new BorderLayout());
		
		JLabel username = new JLabel(account.getName(), JLabel.CENTER);
		username.setForeground(account.getColor());
		this.add(username, BorderLayout.NORTH);
		
		JPanel middlePanel = new JPanel( new BorderLayout() );
		middlePanel.add(messagesComponent, BorderLayout.CENTER);
		
		JPanel radioPanel = new JPanel();
		ButtonGroup radioGroup = new ButtonGroup();
		middlePanel.add(radioPanel, BorderLayout.SOUTH);
		for ( State state : State.values() ) {
			JRadioButton stateBtn = new JRadioButton(state.getLabel());
			radioGroup.add(stateBtn);
			radioPanel.add(stateBtn);
			if ( account.getState() == state ) {
				stateBtn.setSelected(true);
			}
			stateBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					room.sendMessage("State of user '" + account.getName() + "' is now '"+state.getLabel()+"'");
					account.setState(state);
				}
			});
		}
		this.add(middlePanel, BorderLayout.CENTER);
		
		JPanel inputPanel = new JPanel(new BorderLayout());
		inputPanel.add(textfield, BorderLayout.CENTER);
		JButton sendButton = new JButton("Send");
		
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textfield.getText();
				if ( text.length() == 0 ) {
					JOptionPane.showMessageDialog(SnatChatWindow.this, "Dear " + account.getName() + ", please enter a message");
				} else {
					Message msg = new Message(text, account);
					room.sendMessage(msg);
					textfield.setText("");
				}
				
			}
		});
		
		inputPanel.add(sendButton, BorderLayout.EAST);
		this.add(inputPanel, BorderLayout.SOUTH);
		
		this.setSize(640, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void receiveMessage(Message msg) {
		JLabel msgLabel = new JLabel(msg.getSender().getName() + ": " + msg.getText());
		msgLabel.setForeground(msg.getSender().getColor());
		messagesComponent.add(msgLabel);
		labelCountdown(msgLabel);
	}

	@Override
	public void receiveMessage(String msg) {
		JLabel msgLabel = new JLabel(msg);
		msgLabel.setForeground(Color.GRAY);
		messagesComponent.add(msgLabel);
		labelCountdown(msgLabel);
	}
	
	private void labelCountdown(JLabel label) {
		Thread countdownThread = new Thread() {
			@Override
			public void run() {
				int val = 30;
				String text = label.getText();
				
				while ( val > 0 ) {
					label.setText(text + " [ " + val + " ]");
					val--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				messagesComponent.remove(label);
			}
		};
		countdownThread.start();
	}

	@Override
	public Account getAccount() {
		return account;
	}

}
