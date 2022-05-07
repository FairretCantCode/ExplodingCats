package serverCode;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Server server = new Server(4999);
		server.start();
		
		Scanner scanner = new Scanner(System.in);
		if (scanner.nextLine().equalsIgnoreCase("quit")) {
			server.close();
			System.out.println("Closign server");
			scanner.close();
		}
		System.out.println("Somehow Here");
		
		
	}

}
