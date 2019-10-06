
public interface SnatChatFrontend {
	public void receiveMessage(Message msg);
	public void receiveMessage(String msg);
	public Account getAccount();
}
