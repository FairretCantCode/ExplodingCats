import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;
import java.awt.event.*;
public class StartMenu {
	//https://www.youtube.com/watch?v=Kmgo00avvEw
	private JFrame frame;
	private String nameEntered;
	private User parent;
	
	private final Action action = new SwingAction();
	private JTextField textField;
	
	public StartMenu(User p) {
		parent = p;
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
		
		JButton startButton = new JButton("start game");
		startButton.setBounds(70, 200, 200, 50);
		startButton.addActionListener(p);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameEntered = textField.getText();
				//setName(textField.getText());
				
				
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
		frame.repaint();
	}
	

	public void guiDelete() {
		frame.dispose();
	}
	//Getters
	
	public String getName() {
		return nameEntered;
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
