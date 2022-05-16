import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

//import GUI.SwingAction;

import java.util.*;
import java.awt.event.*;
public class GameScreen implements ActionListener{
		
		private JFrame frame2;
		private String ip;
		private int port;
		private final Action action = new SwingAction();
		private User parent; 
		private ArrayList<String> mumsie = new ArrayList<String>();

	/**
	 * @wbp.parser.entryPoint
	 */
	public GameScreen(User p)  {
		parent = p;
		frame2 = new JFrame("Exploding Daub");
		frame2.getContentPane().setBackground(Color.GRAY);
		frame2.setVisible(true);
		frame2.setSize(800, 600);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 11, 117, 342);
		frame2.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 394, 615, 156);
		frame2.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(561, 28, 213, 284);
		frame2.getContentPane().add(lblNewLabel_1);

		
		
	}

	//getters
	
	public int getPort() {
		return port;
	}
	public String getIp() {
		return ip;
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game": 
			
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
	
