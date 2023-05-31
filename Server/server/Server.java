package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8200);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Mot client moi da ket noi: " + clientSocket);
            ThreadServer threadServer = new ThreadServer(clientSocket);
            threadServer.start();
        }
    }
}
