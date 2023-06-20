package model;

import java.util.ArrayList;
import java.util.List;
import client.ThreadClient;
import server.ServerThread;

public class WaitRoomModel {
	private int id;
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
	
	public void broadcastMessage(ServerThread sender, String message) {
        for (ServerThread client : clients) {
            if (client != sender) {
                client.sendMessage("Client " + String.valueOf(sender.getPort()) + ": " + message);
            }
        }
    }
}
