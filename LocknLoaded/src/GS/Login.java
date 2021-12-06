package GS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login extends preparedstmt {
	public void log(Scanner scan) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =  preparedstmt.pstmt();
			stmt = conn.createStatement();
			System.out.printf("\n\n- - - -╾━╤デ╦︻  LOGIN PAGE  ︻╦デ╤━╾- - - -\n\n\n");
			try {
				System.out.printf("ENTER YOUR ID : ");
				String input = scan.nextLine();
				int idv = 0;
				try {
					idv = Integer.valueOf(input);
				} catch (Exception e) {
					System.out.printf("ENTER CORRECT ID !!!\n");
				}
				System.out.printf("ENTER YOUR PASSWORD : ");
				String Password = scan.nextLine();

				String sql = "SELECT password FROM user where custId=" + idv + "";
				try (ResultSet rs = stmt.executeQuery(sql)) {

					while (rs.next()) {
						String title = rs.getString("Password");
//                          System.out.println(title); 
						if (title.equals(Password)) {
							System.out.printf("LOGIN SUCCESSFUL !!!!\n");
							User U = new User();
							U.fun(scan, idv);
						} else {
							System.out.printf("INCORRECT PASSWORD !!!\n");
						}
					}
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("Error! Invalid Username\n");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.printf("Error closing connection to the database !!!\n");
			}
		}
	}
}