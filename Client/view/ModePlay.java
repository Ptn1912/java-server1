package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Client;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import controller.*;

public class ModePlay extends JFrame {

	private JPanel contentPane;
	private JLabel jlb_title1, jlb_title2;
	private JButton bntComputer;
	private JButton btnPlayer;
	private JButton btnHome;
	private Client client;

	public ModePlay(Client client) {
		this.client = client;
		init();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                	client.doSendSignal("close");
					client.closeClient();
				} catch (Exception e1) {
					e1.printStackTrace();
				};
            }
		});
		
		ModePlayController control = new ModePlayController(bntComputer, btnPlayer, btnHome, this);
		control.doSetClient(client);
		control.setEvent();
	}
	
	public void init() {
		setTitle("Chế độ chơi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 330);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jlb_title1 = new JLabel("CHỌN CHẾ ĐỘ ");
		jlb_title1.setForeground(new Color(255,87,87));
		jlb_title1.setVerticalAlignment(SwingConstants.BOTTOM);
		jlb_title1.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_title1.setFont(new Font("Cambria Math", Font.BOLD, 60));
		jlb_title1.setBounds(10, 10, 536, 80);
		contentPane.add(jlb_title1);
		
		jlb_title2 = new JLabel("CHƠI CỦA BẠN");
		jlb_title2.setVerticalAlignment(SwingConstants.BOTTOM);
		jlb_title2.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_title2.setForeground(new Color(255, 87, 87));
		jlb_title2.setFont(new Font("Cambria Math", Font.BOLD, 60));
		jlb_title2.setBounds(10, 86, 536, 80);
		contentPane.add(jlb_title2);
		
		bntComputer = new JButton(" MÁY");
		bntComputer.setIcon(new ImageIcon(ModePlay.class.getResource("/images/Computer.png")));
		bntComputer.setFont(new Font("Cambria Math", Font.BOLD, 20));
		bntComputer.setBackground(new Color(255,153,102));
		bntComputer.setBounds(20, 200, 140, 50);
		contentPane.add(bntComputer);
		
		btnPlayer = new JButton("NGƯỜI");
		btnPlayer.setIcon(new ImageIcon(ModePlay.class.getResource("/images/user.png")));
		btnPlayer.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnPlayer.setBackground(new Color(102,201,51));
		btnPlayer.setBounds(395, 200, 140, 50);
		contentPane.add(btnPlayer);
		
		btnHome = new JButton("TRANG CHỦ");
		btnHome.setBackground(new Color(255, 228, 171));
		btnHome.setIcon(new ImageIcon(ModePlay.class.getResource("/images/Home-32.png")));
		btnHome.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnHome.setBounds(185, 200, 188, 50);
		contentPane.add(btnHome);
	}
}
