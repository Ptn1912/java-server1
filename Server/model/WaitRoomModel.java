package model;

import java.util.ArrayList;
import java.util.List;
import client.ThreadClient;
import server.ThreadServer;

public class WaitRoomModel {
	private int id;
	private List<ThreadServer> clients;
	
	public WaitRoomModel(int id) {
		this.id = id;
		clients = new ArrayList<>();
	}
	
	public boolean isFull() {
		return clients.size() >= 2;
	}
	
	public void addClient(ThreadServer client) {
		clients.add(client);
	}
	
	public void broadcastMessage(ThreadServer sender, String message) {
        for (ThreadServer client : clients) {
            if (client != sender) {
                client.sendMessage("Client " + sender.getPort() + ": " + message);
            }
        }
    }
}
