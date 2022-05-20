package serverHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import gameCode.Game;
import gameCode.Player;
import serverCode.Message;



public class ClientHandler extends Handler {

	private String name;
	private Game game;
	private Player player;
	
	private UpdateHandler updateHandler;
	private PlayHandler playHandler;
	private ExecutorService pool;
	
	public ClientHandler(Socket c){
		super(c);
		pool = Executors.newFixedThreadPool(2);
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
		send(Message.PLAYCARD);
		return readFromClient();
	}
	
	//I'm thinking that we use this method for the see into the future card. Usually we can use the update method for showing 
	public void sendShownCard(String c) {	
		send("show " + c);
	}
	
	
	
	
	
	//Functionality Methods
	
	@Override
	public void closeConnection() {
		super.closeConnection();
		pool.shutdown();
	}
	
	//Method will make the playHandler
	
	public void makePlayHandler() {
		try {
			ServerSocket s = new ServerSocket(4557);
			while (playHandler == null) {
				playHandler = new PlayHandler(s.accept());
				System.out.println("Play Handler connected");
				pool.execute(playHandler);
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Method will make the updateHandler
	
	public void makeUpdateHandler() {
		try {
			ServerSocket s = new ServerSocket(4556);
			while (updateHandler == null) {
				updateHandler = new UpdateHandler(s.accept(), game, player);
				System.out.println("Update Handler connected");
				pool.execute(updateHandler);
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		//Creating the other handlers

		
	}
	
	
	
	
}
