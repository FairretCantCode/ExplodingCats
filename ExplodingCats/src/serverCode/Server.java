package serverCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import gameCode.Game;
import gameCode.Player;


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
	}
	public void closeServer(){
		for (ClientHandler c: clients) {
			c.send(Message.QUITCONNECTION);
		}
		try {
			sSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
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
				System.out.println("Connected");
				client.run();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void makeGame() {
		this.stopAccepting(); //Stops accepting people
		ArrayList<Player> players = new ArrayList<Player>();
		for (ClientHandler client:clients) {
			Player p = new Player(client.sendName(), client);
			client.setPlayer(p);
			players.add(p);			
		}
		game = new Game(players);
		for (ClientHandler client: clients) {
			client.setGame(game);
		}
		System.out.println("Game is created");
	}
	
	public void startGame() {
		game.startGame();
		this.closeServer();
	}
	
}
