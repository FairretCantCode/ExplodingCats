import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI implements ActionListener{
	
	
	private JFrame frame;
	private String ip;
	private int port;
	
	private ArrayList<Component> components;
	
	public GUI() {
		frame = new JFrame("Exploding Daub");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		components = new ArrayList<Component>();
	}
	
	//Useful functions
	public void placeComponents() {
		for (Component c: this.components) {
			this.frame.add(c);
		}
	}
	
	public void removeComponents() {
		for (Component c: this.frame.getComponents()) {
			frame.remove(c);
		}
	}
	
	public void startApp() {
		
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(this);
		startButton.setActionCommand("start game");
		components.add(startButton);
		placeComponents();
	}
	public void gameApp() {
		
		
		
	}
	
	//Getters
	public int getPort() {
		return port;
	}
	public String getIp() {
		return ip;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game": 
			gameApp();
		}
		
	
	}
	
}
