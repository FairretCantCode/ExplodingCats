package clientCode.clientHandler;

import clientCode.GameScreen;
import serverCode.Message;

/*
 * This class is responsible for receiving messages from the server. 
 */

public class playClient extends Client{
	
	
	
	private String name;
	
	public playClient(int p, String ip) {
		super(p, ip);
	}

	
	

	//Getters
	
	
	//Setters
	
	public void setNameOfPlayer(String n) {
		name = n;
	}
	
	
	
	
	//Functionality
	
	@Override
	public void run() {
		String line;
		try {
			readLoop: while(true) {
				line = readFromServer();
				switch (line) {
				
				
				case Message.QUITCONNECTION:
					closeConnection();
					break readLoop;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
