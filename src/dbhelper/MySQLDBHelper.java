package dbhelper;

import java.sql.*;

public class MySQLDBHelper {

	public static boolean validateUser(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlinjection", "root", "root");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM user_details WHERE username = " + "'" + username + "' AND password = " + "'" + password + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs != null && rs.next()) {
				return true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static boolean validateUserUsingPreparedStatement(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlinjection", "root", "root");
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM user_details WHERE username = ? AND password = ?");  
			preparedStatement.setString(1, username);  
			preparedStatement.setString(2, password);  
			ResultSet rs = preparedStatement.executeQuery();
			if (rs != null && rs.next()) {
				return true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}