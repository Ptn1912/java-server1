package controller;

import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import client.Client;
import client.ThreadClient;

import java.awt.Color;
import java.awt.Panel;

import view.*;

public class RankController implements Controller{
	private JFrame rank;
	private JButton btnHome;

	public RankController(JButton btnHome, JFrame rank) {
		this.btnHome = btnHome;
		this.rank = rank;
	}

	public void setEvent() {
		btnHome.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnHome.setBackground(new Color(255,102,0));
				btnHome.setForeground(new Color(255,255,255));

			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnHome.setBackground(new Color(250, 152, 87));
				btnHome.setForeground(new Color(0, 0, 0));

			}

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				MainPage jframeMainPage = new MainPage(client);
				rank.dispose();
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
