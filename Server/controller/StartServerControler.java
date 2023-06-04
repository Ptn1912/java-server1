package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DBConnect;
import server.Server;
import view.*;

public class StartServerControler {
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JButton btnStart, btnStop;
	private JLabel jlb_textShow;
	private Server server;
	
	public StartServerControler(JButton btnStart, JButton btnStop, JLabel jlb_textShow) {
		this.btnStart = btnStart;
		this.btnStop = btnStop;
		this.jlb_textShow = jlb_textShow;
	}
	
	private void fetchDataFromMySQL() {
        try {
        	Connection conn = DBConnect.getJDBCConnection();
            String query = "SELECT I_ID,T_EMAIL,T_TDN,T_TND,T_MK FROM TA_LPN_ACCOUNT";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery(query);
            tableModel.setRowCount(0);
            while (resultSet.next()) {
            	String id=resultSet.getString("I_ID");
                String email = resultSet.getString("T_EMAIL");
                String tdn = resultSet.getString("T_TDN");
                String tnd = resultSet.getString("T_TND");
                String mk = resultSet.getString("T_MK");
                tableModel.addRow(new Object[]{id,email, tdn, tnd, mk});
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	private void searchById(String searchId) {
	    try {
	        Connection conn = DBConnect.getJDBCConnection();
	        String query = "SELECT I_ID, T_EMAIL, T_TDN, T_TND, T_MK FROM TA_LPN_ACCOUNT WHERE I_ID = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, searchId);
	        ResultSet resultSet = ps.executeQuery();
	        tableModel.setRowCount(0);
	        while (resultSet.next()) {
	            String id = resultSet.getString("I_ID");
	            String email = resultSet.getString("T_EMAIL");
	            String tdn = resultSet.getString("T_TDN");
	            String tnd = resultSet.getString("T_TND");
	            String mk = resultSet.getString("T_MK");
	            tableModel.addRow(new Object[]{id, email, tdn, tnd, mk});
	        }
	        
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void setEvent() {
		btnStart.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			if (server == null) { // Kiểm tra xem đối tượng Server đã được khởi tạo hay chưa
		        server = new Server();
	            Thread serverThread = new Thread() {
	                @Override
		            public void run() {
	                	try {
	                		server.startServer();
	                	} catch (IOException ex) {
	                		ex.printStackTrace();
	                	}
	                }
	            };
	            serverThread.start();
	            jlb_textShow.setText("Server đang chạy");
	            jlb_textShow.setForeground(Color.green);
		        }
		    }
		});
		
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (server != null) { // Kiểm tra xem đối tượng Server đã được khởi tạo hay chưa
		            server.stopServer();
					server = null; // Đặt đối tượng Server về null sau khi dừng
					jlb_textShow.setText("Server đã đóng");
		            jlb_textShow.setForeground(Color.red);
		        }
			}
		});
		
	}
}

