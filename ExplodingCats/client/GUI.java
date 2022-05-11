import javax.swing.*;
import java.awt.event.*;
public class GUI implements ActionListener{
	
	
	JFrame frame = new JFrame("Exploding Daub");
	
	public GUI 
	public void startApplication() {
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JButton startButton = new JButton("Start Game");
		{}
		frame.getContentPane().add(startButton);
		startButton.addActionListener(this);
		
		
	}
	public void gameApp() {
		JFrame game = new JFrame("Exploding Daub");
		game.setVisible(true);
		game.setSize(1600,1200);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
	}
	
}
