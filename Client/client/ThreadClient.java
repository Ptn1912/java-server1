package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import controller.SignInController;
import view.SignIn;

public class ThreadClient extends Thread{
	private Socket socket;
	private String userName, password;
	
	public ThreadClient(Socket socket, String userName, String pasword) {
		this.socket = socket;
		this.userName = userName;
		this.password = pasword;
	}
	
	@Override
	public void run() {
		try {
			DataInputStream dip = new DataInputStream(socket.getInputStream());
			DataOutputStream dop = new DataOutputStream(socket.getOutputStream());
			
			dop.writeUTF(userName);
			dop.writeUTF(password);
			
			String receiver = dip.readUTF();
			
			SignInController control = new SignInController(receiver);
			
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
