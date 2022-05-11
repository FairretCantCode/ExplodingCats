package serverCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler extends Thread {
	
	
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	private String name;
	
	public ClientHandler(Socket client){
		this.client = client;
		name = null;
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (name == null) {
			try {
				if (reader.readLine().equals("hi")){
					writer.println("state your name");
					name = reader.readLine();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		//After registered into game
		
		
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
