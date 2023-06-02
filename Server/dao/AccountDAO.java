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
	        
	        PreparedStatement typeStatement = connection.prepareStatement("SELECT T_TYPE FROM TA_LPN_ACCOUNT WHERE T_TDN = ? AND T_MK = ?");
	        typeStatement.setString(1, userName);
	        typeStatement.setString(2, password);
	        ResultSet typeResult = typeStatement.executeQuery();
	        if (typeResult.next()) {
	        	String type = typeResult.getString("T_TYPE");
	        	if(type.equals("us")){
	        		setResult("ok user"); 
	        		return "ok user"; 
	        	}else if(type.equals("ad")) {
	        		setResult("ok admin"); 
	        		return "ok admin"; 
	        	}else {
	        		return null;
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
             PreparedStatement emailStatement = connection.prepareStatement("SELECT T_EMAIL FROM TA_LPN_ACCOUNT WHERE T_EMAIL= ?");
             emailStatement.setString(1, email);
             ResultSet emailResult = emailStatement.executeQuery();
             
             PreparedStatement tdnStatement = connection.prepareStatement("SELECT T_TDN FROM TA_LPN_ACCOUNT WHERE T_TDN= ?");
             tdnStatement.setString(1, tdn);
             ResultSet tdnResult = tdnStatement.executeQuery();
             
             PreparedStatement tndStatement = connection.prepareStatement("SELECT T_TND FROM TA_LPN_ACCOUNT WHERE T_TND= ?");
             tndStatement.setString(1, tnd);
             ResultSet tndResult = tndStatement.executeQuery();
             
             if (emailResult.next()) {
                 setResult("exists email");
                 return "exists email"; // Trả về "exists" khi email đã tồn tại
             }else if(tdnResult.next()) {
            	 setResult("exists tdn");
                 return "exists tdn";
             }else if(tndResult.next()) {
            	 setResult("exists tnd");
                 return "exists tnd";
             }else {
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
