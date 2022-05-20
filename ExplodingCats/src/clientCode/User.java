package clientCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import clientCode.clientHandler.playClient;
import clientCode.clientHandler.startClient;
import clientCode.clientHandler.updateClient;

public class User implements ActionListener{
	
	private playClient play_Client;
	private updateClient update_Client;
	private startClient start_Client;
	
	private StartMenu gui;
	private GameScreen gui2;
	private ExecutorService pool;
	
	private int port;
	private String ip;
	
	public User(int port, String ip) {
		this.port = port;
		this.ip = ip;
		start_Client = new startClient(port, ip);
		pool = Executors.newFixedThreadPool(3);
	}
	
	public void launch() {
		gui = new StartMenu(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game":
			start_Client.setName(gui.getNameEntered());
			start_Client.startConnection();
			gui.guiDelete();
			gui2 = new GameScreen(this);
			
			update_Client = new updateClient(port+1, ip, gui2);
			update_Client.startConnection();
			
			play_Client = new playClient(port + 2, ip);
			play_Client.startConnection();
			
			pool.execute(start_Client);
			pool.execute(update_Client);
			pool.execute(play_Client);
		}
		
	}

}
