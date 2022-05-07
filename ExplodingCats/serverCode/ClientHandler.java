package serverCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler implements Runnable {
	
	@SuppressWarnings("unused")
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	@SuppressWarnings("unused")
	private String name;
	public ClientHandler(Socket client) throws IOException {
		this.client = client;
		reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
	}
	@Override
	public void run() {
		while (true) {
			String msgFromClient;
			try {
				msgFromClient = reader.readLine();
				System.out.println("Client: " + msgFromClient);
				writer.write("Your message has been recieved");
				writer.flush();
				
				if (msgFromClient.equalsIgnoreCase("BYE")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
