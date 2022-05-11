import java.awt.event.*;

public class User implements ActionListener{
	
	private String name;
	private Client client;
	private GUI gui;
	
	public User() {
		gui = new GUI();
		
		
	}
	
	public void launch() {
		gui.startApp();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game":
			int PORT = gui.getPort();
			String ip = gui.getIp();
			client = new Client(PORT, ip);
			client.startConnection();
		}
		
	}
	
}