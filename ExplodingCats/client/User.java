import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class User implements ActionListener{
	
	private String name;
	private Client client;
	private StartMenu gui;
	private GameScreen gui2;
	private ExecutorService pool;
	
	public User(int port, String ip) {
		client = new Client(port, ip);
		pool = Executors.newFixedThreadPool(1);
	}
	
	public void launch() {
		gui = new StartMenu(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game":
			client.startConnection();
			client.setName(gui.getName());
			gui.guiDelete();
			gui2 = new GameScreen(this);
			client.setGameScreen(gui2);
			pool.execute(client);
		}
		
	}
	public void setName(String s) {
		name = s;
	}
	
}
