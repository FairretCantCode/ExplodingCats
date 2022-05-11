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
	private String privateKey;
	//Game Stuff
	private ArrayList<ClientHandler> clients;
	private ExecutorService pool;
	private Game game;
	
	public Server(int portNum){
		privateKey = "YouSuckAtCoding";
		running = false;
		port = portNum;
		clients = new ArrayList<ClientHandler>();
		
	}
	
	public void startServer(){
		try
        {
            sSocket = new ServerSocket( port );
            this.start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		pool = Executors.newFixedThreadPool(2);
	}
	
	@Override
	public void run() {
		running = true;
		while(clients.size() < 2) {
			System.out.println(clients.size());
			try {
				ClientHandler client = new ClientHandler(sSocket.accept());				
				if (client.askForKey().equals(privateKey)) {
					clients.add(client);
					client.run();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeServer(){
		for (ClientHandler c: clients) {
			c.send("quit");
		}
		try {
			sSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		running = false;
	}
	
	public void makeGame() {
		ArrayList<Player> players = new ArrayList<Player>();
		for (ClientHandler client:clients) {
			players.add(new Player(client.askForName(), client));
			System.out.println("here");
			
		}
		game = new Game(players);
		System.out.println("Game is created");
	}
	
	public void startGame() {
		game.startGame();
	}
}
