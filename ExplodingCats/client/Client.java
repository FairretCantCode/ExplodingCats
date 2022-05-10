import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
	private int port;
	private String ipAddress;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public Client(int p, String ip) {
		this.port = p;
		this.ipAddress = ip;
	
	}
	
	public void startConnection() {
		try {
			socket = new Socket(ipAddress, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch (IOException e) {
			System.out.println("Can't connect");
		}
	}
	
	@Override
	public void run(){
		while(true) {
			try {
				String msgFromServer = reader.readLine();
				System.out.println(msgFromServer);
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
