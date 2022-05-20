package serverCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import gameCode.Game;
import gameCode.Player;
import serverHandler.ClientHandler;


public class Server extends Thread {
	//Socket Stuff
	private int port;
	private ServerSocket sSocket;
	private boolean running;
	//Game Stuff
	private ArrayList<ClientHandler> clients;
	private ExecutorService pool;
	private Game game;
	
	public Server(int portNum){
		running = false;
		port = portNum;
		clients = new ArrayList<ClientHandler>();
		
	}
	
	//Getters
	
	//Setters
	
	//Functionality Methods
	
	public void startServer(){
		
		try{
            sSocket = new ServerSocket( port );
            pool = Executors.newFixedThreadPool(8);
            this.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
		
	}
	
	public void stopAccepting() {
		running = false;
		try {
			sSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeServer(){
		stopAccepting();
		for (ClientHandler c: clients) {
			c.closeConnection();
		}
		pool.shutdown();
	}
	
	@Override
	public void run() {
		running = true;
		while(running) {
			try {
				ClientHandler client = new ClientHandler(sSocket.accept());			
				clients.add(client);
				System.out.println("A player has connected");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void makeGame() {
		this.stopAccepting(); //Stops accepting people
		game = new Game();
		
		for (ClientHandler client:clients) {
			client.setGame(game);
			pool.execute(client);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println("Can't Sleep???");
			}
			Player p = new Player(client.sendName(), client, client.getPlayHandler(), client.getUpdateHandler());
			client.setPlayer(p);
			game.addPlayer(p);		
			
		}
		System.out.println("Game is created");
	}
	
	public void startGame() {
		this.makeGame();
		for (ClientHandler c: clients) {
			c.startHandlers();
		}
		game.startGame();
		this.closeServer();
	}
	
}
