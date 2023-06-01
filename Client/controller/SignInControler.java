package controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
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

public class SignInControler {
    private JFrame signIn;
    private JButton btnSignUp, btnSignIn;
    private JTextField textField;
    private JPasswordField passwordField;
    private String result;
    private String userName, password;
    public SignInControler(JButton btnSignUp, JButton btnSignIn, JFrame signIn,JTextField textField,JPasswordField passwordField) {
        this.btnSignUp = btnSignUp;
        this.btnSignIn = btnSignIn;
        this.signIn = signIn;
        this.textField=textField;
        this.passwordField=passwordField;
        setEvent();
    }
    
    public SignInControler(String receiver) {
        
            this.result = receiver;
        
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
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	try {
                    userName = getUserName(); // Lấy giá trị userName từ textField
                    password = getPassword(); // Lấy giá trị password từ passwordField
                    
                    if (userName.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu trống!");
                    } else {
                        Client client = new Client(userName, password, btnSignUp, btnSignIn, signIn, textField, passwordField);
                        client.startClient();

                        String currentResult = client.getResult();
                        System.out.print("moi:"+currentResult);
                        if ("ok".equals(currentResult)) {
                            JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công");
                            signIn.dispose();
                            MainPage mp = new MainPage();
                            mp.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "User hoặc password sai!");
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
	
    public String getUserName() {
        String userName = textField.getText();
        return userName;
    }
    
    public String getPassword() {
        String password = new String(passwordField.getPassword());
        return password;
    }
	    public void setResult(String result) {
	        this.result = result;
	    }
		
	    public String getResult() {
	       
	        return result;
	    }


}

		

			