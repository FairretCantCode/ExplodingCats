package serverCode;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ServerController implements ActionListener {
	private Server server;
	
	private JPanel panel;
	private JFrame frame;
	public ServerController() {
		frame = new JFrame("Server Controller");
		panel = new JPanel();
	}
	
	public void lanuch() {
		panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.gray);  
        JButton b1=new JButton("Start Game");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        
        JButton b2=new JButton("Start Server");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);   
        panel.add(b1); panel.add(b2);  
        frame.add(panel);  
        frame.setSize(400,400);    
        frame.setLayout(null);    
        frame.setVisible(true);    
	}
}
