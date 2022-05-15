package serverCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler extends Thread {
	
	
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	private String name;
	
	public ClientHandler(Socket c){
		this.client = c;
		name = null;
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (name == null) {
			try {
				name = reader.readLine();
			}catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		//After registered into game
		try {
			 String line = reader.readLine();
	            while( line != null && line.length() > 0 )
	            {
	                writer.println( "Echo: " + line);
	                writer.flush();
	                
	                line = reader.readLine();
	            }

	            // Close our connection
	            reader.close();
	            writer.close();
	            client.close();

	            System.out.println( "Connection closed" );
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getNameOfPlayer() {
		return name;
	}
	
	
	public String askForCard() {
		try {
			send("play a card");
			return reader.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendShownCard(String c) {	
		send("show " + c);
	}
	
	public void send(String msg) {
		System.out.println("sending " + msg);
		writer.println(msg);
		writer.flush();	
	}
}
