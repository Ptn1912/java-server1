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
    private String colorPlayer;
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
                	
                }else if(receivedSignal.matches("[1-8] l")) {
                	String[] idRooms = receivedSignal.split(" ");
                	doLeaveRoom(idRooms[0]);
                	
                }else if(receivedSignal.equals("getCount")) {
                	dop.writeUTF("svCount");;
                	dop.writeUTF(getCountPlayer());
                	
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
				String check = waitRoom.checkColor();
				if(check.equals("white")) {
					boolean white = false;
					boolean black = waitRoom.getBlack();
					waitRoom.setColor(white, black);
					colorPlayer = "white";
				}else {
					boolean white = waitRoom.getWhite();
					boolean black = false;
					waitRoom.setColor(white, black);
					colorPlayer = "black";
				}
				currentWaitRoom = waitRoom;
				dop.writeUTF("svRoom");
				dop.writeUTF("success");
				dop.writeUTF(colorPlayer);
				System.out.println("chao mung tham gia phong" + idRoom);
			}
		}
		
		if (currentWaitRoom != null) {
			this.signalRoom = "JOIN " + numberRoom;
    		currentWaitRoom.broadcastMessage(this, signalRoom);
        }
	}
	
	private void doLeaveRoom(String numberRoom) throws Exception{
		this.colorPlayer = dip.readUTF();
		int idRoom = Integer.parseInt(numberRoom);
		WaitRoomModel waitRoom = waitRooms.get(idRoom - 1);
		synchronized (waitRoom) {
			if(colorPlayer.equals("white")) {
				boolean white = true;
				boolean black = waitRoom.getBlack();
				waitRoom.setColor(white, black);
			}else {
				boolean white = waitRoom.getWhite();
				boolean black = true;
				waitRoom.setColor(white, black);
			}
			waitRoom.removerClient(this);
			System.out.println("da thoat khoi phong " + idRoom);
		}
		
		if (currentWaitRoom != null) {
			this.signalRoom = "JOIN " + numberRoom;
    		currentWaitRoom.broadcastMessage(this, signalRoom);
        }
	}
	
	public String getCountPlayer() {
		String result="";
		for(WaitRoomModel room : waitRooms) {
			String count = String.valueOf(room.getClientCount());
			result = result.concat(" ").concat(count);
		}
		return result;
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