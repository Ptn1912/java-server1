package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
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

import dao.DBConnect;

import view.*;

public class SignUpController {
	private JFrame signUp;
	private JButton btnAccountSurvivaled, btnConfirm;
	private JTextField textField, textField_1, textField_2;
	private JPasswordField passwordField,passwordField_1;
	public SignUpController(JButton btnAccountSurvivaled, JButton btnConfirm, JFrame signUp,JTextField textField, JTextField textField_1, JTextField textField_2, JPasswordField passwordField,JPasswordField passwordField_1) {
        this.btnAccountSurvivaled = btnAccountSurvivaled;
        this.btnConfirm = btnConfirm;
        this.signUp = signUp;
        this.textField = textField;
        this.textField_1 = textField_1;
        this.textField_2 = textField_2;
        this.passwordField = passwordField;
        this.passwordField_1=passwordField_1;
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
				SignIn jframeSignUp = new SignIn();
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
			    if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty() || passwordField.getPassword().length == 0 || passwordField_1.getPassword().length == 0) {
			        JOptionPane.showMessageDialog(signUp, "Thông tin không được trống!");
               }
			    else if(!Arrays.equals(passwordField.getPassword(),passwordField_1.getPassword())) {
				      JOptionPane.showMessageDialog(null, "Mât khẩu vừa nhập không khớp!");
				    }else if(!textField.getText().endsWith("@gmail.com")) {
				    	JOptionPane.showMessageDialog(null, "Email vừa nhập không đúng định dạng!");
				    }
			    else {
                    try {
			    Connection conn = DBConnect.getJDBCConnection();
			    String st ="INSERT INTO `connect`.`TA_LPN_ACCOUNT` (`T_EMAIL`, `T_TDN`, `T_TND`, `T_MK`) VALUES (?, ?, ?, ?);";
			    PreparedStatement ps = conn.prepareStatement(st);
			    ps.setString(1, textField.getText());
			    ps.setString(2, textField_1.getText());
			    ps.setString(3, textField_2.getText());
			    ps.setString(4, new String(passwordField.getPassword()));
			    int check = ps.executeUpdate();
			     if(check != 0){
			        JOptionPane.showMessageDialog(signUp, "Đăng kí thành công!");
			        signUp.dispose();
               	SignIn dn=new SignIn();
               	dn.setVisible(true);
			    }
			    conn.close();
			} catch (SQLException e1) {
			    e1.printStackTrace();
			}
		}
		}
	});
	}
	
}
