package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.ModePlay;

public class WaitRoomController {
	private JFrame waitRoom;
	private JButton btnHome;
	
	public WaitRoomController(JButton btnHome, JFrame waitRoom) {
		this.btnHome = btnHome;
		this.waitRoom = waitRoom;
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
				ModePlay jframeModePlay = new ModePlay();
				waitRoom.dispose();
			}
		});
	}
}
