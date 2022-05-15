import java.awt.event.*;

public class User implements ActionListener{
	
	private String name;
	private Client client;
	private GUI gui;
	
	public User(int port, String ip) {
		gui = new GUI(this);
		client = new Client(port, ip);
		
	}
	
	public void launch() {
		gui.startApp();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game":
			System.out.println("here");
			client.startConnection();
			client.setName(gui.getName());
			client.run();
		}
		
	}
	public void setName(String s) {
		name = s;
	}
	
}
