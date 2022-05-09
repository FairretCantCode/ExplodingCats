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
	
	public Client(int p, int ip) {
		this.port = p;
		this.ipAddress = ip;
	
	}
	
	public void startConnection() {
		try {
			socket = new Socket(ipAddress, port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		while(true) {
			try {
				System.out.println(reader.readLine());
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
