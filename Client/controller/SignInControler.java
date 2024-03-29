package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import client.Client;
import client.ThreadClient;
import view.MainPage;
import view.SignUp;
import view.StartServer;
import view.WaitRoom;

public class SignInControler implements Controller{
	
    private JFrame signIn;
    private JButton btnSignUp, btnSignIn;
    private JTextField textField;
    private JPasswordField passwordField;
    private String result, resultTND;
    private String userName, password;
   
    private SignInControler self=this;
    public SignInControler(JButton btnSignUp, JButton btnSignIn, JFrame signIn,JTextField textField,JPasswordField passwordField) {
        this.btnSignUp = btnSignUp;
        this.btnSignIn = btnSignIn;
        this.signIn = signIn;
        this.textField=textField;
        this.passwordField=passwordField;
    }
    
    public SignInControler(String receiver) {
    	this.result = receiver;
        
    }
    
    public SignInControler() {
    	
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
                SignUp jframeSignUp = new SignUp(client);
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
                        client.setCtrl(self);
						client.doSendSignal("login", userName, password);
                    }
                } catch (Exception e1) {
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
	
	public void setResultTND(String resultTND) {
		this.resultTND = resultTND;
	}
	
	public String getResultTND() {
		return resultTND;
	}

	public void doCallback(ThreadClient thClient) {
		String currentResult 	= thClient.getResult();
        String tND 				= thClient.getResultTND();
        setResultTND(tND);
        System.out.print("moi:"+currentResult + " " + tND);

        if ("ok user".equals(currentResult)) {
            JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công");
            signIn.dispose();
            SwingUtilities.invokeLater(new Runnable() {
    	        @Override
    	        public void run() {
    	        	MainPage mp = new MainPage(client);
    	            mp.setVisible(true);
    	        }
    	    });
        }else if ("ok admin".equals(currentResult)) {
            JOptionPane.showMessageDialog(null, "Bạn đã đăng nhập thành công");
            signIn.dispose();
            StartServer ss = new StartServer();
            ss.setVisible(true);
        }else if("online".equals(currentResult)) {
        	JOptionPane.showMessageDialog(null, "Tài khoản này đang được sử dụng \nVui lòng đăng nhập tại khoản khác");
        }else {
            JOptionPane.showMessageDialog(null, "User hoặc password sai!");
        }
	}
	
	private Client client;
	public void doSetClient(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
}

		

			