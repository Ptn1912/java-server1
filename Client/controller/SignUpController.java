package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import com.mysql.cj.xdevapi.PreparableStatement;

import client.Client;
import client.ThreadClient;
import dao.DBConnect;

import view.*;

public class SignUpController implements Controller{
	private JFrame signUp;
	private JButton btnAccountSurvivaled, btnConfirm;
	private JTextField textField_1, textField_2, textField_3;
	private JPasswordField passwordField_1,passwordField_2;
	private String email,tdn,tnd,mk, mkagain;
	private String result1;

	private SignUpController self=this;


	public SignUpController(JButton btnAccountSurvivaled, JButton btnConfirm, JFrame signUp,JTextField textField_1, JTextField textField_2, JTextField textField_3, JPasswordField passwordField_1,JPasswordField passwordField_2) {
		this.btnAccountSurvivaled = btnAccountSurvivaled;
		this.btnConfirm = btnConfirm;
		this.signUp = signUp;
		this.textField_1 = textField_1;
		this.textField_2 = textField_2;
		this.textField_3 = textField_3;
		this.passwordField_1 = passwordField_1;
		this.passwordField_2=passwordField_2;
	}
	public SignUpController(String receiver) {
		this.result1 = receiver;
	}

	public void setEvent() {
		btnAccountSurvivaled.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnAccountSurvivaled.setBackground(new Color(102,153,255));
				btnAccountSurvivaled.setForeground(new Color(255,255,255));

			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnAccountSurvivaled.setBackground(new Color(43, 100, 214));
				btnAccountSurvivaled.setForeground(new Color(255,255,255));

			}

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				SignIn jframeSignUp = new SignIn(client);
				signUp.dispose();
			}
		});

		btnConfirm.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				btnConfirm.setBackground(new Color(255, 87, 87));
				btnConfirm.setForeground(new Color(255,255,255));

			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				btnConfirm.setBackground(new Color(219, 72, 72));
				btnConfirm.setForeground(new Color(255,255,255));

			}

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				try {
					email = getEmail(); // Lấy giá trị userName từ textField
					tdn=getUserName();
					tnd=getName();
					mk=getPassword_0();
					mkagain = getPasswordAgain();

					if (email == null || email.isEmpty() || tdn == null || tdn.isEmpty() || tnd == null || tnd.isEmpty() || mk == null || mk.isEmpty() || mkagain == null || mkagain.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Thông tin không được trống!");
					} else if (!Arrays.equals(passwordField_1.getPassword(), passwordField_2.getPassword())) {
						JOptionPane.showMessageDialog(null, "Mật khẩu vừa nhập không khớp!");
					} else if (!textField_1.getText().endsWith("@gmail.com")) {
						JOptionPane.showMessageDialog(null, "Email vừa nhập không đúng định dạng!");
					} else {
						client.setCtrl(self);
						client.doSendSignal("register", email, tdn, tnd, mk, mkagain);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
	}
	public String getEmail() {
		String email = textField_1.getText();
		if (email == null) {
			return "";
		}
		return email;
	}

	public String getUserName() {
		String tdn = textField_2.getText();
		if (tdn == null) {
			return "";
		}
		return tdn;
	}
	public String getName() {
		String tnd = textField_3.getText();
		if (tnd == null) {
			return "";
		}
		return tnd;
	}

	public String getPassword_0() {
		String mk = new String(passwordField_1.getPassword());
		if (mk == null) {
			return "";
		}
		return mk;
	}
	public String getPasswordAgain() {
		String mk_again = new String(passwordField_2.getPassword());
		if (mk_again == null) {
			return "";
		}
		return mk_again;
	}
	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResult1() {

		return result1;
	}

	public void doCallback(ThreadClient thClient) {
		String currentResult = thClient.getResult();
		System.out.print("moi:"+currentResult);
		if ("exists email".equals(currentResult)) {
			JOptionPane.showMessageDialog(null, "Email đã tồn tại!");
		}else if("exists tdn".equals(currentResult)) {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!");
		}else if("exists tnd".equals(currentResult)) {
			JOptionPane.showMessageDialog(null, "Tên người dùng đã tồn tại!");
		}else if("success".equals(currentResult)) {
			JOptionPane.showMessageDialog(signUp, "Đăng kí thành công!");
			signUp.dispose();
			SignIn dn=new SignIn(client);
			dn.setVisible(true);
		}
	}
	
	private Client client;
	public void doSetClient(Client client) {
		this.client = client;
	}
}
