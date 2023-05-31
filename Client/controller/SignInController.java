package controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.Client;
import dao.DBConnect;

import view.*;

public class SignInController {
    private JFrame signIn;
    private JButton btnSignUp, btnSignIn;
    private JTextField textField;
    private JPasswordField passwordField;
    private boolean result;
    
    public SignInController(JButton btnSignUp, JButton btnSignIn, JFrame signIn,JTextField textField,JPasswordField passwordField) {
        this.btnSignUp = btnSignUp;
        this.btnSignIn = btnSignIn;
        this.signIn = signIn;
        this.textField=textField;
        this.passwordField=passwordField;
    }
    
    public SignInController() {
    	
    }

	public void setEvent() {
        btnSignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnSignUp.setBackground(new Color(255, 87, 87));
                btnSignUp.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnSignUp.setBackground(new Color(219, 72, 72));
                btnSignUp.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                SignUp jframeSignUp = new SignUp();
                signIn.dispose();
            }
        });

        btnSignIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnSignIn.setBackground(new Color(126, 217, 87));
                btnSignIn.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnSignIn.setBackground(new Color(82, 189, 36));
                btnSignIn.setForeground(new Color(255, 255, 255));
            }
            public void mouseClicked(MouseEvent e) {
                try {
                    String userName = getUserName();
                    String password = getPassword();

                    Client client = new Client(userName, password, SignInController.this);
                    client.startClient();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//					if(result.equals("rong")) {
//						JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu bị bỏ trống!");
//					}else if(result.equals("ok")) {
//						JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công");
//						signIn.dispose();
//                     	MainPage mp=new MainPage();
//                     	mp.setVisible(true);
//					}else {
//						JOptionPane.showMessageDialog(null, "User hoac password sai!");
//					}
				
//            	 try {
//                     Connection connection = DBConnect.getJDBCConnection();
//                     PreparedStatement st = connection
//                             .prepareStatement("Select T_TDN,T_MK from TA_LPN_ACCOUNT where T_TDN=? and T_MK=?");
//                     st.setString(1, textField.getText());
//                     st.setString(2, new String(passwordField.getPassword()));
//                     ResultSet rs = st.executeQuery();
//                     if (rs.next()) {
//                    	 if(textField.getText().equals("")||passwordField.getText().equals("")) {
//                    		 JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu bị bỏ trống!");
//                    	 }
//                    	 else{
//                    		 JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công");
//                     	signIn.dispose();
//                     	MainPage mp=new MainPage();
//                     	mp.setVisible(true);
//                    	 }
//                     } else {
//                         JOptionPane.showMessageDialog(null, "User hoac password sai!");
//                     }
//                 } catch (SQLException sqlException) {
//                     sqlException.printStackTrace();
//                 }
            }
        });
    }
	
	 public String getUserName() {
	        return textField.getText();
	    }

	    public String getPassword() {
	        return new String(passwordField.getPassword());
	    }

	    public void setResult(boolean result) {
	        this.result = result;
	    }

	    public void showResultDialog() {
	        if (result) {
	            JOptionPane.showMessageDialog(null, "OK");
	            signIn.dispose();
	            MainPage mp = new MainPage();
	            mp.setVisible(true);
	        } else {
	            JOptionPane.showMessageDialog(null, "KO");
	        }
	    }
}


		

			