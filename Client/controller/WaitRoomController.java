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
	private JPanel[] panelRooms;
	private String[] countRooms;

	private WaitRoomController self = this;
	public WaitRoomController(JButton btnHome, JFrame waitRoom, JPanel[] panelRooms, String[] countRooms) {
		this.btnHome = btnHome;
		this.waitRoom = waitRoom;
		this.panelRooms = panelRooms;
		this.countRooms = countRooms;
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
		
		for (int count = 0; count < 8; ++count) {
		    final int finalCount = count;
		    if (finalCount < panelRooms.length) {
		        panelRooms[finalCount].addMouseListener(new MouseAdapter() {

		            @Override
		            public void mouseExited(java.awt.event.MouseEvent e) {
		                if (countRooms[finalCount+1].equals("2")) {
		                    panelRooms[finalCount].setBackground(Color.RED);
		                } else if (countRooms[finalCount+1].equals("1")) {
		                    panelRooms[finalCount].setBackground(Color.YELLOW);
		                } else {
		                    panelRooms[finalCount].setBackground(Color.WHITE);
		                }
		                panelRooms[finalCount].setForeground(new Color(0, 0, 0));
		            }

		            @Override
		            public void mouseEntered(java.awt.event.MouseEvent e) {
		                if (countRooms[finalCount+1].equals("2")) {
		                    panelRooms[finalCount].setBackground(Color.RED);
		                    panelRooms[finalCount].setForeground(new Color(0, 0, 0));
		                } else {
		                    panelRooms[finalCount].setBackground(new Color(0, 153, 0));
		                    panelRooms[finalCount].setForeground(new Color(255, 255, 255));
		                }
		            }

		            @Override
		            public void mouseClicked(java.awt.event.MouseEvent e) {
		                try {
		                    client.setCtrl(self);
		                    client.doSendSignal(String.valueOf(finalCount + 1));
		                } catch (Exception e2) {
		                    e2.printStackTrace();
		                }
		            }
		        });
		    }
		}



//		panelRooms[0].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[0].setBackground(new Color(255, 255, 255));
//				panelRooms[0].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[0].setBackground(new Color(0, 153 , 0));
//				panelRooms[0].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("1");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[1].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[1].setBackground(new Color(255, 255, 255));
//				panelRooms[1].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[1].setBackground(new Color(0, 153 , 0));
//				panelRooms[1].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("2");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[2].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[2].setBackground(new Color(255, 255, 255));
//				panelRooms[2].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[2].setBackground(new Color(0, 153 , 0));
//				panelRooms[2].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("3");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[3].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[3].setBackground(new Color(255, 255, 255));
//				panelRooms[3].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[3].setBackground(new Color(0, 153 , 0));
//				panelRooms[3].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("4");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[4].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[4].setBackground(new Color(255, 255, 255));
//				panelRooms[4].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[4].setBackground(new Color(0, 153 , 0));
//				panelRooms[4].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("5");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[5].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[5].setBackground(new Color(255, 255, 255));
//				panelRooms[5].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[5].setBackground(new Color(0, 153 , 0));
//				panelRooms[5].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("6");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[6].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[6].setBackground(new Color(255, 255, 255));
//				panelRooms[6].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[6].setBackground(new Color(0, 153 , 0));
//				panelRooms[6].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("7");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		
//		panelRooms[7].addMouseListener(new MouseAdapter() {			
//			@Override
//			public void mouseExited(java.awt.event.MouseEvent e) {
//				panelRooms[7].setBackground(new Color(255, 255, 255));
//				panelRooms[7].setForeground(new Color(0, 0, 0));
//				
//			}
//			
//			@Override
//			public void mouseEntered(java.awt.event.MouseEvent e) {
//				panelRooms[7].setBackground(new Color(0, 153 , 0));
//				panelRooms[7].setForeground(new Color(255, 255, 255));
//				
//			}
//			
//			@Override
//			public void mouseClicked(java.awt.event.MouseEvent e) {
//				try {
//					client.setCtrl(self);
//                    client.doSendSignal("8");
//
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
	}
	public void doCallback(ThreadClient thClient) {
         String resultRoom = thClient.getResultRoom();
         String colorPlayer = thClient.getColorPlayer();
         String tND = thClient.getResultTND();
         if(resultRoom.equals("success")) {
        	if(colorPlayer.equals("white")) {
        		client.setTeam(Team.WHITE);
        	}else {
        		client.setTeam(Team.BLACK);
        	}
        	GamePanel gamePanel = new GamePanel(client, colorPlayer);
         	JOptionPane.showMessageDialog(null, "bạn đã tham gia phòng 1 /n Xin chào " + tND + colorPlayer);

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
