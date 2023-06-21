package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import client.Client;
import client.ThreadClient;
import view.MainPage;
import view.Rank;
import view.SignIn;
import view.StartServer;

public class ChooseSignInController implements Controller{
	private JFrame chooseSignIn;
	private JButton btnAdmin, btnUser;
	
	public ChooseSignInController(JButton btnAdmin, JButton btnUser, JFrame chooseSignIn) {
		this.btnAdmin = btnAdmin;
		this.btnUser = btnUser;
		this.chooseSignIn = chooseSignIn;
	}
	
	public void setEvent(){
		btnAdmin.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				StartServer signInServer = new StartServer();
				chooseSignIn.dispose();
			}
		});
		
		btnUser.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				SignIn signIn = new SignIn(client);
				chooseSignIn.dispose();
			}
		});
	}
	
	public void doCallback(ThreadClient thClient) {
		
	}
	
	private Client client;
	public void doSetClient(Client client) {
		this.client = client;
	}
}
