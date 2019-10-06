
public class Message {

	private String text;
	private Account sender;
	public Message(String text, Account sender) {
		super();
		this.text = text;
		this.sender = sender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	
	public static String rot13(String msg) {
		char[] msgArr = msg.toCharArray();
		for (int i = 0; i < msgArr.length; i++) {
			char c = msgArr[i];
			if ( c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm' ) {
				msgArr[i] = (char)(c+13);
			}
			else if ( c >= 'N' && c <= 'Z' || c >= 'n' && c <= 'z' ) {
				msgArr[i] = (char)(c-13);
			}
		}
		return new String(msgArr);
	}
	
}
