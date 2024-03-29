package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import client.Client;
import client.ThreadClient;
import view.*;

public class ModePlayController implements Controller{
	private JFrame modePlay;
	private JButton bntComputer, btnPlayer, btnHome;
	private ModePlayController self = this;
	
	public ModePlayController(JButton btnComputer, JButton btnPlayer, JButton btnHome, JFrame modePlay) {
		this.bntComputer = btnComputer;
		this.btnPlayer = btnPlayer;
		this.btnHome = btnHome;
		this.modePlay = modePlay;
	}
	
	public void setEvent() {
		bntComputer.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				bntComputer.setBackground(new Color(255,153,102));
				bntComputer.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				bntComputer.setBackground(new Color(227, 129, 79));
				bntComputer.setForeground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnPlayer.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnPlayer.setBackground(new Color(102,201,51));
				btnPlayer.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnPlayer.setBackground(new Color(81, 158, 41));
				btnPlayer.setForeground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					client.setCtrl(self);
					client.doSendSignal("getCount");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnHome.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnHome.setBackground(new Color(255, 228, 171));
				btnHome.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnHome.setBackground(new Color(224, 201, 153));
				btnHome.setForeground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				MainPage jframeMainPage = new MainPage(client);
				modePlay.dispose();
			}
		});
	}
	
	public void doCallback(ThreadClient thClient) {
		String countPlayer = client.getCountPlayer();
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            WaitRoom jframeWaitRoom = new WaitRoom(client, countPlayer);
	            modePlay.dispose();
	        }
	    });
	}
	
	private Client client;
	public void doSetClient(Client client) {
		this.client = client;
	}
}
