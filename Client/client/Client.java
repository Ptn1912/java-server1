package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
	private String userName, password;
	
	public Client(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public void startClient() throws IOException {
		Socket socket = new Socket("localhost", 8080);
		
		ThreadClient threadClient = new ThreadClient(socket, userName, password);
        threadClient.start();
	}
	
//	public static void main(String[] args) throws IOException {
//		Socket socket = new Socket("localhost", 8080);
//		
//		System.out.println(userName + " " + password);
//		
//		ThreadClient threadClient = new ThreadClient(socket);
//        threadClient.start();
//	}
}
