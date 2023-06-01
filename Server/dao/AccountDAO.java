package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import view.MainPage;

public class AccountDAO {
	private String userName, password;
	private String result,result1;
	private String email,tdn,tnd,mk,mkagain;
	public AccountDAO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public AccountDAO(String email,String tdn,String tnd,String mk, String mkagain) {
		this.email=email;
		this.tdn=tdn;
		this.tnd=tnd;
		this.mk=mk;
		this.mkagain = mkagain;
	}

	public String checkLogin() {
	    try {
	        Connection connection = DBConnect.getJDBCConnection();
	        PreparedStatement st = connection.prepareStatement("SELECT T_TDN, T_MK FROM TA_LPN_ACCOUNT WHERE T_TDN = ? AND T_MK = ?");
	        st.setString(1, userName);
	        st.setString(2, password);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	        	if(userName.isEmpty()||password.isEmpty()) {
	        		setResult("rong");
	        		return "rong";
	        	}
	        	else{
	        		setResult("ok"); 
	        		return "ok"; 
	        	}
	            // Trả về "ok" khi đăng nhập thành công
	        } else {
	            setResult("failed"); // Đăng nhập không thành công, gọi phương thức setResult()
	            return "failed"; // Trả về "failed" khi tên đăng nhập hoặc mật khẩu sai
	        }
	    } catch (SQLException sqlException) {
	        // Ném lại ngoại lệ hoặc trả về giá trị mặc định
	        throw new RuntimeException("Lỗi khi thực hiện truy vấn SQL", sqlException);
	    }
	}
    
    public String checkSignup() {
    	try {
             Connection connection = DBConnect.getJDBCConnection();
             PreparedStatement st = connection.prepareStatement("SELECT T_EMAIL,T_TDN FROM TA_LPN_ACCOUNT WHERE T_EMAIL= ? OR T_TDN = ?");
             st.setString(1, email);
             st.setString(2, tdn);
             ResultSet rs = st.executeQuery();
             if (rs.next()) {
                 setResult1("exists");
                 return "exists"; // Trả về "exists" khi tên đăng nhập hoặc email đã tồn tại
             } else {
                 // Tiến hành đăng ký tài khoản
                 PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO TA_LPN_ACCOUNT(T_EMAIL,T_TDN,T_TND,T_MK) VALUES (?, ?, ?, ?)");
                 insertStatement.setString(1, email);
                 insertStatement.setString(2, tdn);
                 insertStatement.setString(3, tnd);
                 insertStatement.setString(4, mk);
                 insertStatement.executeUpdate();

                 setResult("success");
                 return "success"; // Trả về "success" khi đăng ký thành công
             }
         } catch (SQLException sqlException) {
             // Ném lại ngoại lệ hoặc trả về giá trị mặc định
             throw new RuntimeException("Lỗi khi thực hiện truy vấn SQL", sqlException);
         }
     }
    
    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
    
    public void setResult1(String result1) {
        this.result1 = result1;
    }
    public String getResult1() {
        return result1;
    }



}
