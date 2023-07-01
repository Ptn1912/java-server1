package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import controller.Controller;


public class ThreadClient extends Thread {
	private Socket socket;
	private Controller ctrl;
	private String result, resultTND, resultRoom, colorPlayer;

	private DataInputStream dip;
	private DataOutputStream dop;
	public ThreadClient(Socket socket) {
		this.socket = socket;
		try {
			dip = new DataInputStream(socket.getInputStream());
			dop = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void setCtrl (Controller ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void run() {
		try {
			while(!socket.isClosed()) {
				String receivedSignal = dip.readUTF();
				if(receivedSignal.equals("svLogin") ) {
					doSvLogin();

				}else if (receivedSignal.equals("svRegister")) {
					doSvRegister();

				}else if(receivedSignal.equals("svRoom")) {
					doSvRoom ();

				}else if(receivedSignal.equals("svError")){
					//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getResult() {
		return result;
	}

	public String getResultRoom() {
		return resultRoom;
	}
	
	public String getColorPlayer() {
		return colorPlayer;
	}

	public void setResultTND(String resultTND) {
		this.resultTND = resultTND;
	}

	public String getResultTND() {
		return resultTND;
	}

	public void doSendSignal (String signal, String ... content) throws Exception{
		dop.writeUTF(signal);

		for (String s:content) {
			dop.writeUTF(s);
		}
	}

	public void doSvLogin() throws Exception{
		result 		= dip.readUTF();
		resultTND 	= dip.readUTF();
		ctrl.doCallback(this);
	}
	public void doSvRegister() throws Exception{
		result 		= dip.readUTF();
		resultTND 	= dip.readUTF();
		ctrl.doCallback(this);
	}
	public void doSvRoom() throws Exception{
		resultRoom 	= dip.readUTF();
		colorPlayer = dip.readUTF();
		ctrl.doCallback(this);
	}

}

