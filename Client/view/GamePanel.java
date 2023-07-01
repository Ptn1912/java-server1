package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import Board.Board;
import piece.Team;
import resources.GUI_Configurations;
import view.*;
import client.Client;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel {
	 private JFrame gameFrame;
	 private BoardPanel boardPanel;
	 private Board chessBoard;
	 private InGameBottomMenu bottomGameMenu;
	 private Client client;
	 private String colorPlayer;
	
	 public GamePanel(Client client, String colorPlayer){
		 this.client = client;
		 this.colorPlayer = colorPlayer;
		 this.gameFrame = new JFrame("Chess");
	     this.gameFrame.getContentPane().setLayout(new BorderLayout());
	     this.gameFrame.setSize(GUI_Configurations.OUTER_FRAME_DIMENSION);
	     createGamePanel();
	     this.gameFrame.setVisible(true);
	 }


	private void createGamePanel() {
		 this.chessBoard = new Board();
	     this.boardPanel = new BoardPanel(this.chessBoard, this.client);
	     this.bottomGameMenu = new InGameBottomMenu(client, gameFrame, colorPlayer);
	     this.bottomGameMenu.getPlayersColorLBL().setText("Your color is " + this.client.getTeam().toString());
	     if(this.client.getTeam() == Team.WHITE)
	     {
	         this.bottomGameMenu.getTurnLBL().setText("Your Turn");
	         this.bottomGameMenu.getTurnLBL().setForeground(Color.GREEN);
	     }
	     else
	     {
	         this.bottomGameMenu.getTurnLBL().setText("Enemy Turn");
	         this.bottomGameMenu.getTurnLBL().setForeground(Color.RED);
	     }    
         this.gameFrame.getContentPane().add(boardPanel);
	     this.gameFrame.getContentPane().add(this.boardPanel, BorderLayout.CENTER);
	     this.gameFrame.getContentPane().add(this.bottomGameMenu, BorderLayout.PAGE_END);

	     this.gameFrame.setVisible(true);
		
	}

public InGameBottomMenu getBottomGameMenu() {
    return bottomGameMenu;
}

public void setBottomGameMenu(InGameBottomMenu bottomGameMenu) {
    this.bottomGameMenu = bottomGameMenu;
}

public Client getClient() {
    return client;
}

public void setClient(Client client) {
    this.client = client;
}

public JFrame getGameFrame() {
    return gameFrame;
}

public BoardPanel getBoardPanel() {
    return boardPanel;
}

public void setBoardPanel(BoardPanel boardPanel) {
    this.boardPanel = boardPanel;
}

public Board getChessBoard() {
    return chessBoard;
}

public void setChessBoard(Board chessBoard) {
    this.chessBoard = chessBoard;
}

public void setGameFrame(JFrame gameFrame) {
    this.gameFrame = gameFrame;
}
public void doSetClient(Client client) {
	this.client = client;
}
}

