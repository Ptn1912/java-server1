package main;

import java.io.IOException;

import javax.swing.SwingUtilities;

import client.Client;
import view.SignIn;

public class RunClient {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Client client = new Client();
            	try {
					client.startClient() ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                SignIn run = new SignIn(client);
            }
        });
	}
}
