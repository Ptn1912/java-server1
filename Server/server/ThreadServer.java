package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import dao.AccountDAO;

public class ThreadServer extends Thread {
    private Socket socket;
    private String userName, password;
    private String email, tdn, tnd, mk;

    public ThreadServer(Socket socketClient) {
        this.socket = socketClient;
    }

    @Override
    public void run() {
        try {
            DataInputStream dip = new DataInputStream(socket.getInputStream());
            DataOutputStream dop = new DataOutputStream(socket.getOutputStream());

            String userName = dip.readUTF();
            String password = dip.readUTF();
            String email = dip.readUTF();
            String tdn = dip.readUTF();
            String tnd = dip.readUTF();
            String mk = dip.readUTF();
            this.userName = userName;
            this.password = password;
            this.email = email;
            this.tdn = tdn;
            this.tnd = tnd;
            this.mk = mk;

            String check;
            AccountDAO account = new AccountDAO(userName, password);
            check = account.checkLogin();
            dop.writeUTF(check);

            String kt;
            AccountDAO ac = new AccountDAO(email, tdn, tnd, mk);
            kt = ac.checkSignup();
            dop.writeUTF(kt);

           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}