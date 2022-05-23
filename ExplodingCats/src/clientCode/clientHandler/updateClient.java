package clientCode.clientHandler;

import clientCode.GameScreen;
import serverCode.Message;

/*
 * This class is responsible for messaging the server and using the response to update the gui. 
 */

public class updateClient extends Client{
	
	private GameScreen gui;
	
	public updateClient(int p, String ip, GameScreen g) {
		super(p, ip);
		gui = g;
	}
	
	public void updateInfo() {
		updatePlayerList();
		updateHand();
		updateStack();
	}
	
	public void updatePlayerList() {
		try{
			this.send(Message.GETPLAYERS);
			String players = readFromServer();
			//wait(3000);
			if (!players.isEmpty())
				gui.updateNames(players);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateHand() {
		try{
			this.send(Message.GETHAND);
			String hand = readFromServer();
			//wait(3000);
			gui.updateHand(hand);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void updateStack() {
		try{
			this.send(Message.GETSTACK);
			String stack = readFromServer();
			//wait(3000);
			//Method to update stack
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			updateInfo();
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	
	
}
