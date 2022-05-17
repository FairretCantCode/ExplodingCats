import java.awt.event.*;

public class User implements ActionListener{
	
	private String name;
	private Client client;
	private StartMenu gui;
	private GameScreen gui2;
	
	public User(int port, String ip) {
		client = new Client(port, ip);
		
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
			client.run();
		}
		
	}
	public void setName(String s) {
		name = s;
	}
	
}
