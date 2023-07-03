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

	private boolean gameStarted = false;
    private String userName, password;
    private String email, tdn, tnd, mk, mkagain;
    private String ReTnd;
    private static int connectedClients = 0; // Thêm biến đếm số lượng client đã kết nối

    private String signalRoom;
    private String colorPlayer;
    private List<WaitRoomModel> waitRooms;
    private WaitRoomModel currentWaitRoom;
    private int clientNumber;
    private ServerThreadBus serverThreadBus;
    private Server server;
    private DataInputStream dip;
    private DataOutputStream dop;

    public ServerThread(Socket socketClient, List<WaitRoomModel> waitRooms,int clientNumber, ServerThreadBus serverThreadBus, Server server) {
        this.socket = socketClient;
        this.waitRooms = waitRooms;
        this.clientNumber = clientNumber;
        this.serverThreadBus = serverThreadBus;
        this.server = server;
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
            	if (dip.available() > 0) {
            		String receivedSignal = dip.readUTF();
              	  
                    if(receivedSignal.equals("login") ) {
                    	doLogin();
                    	
                    }else if (receivedSignal.equals("register")) {
                    	doRegister();
                    	
                    }else if(receivedSignal.matches("[1-8]")) {
                    	doJoinRoom (receivedSignal);
                    	 synchronized (waitRooms.get(Integer.parseInt(receivedSignal) - 1)) {
                             waitRooms.get(Integer.parseInt(receivedSignal) - 1).notifyAll(); // Thông báo cho tất cả các thread đang chờ
                         }
                    }else if(receivedSignal.matches("[1-8] l")) {
                    	String[] idRooms = receivedSignal.split(" ");
                    	doLeaveRoom(idRooms[0]);
                    	
                    }else if(receivedSignal.equals("getCount")) {
                    	dop.writeUTF("svCount");;
                    	dop.writeUTF(getCountPlayer());
                    	
                    }else if(receivedSignal.equals("close")) {
                    	doCloseApp();
                    }else {
                    	dop.writeUTF("svError");
                    }
            	}
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // Giảm giá trị của connectedClients sau khi một client đã ngắt kết nối
            connectedClients--;
        }
    }
	
	
	private void doLogin() throws Exception{
		this.userName = dip.readUTF();
		this.password = dip.readUTF();

		String check = "";
		tnd = "";
		AccountDAO account = new AccountDAO(userName, password);
		account.checkLogin();
		check = account.getResult();
		this.ReTnd = account.getResultTND();

		System.out.println(check + " " + ReTnd);
		
		dop.writeUTF("svLogin");
		if(server.addNameList(ReTnd)) {
			dop.writeUTF(check != null ? check : ""); // Kiểm tra giá trị của check trước khi ghi
			dop.writeUTF(ReTnd != null ? ReTnd : ""); // Kiểm tra giá trị của tnd trước khi ghi
		}else {
			dop.writeUTF("online");
			dop.writeUTF("");
		}
		
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

	private void doJoinRoom(String numberRoom) throws Exception {
	    int idRoom = Integer.parseInt(numberRoom);
	    WaitRoomModel waitRoom = waitRooms.get(idRoom - 1);
	    synchronized (waitRoom) {
	       while (waitRoom.isFull()) {
	        	waitRoom.wait();
	        } 
	            waitRoom.addClient(this);

	            if (waitRoom.getClientCount() == 1) {
	                // Nếu chỉ có một người chơi trong phòng, gán màu sắc cho người chơi này là màu trắng
	                boolean white = true;
	                waitRoom.setColor(white, false);
	                colorPlayer = "white";
	            } else {
	                // Nếu đã đủ hai người chơi, xác định màu sắc cho người chơi thứ hai
	                boolean white = waitRoom.getWhite(); // Lấy màu sắc của người chơi đầu tiên
	                boolean black = !white; // Đảo ngược màu sắc để gán cho người chơi thứ hai
	                waitRoom.setColor(white, black);
	                colorPlayer = "black";
	            }

	            currentWaitRoom = waitRoom;
	            dop.writeUTF("svRoom");
	            dop.writeUTF("success");
	            dop.writeUTF(colorPlayer);

	            System.out.println("Chào mừng tham gia phòng " + idRoom);

	            if (waitRoom.getClientCount() == 2) {
	                // Gửi tín hiệu cho cả hai client để bắt đầu trò chơi
	            	 waitRoom.notifyAll();
	                waitRoom.broadcastMessage("startGame");
	            }
	        }
	    }
	

	private void doLeaveRoom(String numberRoom) throws Exception{
		this.colorPlayer = dip.readUTF();
		int idRoom = Integer.parseInt(numberRoom);
		WaitRoomModel waitRoom = waitRooms.get(idRoom - 1);
		synchronized (waitRoom) {
		    if (colorPlayer.equals("white")) {
		        boolean white = true;
		        boolean black = waitRoom.getBlack();
		        waitRoom.setColor(white, black);
		    } else {
		        boolean white = waitRoom.getWhite();
		        boolean black = true;
		        waitRoom.setColor(white, black);
		    }
		    waitRoom.removerClient(this);
		    System.out.println("Đã thoát khỏi phòng " + idRoom);

		     // Giảm số lượng client khi có một client thoát khỏi phòng
		}
	}
	
	public void doCloseApp() {
		server.removeNameList(ReTnd);
		server.printNameList();
		serverThreadBus.remove(this);
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