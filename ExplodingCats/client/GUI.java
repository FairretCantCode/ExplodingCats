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
	private final Action action = new SwingAction();
	private JTextField textField;
	
	public GUI() {
		Border boarder = BorderFactory.createLineBorder(new Color(0xFF5733));
		
		
		frame = new JFrame("Exploding Daub");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(240, 150, 350, 300);
		panel.setBackground(Color.GRAY);
		panel.setBorder(boarder);
		frame.getContentPane().add(panel);
		
		JButton startButton = new JButton("Join Game");
		startButton.setBounds(70, 200, 200, 50);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				//setName(textField.getText());
				panel.setVisible(false);
				GUI2.startApp();
			}
		});
		startButton.setFont(new Font("Comic Sans", Font.ITALIC, 10));
		panel.setLayout(null);
		
		JLabel title = new JLabel("Exploding daub!!!");
		title.setFont(new Font("Comic Sans", Font.ITALIC, 30));
		title.setForeground(new Color(0xFF5733));
		title.setBounds(39, 11, 264, 48);
		title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(title);
		panel.add(startButton);
		
		textField = new JTextField("(Name)");
		textField.setBounds(70, 104, 200, 50);
		textField.setHorizontalAlignment(JLabel.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setEditable(true);
		textField.setVisible(true);
		components = new ArrayList<Component>();
		frame.repaint();
	}
	
	//Useful functions
	public void placeComponents() {
		for (Component c: this.components) {
			this.frame.getContentPane().add(c);
		}
	}
	
	public void removeComponents() {
		for (Component c: this.frame.getComponents()) {
			frame.remove(c);
		}
	}
	
	public void startApp() {
		
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
