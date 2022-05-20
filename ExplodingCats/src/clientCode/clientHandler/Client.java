package clientCode.clientHandler;
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
	
	//Socket Stuff
	private int port;
	private String ipAddress;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public Client(int p, String ip) {
		this.port = p;
		this.ipAddress = ip;
	}
	//Getters
	
	//Setters
	


	
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
	
	public String readFromServer() {
		String msg = "";
		try {
			msg = reader.readLine();
			notify();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public void send(String m) {
		writer.println(m);
		writer.flush();
		System.out.println("Client Sending: " + m);
	}
	
	public void closeConnection() {
		try {
			socket.close();
			writer.close();
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
