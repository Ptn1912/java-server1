package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client.Client;
import controller.SignInControler;


public class SignIn extends JFrame {

	private JPanel contentPane;
	private JLabel jlb_pass, jlb_name, jlb_title, lbl_img;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSignUp, btnSignIn;

	private Client client;
	public SignIn(Client client) {
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
		
		SignInControler control = new SignInControler(btnSignUp, btnSignIn, this, textField, passwordField);
		control.doSetClient(client);
		control.setEvent();
	}
	public void init() {
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 557);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSignUp = new JButton("Đăng Ký");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBackground(new Color(255,87,87));
		btnSignUp.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnSignUp.setBounds(174, 405, 182, 50);
		contentPane.add(btnSignUp);
		
		btnSignIn = new JButton("Đăng Nhập");
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnSignIn.setBackground(new Color(126,217,87));
		btnSignIn.setBounds(595, 405, 192, 50);
		contentPane.add(btnSignIn);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		passwordField.setBounds(469, 307, 400, 50);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		textField.setBounds(469, 199, 400, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		jlb_pass = new JLabel("Mật khẩu  :");
		jlb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_pass.setForeground(new Color(0, 204, 51));
		jlb_pass.setFont(new Font("Cambria Math", Font.BOLD, 40));
		jlb_pass.setBounds(111, 307, 307, 66);
		contentPane.add(jlb_pass);
		
		jlb_name = new JLabel("Tên đăng nhập :");
		jlb_name.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_name.setFont(new Font("Cambria Math", Font.BOLD, 40));
		jlb_name.setForeground(new Color(0, 204, 51));
		jlb_name.setBounds(111, 194, 307, 66);
		contentPane.add(jlb_name);
		
		jlb_title = new JLabel("Đăng Nhập");
		jlb_title.setVerticalAlignment(SwingConstants.BOTTOM);
		jlb_title.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_title.setForeground(new Color(51, 255, 51));
		jlb_title.setBackground(new Color(255, 255, 255));
		jlb_title.setFont(new Font("Cambria Math", Font.BOLD, 90));
		jlb_title.setBounds(220, 35, 532, 124);
		contentPane.add(jlb_title);
		
		lbl_img = new JLabel("");
		lbl_img.setForeground(new Color(0, 204, 51));
		lbl_img.setIcon(new ImageIcon(SignIn.class.getResource("/images/img-sign.png")));
		lbl_img.setBounds(0, 0, 984, 520);
		contentPane.add(lbl_img);
	}
}
