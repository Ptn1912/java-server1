package client;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.conf.url.SingleConnectionUrl;

public class Client {
    private String userName, password;
    private String email, tdn, tnd, mk, mkagain;
    private String signal;
    private String result;
    private ThreadClient threadClient;
    
    public Client(String userName, String password, String signal) {
        this.userName = userName;
        this.password = password;
        this.signal = signal;
    }
    
    public Client(String email, String tdn, String tnd, String mk, String mkagain, String signal) {
        this.email = email;
        this.tdn = tdn;
        this.tnd = tnd;
        this.mk = mk;
        this.mkagain = mkagain;
        this.signal = signal;
    }
    
	public void startClient() throws IOException {
        Socket socket = new Socket("localhost", 9200);
        
        if(signal.equals("login")) {
        	this.threadClient = new ThreadClient(socket, userName, password, signal);
        }else if(signal.equals("register")) {
        	this.threadClient = new ThreadClient(socket, email, tdn, tnd, mk, mkagain, signal);
        }
        threadClient.start();
        try {
            threadClient.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        result = threadClient.getResult();
    }

    public String getResult() {
        return result;
    }
}



