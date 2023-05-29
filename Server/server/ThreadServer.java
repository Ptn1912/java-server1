package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import dao.AccountDAO;

public class ThreadServer extends Thread{
	private Socket socketClient;
	private String userName, password;
	
	
	public ThreadServer(Socket socketClient) {
		this.socketClient = socketClient;
	}
	
	@Override
	public void run() {
		try {
			DataInputStream dip = new DataInputStream(socketClient.getInputStream());
			DataOutputStream dop = new DataOutputStream(socketClient.getOutputStream());
			
			String userNameRec = dip.readUTF();
			String passwordRec = dip.readUTF();
			
			this.userName = userNameRec;
			this.password = passwordRec;
			
			AccountDAO account = new AccountDAO(userName, password);
			String check = account.checkLogin();
			
			dop.writeUTF(check);
			
			socketClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
