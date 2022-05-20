package serverHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler extends Thread{
	
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public Handler(Socket s) {
		this.client = s;
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
		}catch (IOException e) {
			e.printStackTrace();
			this.interrupt();
		}
	}
	
		
	//Getters
		
	//Setters
		
	//Functionality
		
	public void closeConnection() {
		try {
			client.close();
			writer.close();
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		writer.println(msg);
		writer.flush();	
		System.out.println("Server Sending: " + msg);
	}
	
	public String readFromClient() {
		String msg = "";
		try {
			msg = reader.readLine();
			notify();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
