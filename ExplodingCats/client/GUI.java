import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GUI implements ActionListener{
	//https://www.youtube.com/watch?v=Kmgo00avvEw
	
	private JFrame frame;
	private String ip;
	private int port;
	
	private ArrayList<Component> components;
	
	public GUI() {
		frame = new JFrame("Exploding Daub");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null);
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
		Border boarder = BorderFactory.createLineBorder(new Color(0xFF5733));
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(this);
		startButton.setActionCommand("start game");
		startButton.setVisible(true);
		components.add(startButton);
		JLabel title = new JLabel("Exploding Daub!!!");
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setVerticalTextPosition(JLabel.TOP);
		title.setForeground(new Color(0xFF5733));
		title.setFont(new Font("Comic Sans", Font.ITALIC, 40));
		title.setBackground(Color.GRAY);
		title.setOpaque(true);
		title.setBorder(boarder);
		title.setVerticalAlignment(JLabel.TOP);
		title.setHorizontalAlignment(JLabel.CENTER);
		//title.setBounds(0,0,250,250);
		components.add(title);
		
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
