package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ChooseSignInController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class ChooseSignIn extends JFrame {

	private JPanel contentPane;
	private JButton bntAdmin, btnUser;
	private JLabel jlb_background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseSignIn frame = new ChooseSignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChooseSignIn() {
		init();
		ChooseSignInController control = new ChooseSignInController(bntAdmin, btnUser, this);
		control.setEvent();
	}
	
	public void init() {
		setTitle("Chọn đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUser = new JButton("User");
		btnUser.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnUser.setBounds(60, 270, 320, 70);
		contentPane.add(btnUser);
		
		bntAdmin = new JButton("Admin");
		bntAdmin.setFont(new Font("Cambria Math", Font.BOLD, 30));
		bntAdmin.setBounds(60, 130, 320, 70);
		contentPane.add(bntAdmin);
		
		jlb_background = new JLabel("");
		jlb_background.setIcon(new ImageIcon(ChooseSignIn.class.getResource("/images/background-ChooseSignIn (1).jpg")));
		jlb_background.setBounds(0, 0, 440, 470);
		contentPane.add(jlb_background);
	}
}
