package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import controller.SignInController;
import view.SignIn;

public class ThreadClient extends Thread {
    private Socket socket;
    private String userName;
    private String password;
    private SignInController signInController;

    public ThreadClient(Socket socket, String userName, String password, SignInController signInController) {
        this.socket = socket;
        this.userName = userName;
        this.password = password;
        this.signInController = signInController;
    }

    @Override
    public void run() {
        try {
            DataInputStream dip = new DataInputStream(socket.getInputStream());
            DataOutputStream dop = new DataOutputStream(socket.getOutputStream());

            dop.writeUTF(userName);
            dop.writeUTF(password);

            String receiver = dip.readUTF();

            boolean result = receiver.equals("OK");

            signInController.setResult(result);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

