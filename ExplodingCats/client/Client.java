import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import serverCode.Message;

public class Client extends Thread {
	private int port;
	private String ipAddress;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private String name;
	private GameScreen gameScreen;
	
	public Client(int p, String ip) {
		this.port = p;
		this.ipAddress = ip;
	
	}
	//Getters
	
	//Setters
	
	public void setNameOfPlayer(String n) {
		name = n;
	}
	
	public void setGameScreen(GameScreen g) {
		gameScreen = g;
	}
	
	//Functionality Methods
	
	public void startConnection() {
		try {
			socket = new Socket(ipAddress, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		}catch (IOException e) {
			System.out.println("Can't connect");
		}
	}
	
	public void updateInfo() {
		updatePlayerList();
		
	}
	
	public void updatePlayerList() {
		
		try{
			ArrayList<String> give = new ArrayList<String>();
			this.send(Message.GETPLAYERS);
			String players = reader.readLine();
			while (players.indexOf("|") > 0) {
				give.add(players.substring(0,players.indexOf("|")));
				players = players.substring( players.indexOf("|")+ 1, players.length());
			}
			gameScreen.updateNames(give);
		} catch (Exception e) {
			
		}
		
	}
	
	@Override
	public void run(){
		//Sends the name
		writer.println(name);
		writer.flush();
		
		String line;
		
		try {
			readLoop: while(true) {
				line = reader.readLine(); 
				
				updateInfo();
				switch (line) {
				
				
				case Message.QUITCONNECTION:
					gameScreen.guiDelete();
					
					break readLoop;
				}
				updateInfo();
			}
			socket.close();
			writer.close();
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	
	private void send(String m) {
		writer.println(m);
		writer.flush();
		System.out.println("Sending: " + m);
	}
	
}
