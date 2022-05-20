package clientCode;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

//import GUI.SwingAction;

import java.util.*;
import java.awt.event.*;
public class GameScreen implements ActionListener{
		
		private JFrame frame2;
		private final Action action = new SwingAction();
		private User parent; 

	/**
	 * @wbp.parser.entryPoint
	 */
		JLabel nameList = new JLabel("Players: ");
		
	public GameScreen(User p)  {
		parent = p;
		frame2 = new JFrame("Exploding Daub");
		frame2.getContentPane().setBackground(Color.GRAY);
		frame2.setVisible(true);
		frame2.setSize(800, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		
		nameList.setBounds(0, 11, 117, 342);
		frame2.getContentPane().add(nameList);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 394, 615, 156);
		frame2.getContentPane().add(panel);
		
		JLabel currentCard = new JLabel("");
		currentCard.setBackground(Color.GRAY);
		currentCard.setIcon(new ImageIcon(GameScreen.class.getResource("/Assets/explodingKitten(1).jpg.png")));
		currentCard.setBounds(561, 28, 213, 284);
		frame2.getContentPane().add(currentCard);
		
		
	}

	public void updateNames(String e) {
		String mhm = "Players: " + e;
		nameList.setText(mhm);
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void guiDelete() {
		frame2.dispose();
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
	
