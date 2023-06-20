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
    private String signal;
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
    }

	@Override
    public void run() {
        try {
            dip = new DataInputStream(socket.getInputStream());
            dop = new DataOutputStream(socket.getOutputStream());
            
            String receivedSignal = dip.readUTF();
  
            if(receivedSignal.equals("login") || receivedSignal.equals("register")) {
            	this.signal = receivedSignal; 
                if(signal .equals("login")) {
                	this.userName = dip.readUTF();
                    this.password = dip.readUTF();
                }else if(signal.equals("register")) {
                	this.email = dip.readUTF();
                	this.tdn = dip.readUTF();
                	this.tnd = dip.readUTF();
                	this.mk = dip.readUTF();
                	this.mkagain = dip.readUTF();
                }

                String check = "";
                String tnd = "";
                if(signal.equals("login")) {
                	AccountDAO account = new AccountDAO(userName, password);
                	account.checkLogin();
                	check = account.getResult();
                	tnd = account.getResultTND();
                }else if(signal.equals("register")) {
                	AccountDAO account = new AccountDAO(email, tdn, tnd, mk, mkagain);
                	check = account.checkSignup();
                }
                System.out.println(check + " " + tnd);
                dop.writeUTF(check);
                dop.writeUTF(tnd);
            }else if(receivedSignal.matches("[1-8]")) {
            	this.signalRoom = "JOIN " + receivedSignal;
                System.out.println(signalRoom);
                boolean shouldContinue = true;
                while(shouldContinue) {
                	String[] tokens = signalRoom.split(" ");
                	if(tokens.length == 2 && tokens[0].equals("JOIN")) {
                		int idRoom = Integer.parseInt(tokens[1]);
                		if(idRoom >= 1 && idRoom <= 8) {
                			WaitRoomModel waitRoom = waitRooms.get(idRoom - 1);
                			synchronized (waitRoom) {
    							if(waitRoom.isFull()) {
    								dop.writeUTF("full");;
    							}else {
    								waitRoom.addClient(this);
    								currentWaitRoom = waitRoom;
    								dop.writeUTF("success");
    								System.out.println("chao mung tham gia phong" + idRoom);
    							}
    							
    						}
                		}
                	}else if (currentWaitRoom != null) {
                		currentWaitRoom.broadcastMessage(this, signalRoom);
                    }
                	signalRoom = null;

                    if (signalRoom == null) {
                        shouldContinue = false; // Thoát khỏi vòng lặp nếu signalRoom là null
                    }
                }
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
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