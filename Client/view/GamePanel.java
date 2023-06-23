package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Board.Board;
import Messages.Message;

import piece.Team;
import resources.GUI_Configurations;
import view.*;
import client.Client;
import controller.*;
public class GamePanel {
	 private JFrame gameFrame;
	 private BoardPanel boardPanel;
	 private Board chessBoard;
	  private InGameBottomMenu bottomGameMenu;
	private Client client ;

	
	 public GamePanel(Client client)
	 {
		 this.client = client;
		 this.gameFrame = new JFrame("Chess");
	        this.gameFrame.setLayout(new BorderLayout());
	        this.gameFrame.setSize(GUI_Configurations.OUTER_FRAME_DIMENSION);
	        createGamePanel();
	        this.gameFrame.setVisible(true);
	       
	 }
	 
	private void createGamePanel() {
		 this.chessBoard = new Board();
	     this.boardPanel = new BoardPanel(this.chessBoard, this.client);
	     this.bottomGameMenu = new InGameBottomMenu();
	     this.bottomGameMenu.getPlayersColorLBL().setText("Your color is " + this.client.getTeam().toString());
	     if (this.client.getTeam() == Team.WHITE) {
	         this.bottomGameMenu.getTurnLBL().setText("Your Turn");
	         this.bottomGameMenu.getTurnLBL().setForeground(Color.GREEN);
	     } else {
	         this.bottomGameMenu.getTurnLBL().setText("Enemy Turn");
	         this.bottomGameMenu.getTurnLBL().setForeground(Color.RED);
	     }

         this.gameFrame.add(boardPanel);
	     this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
	     this.gameFrame.add(this.bottomGameMenu, BorderLayout.PAGE_END);

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
}
	


