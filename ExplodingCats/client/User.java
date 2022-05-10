
public class User {
	
	private String name;
	private Client client;
	private GUI gui;
	
	public User() {
		gui = new GUI();
		int PORT = 4999;
		String ip = "localhost";
		client = new Client(PORT, ip);
		
	}
	
	public void startGame() {
		client.startConnection();
		gui.startApplication();
	}
}
