package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.mysql.cj.conf.url.SingleConnectionUrl;

import dao.AccountDAO;

public class ThreadServer extends Thread {
    private Socket socket;
    private String userName, password;
    private String signal;
    private String email, tdn, tnd, mk, mkagain;

    public ThreadServer(Socket socketClient) {
        this.socket = socketClient;
    }

    @Override
    public void run() {
        try {
            DataInputStream dip = new DataInputStream(socket.getInputStream());
            DataOutputStream dop = new DataOutputStream(socket.getOutputStream());

            this.signal = dip.readUTF(); 
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
            if(signal.equals("login")) {
            	AccountDAO account = new AccountDAO(userName, password);
            	check = account.checkLogin();
            }else if(signal.equals("register")) {
            	AccountDAO account = new AccountDAO(email, tdn, tnd, mk, mkagain);
            	check = account.checkSignup();
            }
            System.out.println(check);
            dop.writeUTF(check);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}