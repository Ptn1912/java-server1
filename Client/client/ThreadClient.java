package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.SignInControler;
import controller.SignUpController;
import view.SignIn;


public class ThreadClient extends Thread {
    private Socket socket;
    private String userName, password;
    private String email, tdn, tnd, mk, mkagain;
    private String signal;
    private String signalRoom;
    private String result, resultTND, resultRoom;
    
    public ThreadClient(Socket socket, String userName, String password, String signal) {
        this.socket = socket;
        this.userName = userName;
        this.password = password;
        this.signal = signal;
    }

    public ThreadClient(Socket socket, String email, String tdn, String tnd, String mk, String mkagain, String signal) {
        this.socket = socket;
        this.email = email;
        this.tdn = tdn;
        this.tnd = tnd;
        this.mk = mk;
        this.mkagain = mkagain;
        this.signal = signal;
    }
    
    public ThreadClient(Socket socket, String signalRoom) {
    	this.socket = socket;
    	this.signalRoom = signalRoom;
    }
    
	@Override
    public void run() {
        try {
            DataInputStream dip = new DataInputStream(socket.getInputStream());
            DataOutputStream dop = new DataOutputStream(socket.getOutputStream());
            
            if(signal != null) {
            	dop.writeUTF(signal);
                if(signal .equals("login")) {
                	dop.writeUTF(userName);
                    dop.writeUTF(password);
                }else if(signal.equals("register")) {
                	dop.writeUTF(email);
                	dop.writeUTF(tdn);
                	dop.writeUTF(tnd);
                	dop.writeUTF(mk);
                	dop.writeUTF(mkagain);
                }
                
                result = dip.readUTF();
                resultTND = dip.readUTF();
               
            }
            
            if(signalRoom != null) {
            	dop.writeUTF(signalRoom);
            	resultRoom = dip.readUTF();
            	System.out.println(resultRoom);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return result;
    }
    
    public String getResultRoom() {
    	return resultRoom;
    }
    
    public void setResultTND(String resultTND) {
    	this.resultTND = resultTND;
    }
    
    public String getResultTND() {
        return resultTND;
    }
    
}

