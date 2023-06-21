package controller;

import client.Client;
import client.ThreadClient;

public interface Controller {
	public void doSetClient(Client client);
	public void doCallback(ThreadClient clientThread);
}
