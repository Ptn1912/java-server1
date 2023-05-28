package main;

import javax.swing.SwingUtilities;
import view.*;

public class RunClient {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SignIn run = new SignIn();
            }
        });
	}
}
