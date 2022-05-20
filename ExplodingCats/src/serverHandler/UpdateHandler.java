package serverHandler;

import java.io.IOException;
import java.net.Socket;
import gameCode.*;
import serverCode.Message;


public class UpdateHandler extends Handler{
	
	private Game game;
	private Player player;
	public UpdateHandler(Socket c, Game g, Player p) {
		super(c);
		game = g;
		player = p;
	}
	
	//Getters
	
	//Setters
	
	//Client methods
	
		public String getNameOfPlayers() {
			String names = "";
			for (Player p: game.getPlayers()) {
				names += p.getName() + ",";
			}
			return names;
		}
		
		public String getHand() {
			String hand = "";
			for (Card c: this.player.getHand()) {
				hand += c.getName() + ","; 
			}
			return hand;
		}
		
		public String getStack() {
			String stack = "";
			for (Card c : game.getCardStack().getCardsInStack()) {
				stack += c + ",";
			}
			return stack;
		}
	
	//Functionality
	
	@Override
	public void run() {
		try {
			 String line = "";
	            readLoop: while( true ){ 	
	                line = this.readFromClient();
	                //wait(3000);
	            	if (line != null) {
	            		switch(line) {
		                case Message.GETPLAYERS:
		                	this.send(this.getNameOfPlayers());
		                	break;
		                case Message.GETHAND:
		                	this.send(this.getHand());
		                	break;
		                case Message.GETSTACK:
		                	this.send(this.getStack());
		                	break;
		
		                case Message.QUITCONNECTION:
		                	break readLoop;
		                }
	            	}
	                line = null;
	            }
	            this.closeConnection();
	            System.out.println( "Connection closed" );
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
