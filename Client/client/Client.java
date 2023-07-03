package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.conf.url.SingleConnectionUrl;

import Messages.Message;
import piece.*;
import client.*;
import view.*;
import piece.Team;
import controller.Controller;

public class Client {
    private Socket socket;
    private ThreadClient threadClient;
    private Controller ctrl;
    private Team team = Team.NOCOLOR;
    public boolean isPaired = false;
    public GamePanel game;
    private DataInputStream dip;
	private DataOutputStream dop;
	 public Client() {
	        this.game = game;
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
    
    public String getSignalRoom() {
    	return threadClient.getSignalRoom();
    }
    
    public String getCountPlayer() {
    	return threadClient.getCountPlayer();
    }
    
    public void closeClient() throws IOException {
    	threadClient.closeClient();
    }
    
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    public void Send(Message msg) {
        try {
        	this.dop = new DataOutputStream(socket.getOutputStream());

            String messageString = msg.toString();
            this.dop.writeUTF(messageString);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	}

