package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import controller.*;

public class MainPage extends JFrame {

	private JPanel contentPane, panel_img, panel_nav;
	private JLabel jlb_text, jlb_img;
	private JButton btnRank, btnMode, btnGuide, btnExit;
	
	public MainPage() {
		init();
		MainPageController control = new MainPageController(btnRank, btnMode, btnGuide, btnExit, this);
		control.setEvent();
	}
	
	public void init() {
		setTitle("Trang chủ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 489);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_img = new JPanel();
		panel_img.setBounds(0, 0, 507, 459);
		contentPane.add(panel_img);
		panel_img.setLayout(null);
		
		jlb_text = new JLabel("CHESS GAME");
		jlb_text.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_text.setBounds(10, 10, 487, 104);
		panel_img.add(jlb_text);
		jlb_text.setFont(new Font("Arial", Font.BOLD, 70));
		jlb_text.setForeground(new Color(248, 248, 255));
		
		jlb_img = new JLabel("");
		jlb_img.setIcon(new ImageIcon(MainPage.class.getResource("/images/img-home.png")));
		jlb_img.setBounds(0, 0, 507, 460);
		panel_img.add(jlb_img);
		
		panel_nav = new JPanel();
		panel_nav.setBackground(new Color(148,125,109));
		panel_nav.setBounds(505, 2, 280, 460);
		contentPane.add(panel_nav);
		panel_nav.setLayout(null);
		
		btnRank = new JButton("XẾP HẠNG");
		btnRank.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRank.setBackground(new Color(183, 110, 34));
		btnRank.setForeground(new Color(255, 255, 255));
		btnRank.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnRank.setBounds(15, 44, 250, 60);
		panel_nav.add(btnRank);
		
		btnMode = new JButton("CHẾ ĐỘ CHƠI");
		btnMode.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMode.setForeground(Color.WHITE);
		btnMode.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnMode.setBackground(new Color(183, 110, 34));
		btnMode.setBounds(15, 148, 250, 60);
		panel_nav.add(btnMode);
		
		btnGuide = new JButton("HƯỚNG DẪN");
		btnGuide.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGuide.setForeground(Color.WHITE);
		btnGuide.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnGuide.setBackground(new Color(183, 110, 34));
		btnGuide.setBounds(15, 252, 250, 60);
		panel_nav.add(btnGuide);
		
		btnExit = new JButton("THOÁT");
		btnExit.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnExit.setBackground(new Color(183, 110, 34));
		btnExit.setBounds(15, 356, 250, 60);
		panel_nav.add(btnExit);
	}
}