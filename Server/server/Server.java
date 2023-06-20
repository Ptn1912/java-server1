package server;

import java.io.IOException; 
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import model.WaitRoomModel;

public class Server {

    public static volatile ServerThreadBus serverThreadBus;
    private ServerSocket serverSocket;
	private List<WaitRoomModel> waitRooms;
	private boolean isServerRunning;
	
	public void startWaitRoom() {
		waitRooms = new ArrayList<>();
		for(int i=1; i<=8; ++i) {
			waitRooms.add(new WaitRoomModel(i));
		}
	}

	public void startServer() throws IOException {
	    serverSocket = new ServerSocket(9500);
	    int clientNumber = 0;
	    startWaitRoom();
	    isServerRunning = true;
	    System.out.println("da chay server thanh cong");
	    try {
	        while (isServerRunning) {
	            Socket clientSocket = serverSocket.accept();
	            System.out.println("Một client mới đã kết nối: " + clientSocket);
	            ServerThread threadServer = new ServerThread(clientSocket, waitRooms, clientNumber++);
	            serverThreadBus.add(threadServer);
                System.out.println("Số thread đang chạy là: "+serverThreadBus.getLength());
	            threadServer.start();
	        }
	    } catch (SocketException e) {
	        // SocketException xảy ra khi ServerSocket bị đóng, không cần xử lý lỗi ở đây
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void stopServer() {
	    isServerRunning = false;
	    if (serverSocket != null && !serverSocket.isClosed()) {
	        try {
	            serverSocket.close();
	            System.out.println("Server da dung");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
}