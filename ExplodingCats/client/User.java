
public class User {
	
	private String name;
	private Client client;
	private GUI gui;
	
	public User() {
		gui = new GUI();
		int PORT = 4999;
		String ip = "192.168.1.131";
		client = new Client(PORT, ip);
		
	}
	
	public void startGame() {
		client.startConnection();
		
		gui.startApplication();
		client.run();
	}
}
