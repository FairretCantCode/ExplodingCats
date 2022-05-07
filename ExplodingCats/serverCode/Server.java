package serverCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	//Socket Stuff
	private int port;
	private ServerSocket sSocket;
	
	//Game Stuff
	private ArrayList<ClientHandler> clients;
	private ExecutorService pool;
	
	public Server(int portNum) throws IOException {
		port = portNum;
		clients = new ArrayList<ClientHandler>();
		sSocket = new ServerSocket(port);
		pool = Executors.newFixedThreadPool(4);
	}
	
	public void start() throws IOException {
		
		while(true) {
			System.out.println(clients.size());
			ClientHandler client = new ClientHandler(sSocket.accept());
			clients.add(client);
			pool.execute(client);
		}

	}
	public void close() throws IOException {
		sSocket.close();
		pool.shutdown();
	}
}
