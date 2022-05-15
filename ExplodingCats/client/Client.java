import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
			try {
				writer.println(scan.nextLine());
				String msgFromServer = reader.readLine();
				System.out.println(msgFromServer);
				if (msgFromServer.equals("quit")) {
					break;
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		scan.close();
	}
	public void setNameOfPlayer(String n) {
		name = n;
	}
}
