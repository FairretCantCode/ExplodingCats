package serverCode;

public class Main {

	public static void main(String[] args) {
		Server server = new Server(4999);
		server.startServer();
		System.out.println("Started");
		server.run();
		System.out.println("Starting game");
		server.makeGame();
		server.startGame();
		server.closeServer();
		System.out.println("Closed");
		
		
	}

}
