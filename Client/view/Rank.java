package	view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import client.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.*;
import dao.DBConnect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Rank extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private int selectedRow = -1;
	private Client client;
	public Rank(Client client) {
		this.client  = client;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                	client.doSendSignal("close");
					client.closeClient();
				} catch (Exception e1) {
					e1.printStackTrace();
				};
            }
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên người dùng");
        tableModel.addColumn("Điểm");
		
		table = new JTable(tableModel);
		 
		table.setBounds(8, 320, 1066, 302);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(460, 141, 319, 337);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Trang chủ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage mp=new MainPage(client);
				mp.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(45, 207, 189, 68);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Rank.class.getResource("/images/rank-img.png")));
		lblNewLabel.setBounds(0, 0, 928, 572);
		contentPane.add(lblNewLabel);
		
		
		fetchDataFromMySQL();
		setVisible(true);
	}
	private void fetchDataFromMySQL() {
	        try {
	        	Connection conn = DBConnect.getJDBCConnection();
	            String query = "SELECT I_ID,T_TND,I_DIEM FROM TA_LPN_XEPHANG";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ResultSet resultSet = ps.executeQuery(query);
	            tableModel.setRowCount(0);
	            while (resultSet.next()) {
	            	String id=resultSet.getString("I_ID");
	                String tnd = resultSet.getString("T_TND");
	                String diem = resultSet.getString("I_DIEM");
	                tableModel.addRow(new Object[]{id,tnd, diem});
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}

