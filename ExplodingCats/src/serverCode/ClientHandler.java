package serverCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import gameCode.*;



public class ClientHandler extends Thread {
	
	
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	private String name;
	private Game game;
	private Player player;
	
	public ClientHandler(Socket c){
		this.client = c;
		name = null;
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Getters
	
	public String sendName() {
		return name;
	}
	
	//Setters
	
	public void setGame(Game g) {
		this.game = g;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	//Methods to communicate to user
	
	public String askForCard() {
		try {
			send("play a card");
			return reader.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//I'm thinking that we use this method for the see into the future card. Usually we can use the update method for showing 
	public void sendShownCard(String c) {	
		send("show " + c);
	}
	
	
	
	//Client methods
	
	public String getNameOfPlayers() {
		String names = "";
		for (Player p: game.getPlayers()) {
			names += p.getName() + "|";
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
	
	//Functionality Methods
	
	@Override
	public void run() {
		while (name == null) {
			try {
				name = reader.readLine();
			}catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		//After registered into game
		try {
			 String line = reader.readLine();
	            readLoop: while( true )
	            {
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
	                	
	                	
	                	
	                	
	                	
	                case "quit":
	                	break readLoop;
	                }
	                
	            }
	            
	            // Close our connection
	            reader.close();
	            writer.close();
	            client.close();

	            System.out.println( "Connection closed" );
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send(String msg) {
		System.out.println("sending " + msg);
		writer.println(msg);
		writer.flush();	
	}
	
	
}
