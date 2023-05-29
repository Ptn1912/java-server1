package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import view.MainPage;

public class AccountDAO {
	private String userName, password;
	
	public AccountDAO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String checkLogin() {
		try {
            Connection connection = DBConnect.getJDBCConnection();
            PreparedStatement st = connection
                    .prepareStatement("Select T_TDN,T_MK from TA_LPN_ACCOUNT where T_TDN=? and T_MK=?");
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
           	 if(userName.equals("")||password.equals("")) {
           		 return "rong";
           	 }
           	 else{
           		return "ok";
           	 }
            } else {
                return "false";
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
		return null;
	}
}
