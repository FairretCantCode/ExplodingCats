import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import serverCode.Message;

public class Client extends Thread {
	private int port;
	private String ipAddress;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	private String name;
	public Client(int p, String ip) {
		this.port = p;
		this.ipAddress = ip;
	
	}
	//Getters
	
	//Setters
	
	public void setNameOfPlayer(String n) {
		name = n;
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
	
	@Override
	public void run(){
		//Sends the name
		writer.println(name);
		writer.flush();
		Scanner scan = new Scanner(System.in);
		while(true) {
			 
	
			
		}
		scan.close();
	}
	
}
