package server;

import java.io.DataInputStream; 
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SecureCacheResponse;
import java.net.Socket;

import com.mysql.cj.conf.url.SingleConnectionUrl;

import dao.AccountDAO;
import model.WaitRoomModel;
import view.WaitRoom;

import java.util.*;
import java.util.regex.Matcher;

public class ServerThread extends Thread {
    private Socket socket;
    
    private String userName, password;
    private String email, tdn, tnd, mk, mkagain;
    
    private String signalRoom;
    private List<WaitRoomModel> waitRooms;
    private WaitRoomModel currentWaitRoom;
    private int clientNumber;
    private DataInputStream dip;
    private DataOutputStream dop;

    public ServerThread(Socket socketClient, List<WaitRoomModel> waitRooms,int clientNumber ) {
        this.socket = socketClient;
        this.waitRooms = waitRooms;
        this.clientNumber = clientNumber;
        try {
            dip = new DataInputStream(socket.getInputStream());
            dop = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
    public void run() {
        try {
            while(!socket.isClosed()) {
            	String receivedSignal = dip.readUTF();
            	  
                if(receivedSignal.equals("login") ) {
                	doLogin();
                
                }else if (receivedSignal.equals("register")) {
                	doRegister();
                	
                }else if(receivedSignal.matches("[1-8]")) {
                	doJoinRoom (receivedSignal);
                
                }else {
                	dop.writeUTF("svError");
                }
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	private void doLogin() throws Exception{
		this.userName = dip.readUTF();
		this.password = dip.readUTF();

		String check = "";
		String tnd = "";
		AccountDAO account = new AccountDAO(userName, password);
		account.checkLogin();
		check = account.getResult();
		tnd = account.getResultTND();

		System.out.println(check + " " + tnd);
		
		dop.writeUTF("svLogin");
		dop.writeUTF(check);
		dop.writeUTF(tnd);
		
	}
	
	private void doRegister() throws Exception{
		String check = "";
		String tnd = "";
		this.email = dip.readUTF();
		this.tdn = dip.readUTF();
		this.tnd = dip.readUTF();
		this.mk = dip.readUTF();
		this.mkagain = dip.readUTF();
		AccountDAO account = new AccountDAO(email, tdn, tnd, mk, mkagain);
		check = account.checkSignup();
		System.out.println(check + " " + tnd);
		
		dop.writeUTF("svRegister");
		dop.writeUTF(check);
		dop.writeUTF(tnd);
		
	}

	private void doJoinRoom(String numberRoom) throws Exception{
		int idRoom = Integer.parseInt(numberRoom);
		WaitRoomModel waitRoom = waitRooms.get(idRoom - 1);
		synchronized (waitRoom) {
			if(waitRoom.isFull()) {
				dop.writeUTF("svRoom");
				dop.writeUTF("full");
				currentWaitRoom = null;
			}else {
				waitRoom.addClient(this);
				currentWaitRoom = waitRoom;
				dop.writeUTF("svRoom");
				dop.writeUTF("success");
				System.out.println("chao mung tham gia phong" + idRoom);
			}
		}
		
		if (currentWaitRoom != null) {
			this.signalRoom = "JOIN " + numberRoom;
    		currentWaitRoom.broadcastMessage(this, signalRoom);
        }
	}
	
	public int getPort() {
        return socket.getPort();
    }
	
	public void sendMessage(String string) {
		System.out.println(string);
	}
	
	public void write(String message) throws IOException{
	        dop.writeUTF(message);
	        dop.flush();
	}
	
	public int getClientNumber() {
        return clientNumber;
    }

}