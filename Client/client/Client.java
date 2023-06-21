package client;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.conf.url.SingleConnectionUrl;

import controller.Controller;

public class Client {
    private Socket socket;
    private ThreadClient threadClient;
    private Controller ctrl;
    public Client() {
    }
    
    public void setCtrl (Controller ctrl) {
    	this.ctrl = ctrl;
    	threadClient.setCtrl(ctrl);
    }
    
    public void startClient() throws IOException {
        if (socket == null) {
            socket = new Socket("localhost", 9500);
        }

        this.threadClient = new ThreadClient(socket);
        threadClient.start();
    }

    public void doSendSignal (String signal, String ... content) throws Exception{
    	this.threadClient.doSendSignal(signal, content);
    }
    
    public String getResult() {
        return threadClient.getResult();
    }
    
    public String getResultRoom() {
    	return threadClient.getResultRoom();
    }
    
    public String getResultTND() {
        return threadClient.getResultTND();
    }
}