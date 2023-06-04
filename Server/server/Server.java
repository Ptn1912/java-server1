package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
	private ServerSocket serverSocket;
	private boolean isServerRunning;

	public void startServer() throws IOException {
	    serverSocket = new ServerSocket(9500);
	    isServerRunning = true;
	    System.out.println("da chay server thanh cong");
	    try {
	        while (isServerRunning) {
	            Socket clientSocket = serverSocket.accept();
	            System.out.println("Một client mới đã kết nối: " + clientSocket);
	            ThreadServer threadServer = new ThreadServer(clientSocket);
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
