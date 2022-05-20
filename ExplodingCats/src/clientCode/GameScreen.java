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
		JPanel handPanel = new JPanel();
		JLabel nameList = new JLabel("Downloading virus...");
		
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
		
		
		handPanel.setBounds(60, 394, 615, 156);
		frame2.getContentPane().add(handPanel);
		
		JLabel currentCard = new JLabel("");
		currentCard.setBackground(Color.GRAY);
		currentCard.setIcon(new ImageIcon(GameScreen.class.getResource("/Assets/explodingKitten(1).jpg.png")));
		currentCard.setBounds(561, 28, 213, 284);
		frame2.getContentPane().add(currentCard);
		
		JButton btnNewButton = new JButton("End Turn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
			}
		});
		btnNewButton.setBounds(685, 411, 89, 23);
		frame2.getContentPane().add(btnNewButton);
		
		
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
	public void updateHand(String s) {
		ArrayList<String> cards = new ArrayList<String>();
		while (s.indexOf(",") > 0) {
			cards.add(s.substring(0, s.indexOf(",")));
			s = s.substring(s.indexOf(",") + 1);
		}
		for (String es: cards) {
			handPanel.add(new JButton(es));
		}
		
		
	}
}
	
