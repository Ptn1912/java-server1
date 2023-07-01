package model;

import java.util.ArrayList;
import java.util.List;
import client.ThreadClient;
import server.ServerThread;

public class WaitRoomModel {
	private int id;
	private boolean white = true;
	private boolean black = true;
	private List<ServerThread> clients;
	
	public WaitRoomModel(int id) {
		this.id = id;
		clients = new ArrayList<>();
	}
	
	public boolean isFull() {
	    return clients.size() >= 2;
	}
	
	public void addClient(ServerThread client) {
		clients.add(client);
	}
	
	public void removerClient(ServerThread client) {
		clients.remove(client);
	}
	
	public int getClientCount() {
        return clients.size();
    }
	
	public String checkColor() {
		if(white) {
			return "white";
		}else {
			return "black";
		}
	}
	
	public void setColor(boolean white, boolean black) {
		this.white = white;
		this.black = black;
	}
	
	public boolean getWhite() {
		return white;
	}
	
	public boolean getBlack() {
		return black;
	}
	
	public void broadcastMessage(ServerThread sender, String message) {
        for (ServerThread client : clients) {
            if (client != sender) {
                client.sendMessage("Client " + String.valueOf(sender.getPort()) + ": " + message);
            }
        }
    }
}
