import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;
import java.awt.event.*;
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
		frame.setLayout(null);
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
		//frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(this);
		startButton.setActionCommand("start game");
		startButton.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400,300));
		panel.setBackground(Color.RED);
		panel.setLayout(new FlowLayout());
		panel.add(startButton);
		panel.setVisible(true);
		frame.add(panel);
		panel.revalidate();
		panel.repaint();
		/*JLabel title = new JLabel("Exploding Daub!!!");
		//title.setHorizontalTextPosition(JLabel.CENTER);
		//title.setVerticalTextPosition(JLabel.TOP);
		title.setForeground(new Color(0xFF5733));
		title.setFont(new Font("Comic Sans", Font.ITALIC, 40));
		title.setBackground(Color.GRAY);
		title.setOpaque(true);
		title.setBorder(boarder);
		title.setVerticalAlignment(JLabel.TOP);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(150,0,500,60);
		components.add(title);*/
		
		//components.add(startButton);
		//components.add(panel);
		//frame.setVisible(true);
		//placeComponents();
		//frame.repaint();
	}
	public void gameApp() {
		removeComponents();
		
		
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
