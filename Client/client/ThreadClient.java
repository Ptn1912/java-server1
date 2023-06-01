package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.SignInControler;
import controller.SignUpController;
import view.SignIn;


public class ThreadClient extends Thread {
    private Socket socket;
    private String userName, password;
    private String result,result1;
    private JButton btnSignUp, btnSignIn;
    private JFrame signIn;
    private JTextField textField;
    private JPasswordField passwordField;
    private String email,tdn,tnd,mk;
    private JTextField textField_1, textField_2, textField_3;
	private JPasswordField passwordField_1,passwordField_2;
	private JFrame signUp;
	private JButton btnAccountSurvivaled, btnConfirm;
    public ThreadClient(Socket socket, String userName, String password, JButton btnSignUp, JButton btnSignIn, JFrame signIn, JTextField textField, JPasswordField passwordField) {
        this.socket = socket;
        this.userName = userName;
        this.password = password;
        this.btnSignUp = btnSignUp;
        this.btnSignIn = btnSignIn;
        this.signIn = signIn;
        this.textField = textField;
        this.passwordField = passwordField;
    }

    public ThreadClient(Socket socket, String email, String tdn, String tnd, String mk, JTextField textField_1,
			JTextField textField_2, JTextField textField_3, JPasswordField passwordField_1) {
    	this.socket=socket;
    	this.email=email;
    	this.tdn=tdn;
    	this.tnd=tnd;
    	this.mk=mk;
    	this.textField_1=textField_1;
    	this.textField_2=textField_2;
    	this.textField_3=textField_3;
    	this.passwordField_1=passwordField_1;
	}

	@Override
    public void run() {
        try {
            DataInputStream dip = new DataInputStream(socket.getInputStream());
            DataOutputStream dop = new DataOutputStream(socket.getOutputStream());

            dop.writeUTF(userName);
            dop.writeUTF(password);
          

            dop.writeUTF(email);
            dop.writeUTF(tdn);
            dop.writeUTF(tnd);
            dop.writeUTF(mk);
            
            result = dip.readUTF();
            result1 = dip.readUTF(); 
          

           
            SignInControler control = new SignInControler(btnSignUp, btnSignIn, signIn, textField, passwordField);
            control.setResult(result);
            
            SignUpController ct=new SignUpController(btnAccountSurvivaled,btnConfirm,signUp,textField_1,textField_2,textField_3,passwordField_1, passwordField_2);
            ct.setResult1(result1);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return result;
    }
    public String getResult1() {
        return result1;
    }
}

