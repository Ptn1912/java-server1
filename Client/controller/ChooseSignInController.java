package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.Rank;
import view.SignIn;
import view.StartServer;

public class ChooseSignInController {
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
				SignIn signIn = new SignIn();
				chooseSignIn.dispose();
			}
		});
	}
}
