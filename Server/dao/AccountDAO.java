package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import view.MainPage;

public class AccountDAO {
    private String userName;
    private String password;

    public AccountDAO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean checkLogin() {
        try {
            Connection connection = DBConnect.getJDBCConnection();
            PreparedStatement st = connection.prepareStatement("SELECT T_TDN, T_MK FROM TA_LPN_ACCOUNT WHERE T_TDN=? AND T_MK=?");
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            // Kiểm tra xem ResultSet có kết quả hay không
            if (rs.next()) {
                // Kết quả đăng nhập đúng
                return true;
            } else {
                // Kết quả đăng nhập sai
                return false;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }
}
