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
	
	public void startServer(){
		
		try
        {
            sSocket = new ServerSocket( port );
            pool = Executors.newFixedThreadPool(8);
            this.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		
	}
	
	@Override
	public void run() {
		running = true;
		while(running) {
			try {
				ClientHandler client = new ClientHandler(sSocket.accept());			
				clients.add(client);
				client.run();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeServer(){
		running = false;
		for (ClientHandler c: clients) {
			c.send("quit");
		}
		try {
			sSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		
	}
	
	public void makeGame() {
		ArrayList<Player> players = new ArrayList<Player>();
		for (ClientHandler client:clients) {
			players.add(new Player(client.getNameOfPlayer(), client));			
		}
		game = new Game(players);
		System.out.println("Game is created");
	}
	
	public void startGame() {
		game.startGame();
	}
}
