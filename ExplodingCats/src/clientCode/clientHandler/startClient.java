package clientCode.clientHandler;

import serverCode.Message;

public class startClient extends Client{
	
	private String name;
	
	public startClient(int p, String ip, String n) {
		super(p, ip);
		name = n;
	}
	
	public void startConnection() {
		super.startConnection();
		if (readFromServer().equals(Message.ASKFORNAME)) {
			send(name);
		}
	}
}
