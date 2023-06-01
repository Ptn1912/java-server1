package client;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Client {
    private String userName, password;
    private String result,result1;
    private JButton btnSignUp, btnSignIn;
    private JFrame signIn;
    private JTextField textField;
    private JPasswordField passwordField;

	private JTextField textField_1, textField_2, textField_3;
	private JPasswordField passwordField_1;
    private String email,tdn,tnd,mk;
    public Client(String userName, String password, JButton btnSignUp, JButton btnSignIn, JFrame signIn, JTextField textField, JPasswordField passwordField) {
        this.userName = userName;
        this.password = password;
        this.btnSignUp = btnSignUp;
        this.btnSignIn = btnSignIn;
        this.signIn = signIn;
        this.textField = textField;
        this.passwordField = passwordField;
    }

    public Client(String email, String tdn, String tnd, String mk, JTextField textField_1, JTextField textField_2,
			JTextField textField_3, JPasswordField passwordField_1) {
    	this.email=email;
    	this.tdn=tdn;
    	this.tnd=tnd;
    	this.mk=mk;
    	this.textField_1=textField_1;
    	this.textField_2=textField_2;
    	this.textField_3=textField_3;
    	this.passwordField_1=passwordField_1;
	}

	public void startClient() throws IOException {
        Socket socket = new Socket("localhost", 9200);

        ThreadClient threadClient = new ThreadClient(socket, userName, password, btnSignUp, btnSignIn, signIn, textField, passwordField);
        threadClient.start();

        try {
            threadClient.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        result = threadClient.getResult();
    }
	public void startClientt() throws IOException {
        Socket socket = new Socket("localhost", 9200);

        ThreadClient threadClientt = new ThreadClient(socket, email, tdn, tnd, mk, textField_1,textField_2,textField_3, passwordField_1);
        threadClientt.start();

        try {
            threadClientt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       
        result1 = threadClientt.getResult1();
    }

    public String getResult() {
        return result;
    }
    public String getResult1() {
        return result1;
    }
}



