package client;

import java.io.IOException;
import java.net.Socket;
import controller.*;
public class Client {
    private String userName;
    private String password;
    private SignInController signInController;

    public Client(String userName, String password, SignInController signInController) {
       
        this.userName = userName;
        this.password = password;
        this.signInController = signInController;
    }

    public void startClient() throws IOException {
        Socket socket = new Socket("localhost", 8200);

        ThreadClient threadClient = new ThreadClient(socket, userName, password, signInController);
        threadClient.start();
        try {
            threadClient.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signInController.showResultDialog();

        socket.close();
    }
}


