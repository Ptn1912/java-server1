package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import controller.*;

public class WaitRoom extends JFrame {

	private JPanel contentPane, panel_room1, panel_room2, panel_room3, panel_room4, panel_room5, panel_room6, panel_room7, panel_room8;
	private JLabel jlb_Room1_Icon2, jlb_Room1_Icon1, jlb_text1, jlb_Room2_Icon2, jlb_Room2_Icon1, jlb_text2, jlb_Room3_Icon2, jlb_Room3_Icon1, jlb_text3, 
	jlb_Room4_Icon2, jlb_Room4_Icon1, jlb_text4, jlb_Room5_Icon2, jlb_Room5_Icon1, jlb_text5, jlb_Room6_Icon2, jlb_Room6_Icon1, jlb_text6,
	jlb_Room7_Icon2, jlb_Room7_Icon1, jlb_text7, jlb_Room8_Icon2, jlb_Room8_Icon1, jlb_text8, jlb_Title;
	private JButton btnHome;

	public WaitRoom() {
		init();
		WaitRoomController control = new WaitRoomController(btnHome, this, panel_room1, panel_room2, panel_room3, 
															panel_room4, panel_room5, panel_room6, panel_room7, panel_room8);
		control.setEvent();
	}
	
	public void init() {
		setTitle("Phòng chờ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 544);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_room1 = new JPanel();
		panel_room1.setBounds(40, 105, 150, 150);
		contentPane.add(panel_room1);
		panel_room1.setLayout(null);
		
		jlb_Room1_Icon2 = new JLabel("");
		jlb_Room1_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room1_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room1_Icon2.setBounds(70, 40, 70, 70);
		panel_room1.add(jlb_Room1_Icon2);
		
		jlb_Room1_Icon1 = new JLabel("");
		jlb_Room1_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room1_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room1_Icon1.setBounds(10, 40, 70, 70);
		panel_room1.add(jlb_Room1_Icon1);
		
		jlb_text1 = new JLabel("Phòng trống");
		jlb_text1.setForeground(new Color(0, 255, 0));
		jlb_text1.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text1.setBounds(20, 111, 109, 29);
		panel_room1.add(jlb_text1);
		
		panel_room2 = new JPanel();
		panel_room2.setLayout(null);
		panel_room2.setBounds(272, 105, 150, 150);
		contentPane.add(panel_room2);
		
		jlb_Room2_Icon2 = new JLabel("");
		jlb_Room2_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room2_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room2_Icon2.setBounds(70, 40, 70, 70);
		panel_room2.add(jlb_Room2_Icon2);
		
		jlb_Room2_Icon1 = new JLabel("");
		jlb_Room2_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room2_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room2_Icon1.setBounds(10, 40, 70, 70);
		panel_room2.add(jlb_Room2_Icon1);
		
		jlb_text2 = new JLabel("Phòng trống");
		jlb_text2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text2.setForeground(Color.GREEN);
		jlb_text2.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text2.setBounds(20, 111, 109, 29);
		panel_room2.add(jlb_text2);
		
		panel_room4 = new JPanel();
		panel_room4.setLayout(null);
		panel_room4.setBounds(735, 105, 150, 150);
		contentPane.add(panel_room4);
		
		jlb_Room4_Icon2 = new JLabel("");
		jlb_Room4_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room4_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room4_Icon2.setBounds(70, 40, 70, 70);
		panel_room4.add(jlb_Room4_Icon2);
		
		jlb_Room4_Icon1 = new JLabel("");
		jlb_Room4_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room4_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room4_Icon1.setBounds(10, 40, 70, 70);
		panel_room4.add(jlb_Room4_Icon1);
		
		jlb_text4 = new JLabel("Phòng trống");
		jlb_text4.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text4.setForeground(Color.GREEN);
		jlb_text4.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text4.setBounds(20, 111, 109, 29);
		panel_room4.add(jlb_text4);
		
		panel_room3 = new JPanel();
		panel_room3.setLayout(null);
		panel_room3.setBounds(507, 105, 150, 150);
		contentPane.add(panel_room3);
		
		jlb_Room3_Icon2 = new JLabel("");
		jlb_Room3_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room3_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room3_Icon2.setBounds(70, 40, 70, 70);
		panel_room3.add(jlb_Room3_Icon2);
		
		jlb_Room3_Icon1 = new JLabel("");
		jlb_Room3_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room3_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room3_Icon1.setBounds(10, 40, 70, 70);
		panel_room3.add(jlb_Room3_Icon1);
		
		jlb_text3 = new JLabel("Phòng trống");
		jlb_text3.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text3.setForeground(Color.GREEN);
		jlb_text3.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text3.setBounds(20, 111, 109, 29);
		panel_room3.add(jlb_text3);
		
		panel_room5 = new JPanel();
		panel_room5.setLayout(null);
		panel_room5.setBounds(40, 305, 150, 150);
		contentPane.add(panel_room5);
		
		jlb_Room5_Icon2 = new JLabel("");
		jlb_Room5_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room5_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room5_Icon2.setBounds(70, 40, 70, 70);
		panel_room5.add(jlb_Room5_Icon2);
		
		jlb_Room5_Icon1 = new JLabel("");
		jlb_Room5_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room5_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room5_Icon1.setBounds(10, 40, 70, 70);
		panel_room5.add(jlb_Room5_Icon1);
		
		jlb_text5 = new JLabel("Phòng trống");
		jlb_text5.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text5.setForeground(Color.GREEN);
		jlb_text5.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text5.setBounds(20, 111, 109, 29);
		panel_room5.add(jlb_text5);
		
		panel_room6 = new JPanel();
		panel_room6.setLayout(null);
		panel_room6.setBounds(272, 305, 150, 150);
		contentPane.add(panel_room6);
		
		jlb_Room6_Icon2 = new JLabel("");
		jlb_Room6_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room6_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room6_Icon2.setBounds(70, 40, 70, 70);
		panel_room6.add(jlb_Room6_Icon2);
		
		jlb_Room6_Icon1 = new JLabel("");
		jlb_Room6_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room6_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room6_Icon1.setBounds(10, 40, 70, 70);
		panel_room6.add(jlb_Room6_Icon1);
		
		jlb_text6 = new JLabel("Phòng trống");
		jlb_text6.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text6.setForeground(Color.GREEN);
		jlb_text6.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text6.setBounds(20, 111, 109, 29);
		panel_room6.add(jlb_text6);
		
		panel_room7 = new JPanel();
		panel_room7.setLayout(null);
		panel_room7.setBounds(507, 305, 150, 150);
		contentPane.add(panel_room7);
		
		jlb_Room7_Icon2 = new JLabel("");
		jlb_Room7_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room7_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room7_Icon2.setBounds(70, 40, 70, 70);
		panel_room7.add(jlb_Room7_Icon2);
		
		jlb_Room7_Icon1 = new JLabel("");
		jlb_Room7_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room7_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room7_Icon1.setBounds(10, 40, 70, 70);
		panel_room7.add(jlb_Room7_Icon1);
		
		jlb_text7 = new JLabel("Phòng trống");
		jlb_text7.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text7.setForeground(Color.GREEN);
		jlb_text7.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text7.setBounds(20, 111, 109, 29);
		panel_room7.add(jlb_text7);
		
		panel_room8 = new JPanel();
		panel_room8.setLayout(null);
		panel_room8.setBounds(735, 305, 150, 150);
		contentPane.add(panel_room8);
		
		jlb_Room8_Icon2 = new JLabel("");
		jlb_Room8_Icon2.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room8_Icon2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room8_Icon2.setBounds(70, 40, 70, 70);
		panel_room8.add(jlb_Room8_Icon2);
		
		jlb_Room8_Icon1 = new JLabel("");
		jlb_Room8_Icon1.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/User.64.png")));
		jlb_Room8_Icon1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Room8_Icon1.setBounds(10, 40, 70, 70);
		panel_room8.add(jlb_Room8_Icon1);
		
		jlb_text8 = new JLabel("Phòng trống");
		jlb_text8.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text8.setForeground(Color.GREEN);
		jlb_text8.setFont(new Font("Cambria Math", Font.BOLD, 17));
		jlb_text8.setBounds(20, 111, 109, 29);
		panel_room8.add(jlb_text8);
		
		jlb_Title = new JLabel("PHÒNG CHỜ");
		jlb_Title.setForeground(new Color(255, 255, 255));
		jlb_Title.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 55));
		jlb_Title.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_Title.setBounds(272, 10, 385, 70);
		contentPane.add(jlb_Title);
		
		btnHome = new JButton("TRANG CHỦ");
		btnHome.setIcon(new ImageIcon(WaitRoom.class.getResource("/images/home-24.png")));
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setFont(new Font("Cambria Math", Font.BOLD, 15));
		btnHome.setBounds(40, 20, 150, 60);
		contentPane.add(btnHome);
	}

}
