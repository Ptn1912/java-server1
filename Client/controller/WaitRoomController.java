package controller;

import java.awt.Color;

import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.Client;
import client.ThreadClient;
import piece.Team;
import view.GamePanel;
import view.ModePlay;
import view.*;
public class WaitRoomController implements Controller{
	private JFrame waitRoom;
	private JButton btnHome;
	private JPanel panel_room1, panel_room2, panel_room3, panel_room4, panel_room5, panel_room6, panel_room7, panel_room8;
	private WaitRoomController self = this;
	public WaitRoomController(JButton btnHome, JFrame waitRoom, JPanel panel_room1, JPanel panel_room2, JPanel panel_room3, JPanel panel_room4,
			 				  JPanel panel_room5, JPanel panel_room6, JPanel panel_room7, JPanel panel_room8) {
		this.btnHome = btnHome;
		this.waitRoom = waitRoom;
		this.panel_room1 = panel_room1;
		this.panel_room2 = panel_room2;
		this.panel_room3 = panel_room3;
		this.panel_room4 = panel_room4;
		this.panel_room5 = panel_room5;
		this.panel_room6 = panel_room6;
		this.panel_room7 = panel_room7;
		this.panel_room8 = panel_room8;
	}
	

	public void setEvent() {
		btnHome.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnHome.setBackground(new Color(255, 255, 255));
				btnHome.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnHome.setBackground(new Color(0, 153 , 0));
				btnHome.setForeground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ModePlay jframeModePlay = new ModePlay(client);
				waitRoom.dispose();
			}
		});
		
		panel_room1.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				panel_room1.setBackground(new Color(255, 255, 255));
				panel_room1.setForeground(new Color(0, 0, 0));
				
			}
			
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				panel_room1.setBackground(new Color(0, 153 , 0));
				panel_room1.setForeground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					client.setCtrl(self);
                    client.doSendSignal("1");
                    client.setTeam(Team.BLACK); // Gán màu đen cho client

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public void doCallback(ThreadClient thClient) {
         String resultRoom = thClient.getResultRoom();
         String tND = thClient.getResultTND();
         if(resultRoom.equals("success")) {
        	GamePanel gamePanel = new GamePanel(client);
         	JOptionPane.showMessageDialog(null, "bạn đã tham gia phòng 1 /n Xin chào " + tND);
         
         	Client client1 = new Client();
            client1.setTeam(Team.WHITE); // Gán màu trắng cho client1
            GamePanel game1 = new GamePanel(client1);
            waitRoom.dispose();
         }else {
         	JOptionPane.showMessageDialog(null, "Xin lỗi \n Phòng hiện tại đã đầy");
         }
	}
	
	private Client client;
	public void doSetClient(Client client) {
		this.client = client;
	}
}
