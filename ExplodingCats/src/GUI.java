import javax.swing.*;

public class GUI {
	
	public void startApplication() {
		JFrame frame = new JFrame("Exploding Daub");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton startButton = new JButton("Start Game");
		frame.getContentPane().add(startButton);
	}
	
}
