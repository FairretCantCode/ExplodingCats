package clientCode.clientHandler;

import serverCode.Message;

public class startClient extends Client{
	
	private String name;
	
	public startClient(int p, String ip) {
		super(p, ip);
	}
	
	public void setNameOfPlayer(String n) {
		name = n;
	}
	
	public void startConnection() {
		super.startConnection();
		if (readFromServer().equals(Message.ASKFORNAME)) {
			send(name);
		}
	}
}
