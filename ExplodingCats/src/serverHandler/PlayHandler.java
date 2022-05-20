package serverHandler;

import java.net.Socket;

import serverCode.Message;

public class PlayHandler extends Handler{
	
	public PlayHandler(Socket s) {
		super(s);
	}
	
	//Methods to communicate to user
	
		public String askForCard() {
			send(Message.PLAYCARD);
			return readFromClient();
		}
		
		//I'm thinking that we use this method for the see into the future card. Usually we can use the update method for showing 
		public void sendShownCard(String c) {	
			send("show " + c);
		}

	
	
}
