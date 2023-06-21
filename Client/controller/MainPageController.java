package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

import client.Client;
import client.ThreadClient;
import view.*;

public class MainPageController implements Controller{
	private JFrame mainPage;
	private JButton btnRank, btnMode, btnGuide, btnExit;
	
	public MainPageController(JButton btnRank, JButton btnMode, JButton btnGuide, JButton btnExit, JFrame mainPage) {
		this.btnRank = btnRank;
		this.btnMode = btnMode;
		this.btnGuide = btnGuide;
		this.btnExit = btnExit;
		this.mainPage = mainPage;
	}
	
	public void setEvent() {
		btnRank.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnRank.setBackground(new Color(183, 110, 34));
				btnRank.setForeground(new Color(255,255,255));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnRank.setBackground(new Color(245, 188, 66));
				btnRank.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				Rank jframeRank = new Rank();
				mainPage.dispose();
			}
		});
		
		btnMode.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnMode.setBackground(new Color(183, 110, 34));
				btnMode.setForeground(new Color(255,255,255));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnMode.setBackground(new Color(245, 188, 66));
				btnMode.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ModePlay jframeModePlay = new ModePlay(client);
				mainPage.dispose();
			}
		});
		
		btnGuide.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnGuide.setBackground(new Color(183, 110, 34));
				btnGuide.setForeground(new Color(255,255,255));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnGuide.setBackground(new Color(245, 188, 66));
				btnGuide.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				Guide jframeGuide = new Guide();
				mainPage.dispose();
				
			}
		});
		
		btnExit.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnExit.setBackground(new Color(183, 110, 34));
				btnExit.setForeground(new Color(255,255,255));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnExit.setBackground(new Color(245, 188, 66));
				btnExit.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				System.exit(0);
				
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
