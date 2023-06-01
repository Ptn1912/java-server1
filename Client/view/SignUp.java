package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import controller.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JLabel jlb_pass, jlb_email, jlb_passAgain, jlb_nameLogin, jlb_title, lblNewLabel, jlb_nameUser;
	private JTextField textField_1, textField_2, textField_3;
	private JPasswordField passwordField_1,passwordField_2;
	private JButton btnAccountSurvivaled, btnConfirm;

	public SignUp() {
		init();
        SignUpController control = new SignUpController(btnAccountSurvivaled, btnConfirm, this, textField_1,textField_3,textField_2,passwordField_1,passwordField_2);
        control.setEvent();
	}
	
	public void init() {
		setTitle("Đăng Ký");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 557);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirm = new JButton("Đăng ký");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(new Color(255, 87, 87));
		btnConfirm.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnConfirm.setBounds(594, 424, 192, 50);
		contentPane.add(btnConfirm);
		
		btnAccountSurvivaled = new JButton("Đã có tài khoản");
		btnAccountSurvivaled.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAccountSurvivaled.setBackground(new Color(102,153,255));
		btnAccountSurvivaled.setForeground(new Color(255, 255, 255));
		btnAccountSurvivaled.setFont(new Font("Cambria Math", Font.BOLD, 30));
		btnAccountSurvivaled.setBounds(140, 421, 247, 50);
		contentPane.add(btnAccountSurvivaled);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		passwordField_2.setBounds(442, 359, 370, 49);
		contentPane.add(passwordField_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		passwordField_1.setBounds(442, 291, 370, 51);
		contentPane.add(passwordField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(442, 178, 370, 49);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		textField_1.setBounds(442, 117, 373, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		jlb_pass = new JLabel("Mật khẩu :");
		jlb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_pass.setForeground(new Color(255, 102, 102));
		jlb_pass.setFont(new Font("Dialog", Font.BOLD, 40));
		jlb_pass.setBounds(108, 280, 324, 50);
		contentPane.add(jlb_pass);
		
		jlb_email = new JLabel("Email :");
		jlb_email.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_email.setForeground(new Color(255, 102, 102));
		jlb_email.setFont(new Font("Dialog", Font.BOLD, 40));
		jlb_email.setBounds(101, 102, 324, 50);
		contentPane.add(jlb_email);
		
		jlb_passAgain = new JLabel("Nhập lại mật khẩu :");
		jlb_passAgain.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_passAgain.setForeground(new Color(255, 102, 102));
		jlb_passAgain.setFont(new Font("Dialog", Font.BOLD, 40));
		jlb_passAgain.setBounds(44, 340, 388, 50);
		contentPane.add(jlb_passAgain);
		
		jlb_nameLogin = new JLabel("Tên đăng nhập :");
		jlb_nameLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_nameLogin.setFont(new Font("Dialog", Font.BOLD, 40));
		jlb_nameLogin.setForeground(new Color(255, 102, 102));
		jlb_nameLogin.setBounds(111, 163, 321, 50);
		contentPane.add(jlb_nameLogin);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(442, 235, 370, 48);
		contentPane.add(textField_3);
		
		jlb_title = new JLabel("Đăng Ký");
		jlb_title.setVerticalAlignment(SwingConstants.BOTTOM);
		jlb_title.setHorizontalAlignment(SwingConstants.CENTER);
		jlb_title.setForeground(new Color(255,87,87));
		jlb_title.setBackground(new Color(255, 255, 255));
		jlb_title.setFont(new Font("Cambria Math", Font.BOLD, 90));
		jlb_title.setBounds(215, 0, 532, 114);
		contentPane.add(jlb_title);
		
		jlb_nameUser = new JLabel("Tên người dùng :");
		jlb_nameUser.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb_nameUser.setForeground(new Color(255, 102, 102));
		jlb_nameUser.setFont(new Font("Dialog", Font.BOLD, 40));
		jlb_nameUser.setBounds(72, 220, 360, 50);
		contentPane.add(jlb_nameUser);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(SignIn.class.getResource("/images/img-sign.png")));
		lblNewLabel.setBounds(0, 0, 984, 520);
		contentPane.add(lblNewLabel);
	}
}
