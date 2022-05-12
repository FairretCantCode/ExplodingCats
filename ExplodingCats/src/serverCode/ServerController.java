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
		server = new Server(4555);
	}
	
	public void lanuch() {
		panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.gray);  
        JButton b1=new JButton("Start Game");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        b1.setActionCommand("start game");
        b1.addActionListener(this);
        JButton b2=new JButton("Start Server");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);
        b2.addActionListener(this);
        b2.setActionCommand("start server");
        JButton b3 = new JButton("End Server");
        b3.setBounds(100,100,80,30);    
        b3.setBackground(Color.red);
        b3.addActionListener(this);
        b3.setActionCommand("stop server");
        
        panel.add(b1); 
        panel.add(b2);  
        panel.add(b3);
        frame.add(panel);  
        frame.setSize(400,400);    
        frame.setLayout(null);    
        frame.setVisible(true);    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "start game":
			server.startGame();
			System.out.println("Starting game");
			break;
		case "start server":
			server.startServer();
			System.out.println("Starting server");
			break;
		case "stop server":
			server.closeServer();
			break;
		}
		
	}
}
