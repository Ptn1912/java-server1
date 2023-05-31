package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import dao.AccountDAO;

public class ThreadServer extends Thread {
    private Socket socketClient;

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

            AccountDAO account = new AccountDAO(userNameRec, passwordRec);
            boolean check = account.checkLogin();

            String result = check ? "OK" : "KO";

            dop.writeUTF(result);

            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

