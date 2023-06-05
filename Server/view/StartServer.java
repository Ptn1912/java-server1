package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import dao.DBConnect;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartServer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textField;
	private int selectedRow = -1;
	private JButton btnStart, btnStop;
	private JLabel jlb_textShow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartServer frame = new StartServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartServer() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart = new JButton("START");
		btnStart.setForeground(new Color(0, 255, 0));
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnStart.setBackground(Color.WHITE);
		btnStart.setBounds(523, 42, 239, 57);
		contentPane.add(btnStart);
		JPanel panel = new JPanel();
		panel.setBounds(50, 21, 414, 177);
		contentPane.add(panel);

		panel.setLayout(null);
		tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Email");
        tableModel.addColumn("Tên đăng nhập");
        tableModel.addColumn("Tên người dùng");
        tableModel.addColumn("Mật khẩu");
        tableModel.addColumn("Điểm");
        
        
		jlb_textShow = new JLabel("...");
		jlb_textShow.setBackground(new Color(0, 255, 64));
		jlb_textShow.setFont(new Font("Tahoma", Font.BOLD, 40));
		jlb_textShow.setBounds(10, 51, 394, 79);
		panel.add(jlb_textShow);
		
		btnStop = new JButton("STOP");
		btnStop.setBackground(new Color(255, 255, 255));
		btnStop.setForeground(new Color(255, 0, 0));
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnStop.setBounds(523, 122, 239, 57);
		contentPane.add(btnStop);
		
		JButton btntimkiem = new JButton("Tìm kiếm");
		btntimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
		        searchById(id);
			}
		});
		btntimkiem.setBackground(new Color(192, 192, 192));
		btntimkiem.setForeground(new Color(255, 255, 128));
		btntimkiem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btntimkiem.setBounds(332, 226, 144, 43);
		contentPane.add(btntimkiem);
		
		table = new JTable(tableModel);
		 table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                // Get the selected row index
	                int selectedRow = table.getSelectedRow();

	                // Display a confirmation dialog
	                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?",
	                        "Confirm Deletion", JOptionPane.YES_NO_OPTION);

	                // If the user confirms the deletion, proceed with deleting the row
	                if (option == JOptionPane.YES_OPTION) {
	                    // Get the ID of the selected record
	                    String selectedId = table.getValueAt(selectedRow, 0).toString();

	                    // Delete the record from the database
	                    deleteRecord(selectedId);

	                    // Remove the selected row from the table
	                    tableModel.removeRow(selectedRow);
	                }
	            }
	        });
		table.setBounds(8, 320, 1066, 302);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 326, 822, 149);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setText("Nhập ID");
		textField.setBounds(66, 228, 238, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(StartServer.class.getResource("/images/pngtree-grain-texture-vintage-light-brown-background-image_846700.jpg")));
		lblNewLabel_3.setBounds(0, 0, 822, 316);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchDataFromMySQL();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(523, 226, 144, 45);
		contentPane.add(btnNewButton_1);
		fetchDataFromMySQL();
		setVisible(true);
		
		StartServerControler control = new StartServerControler(btnStart, btnStop, jlb_textShow);
		control.setEvent();
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
	

	private void deleteRecord(String id) {
	    try {
	        Connection conn = DBConnect.getJDBCConnection();
	        String query = "DELETE FROM TA_LPN_ACCOUNT WHERE I_ID = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, id);
	        ps.executeUpdate();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}