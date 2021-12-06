package GS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Signup extends preparedstmt{
	static String idval = "";

	public void sign(Scanner scan) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn =  preparedstmt.pstmt();
			stmt = conn.createStatement();
			System.out.printf("\n\n- - - -╾━╤デ╦︻  SIGN UP PAGE  ︻╦デ╤━╾- - - -\n\n\n");
			try {
				String name = "";
				String password = "";
				String email = "";
				String phnnum = "";
				System.out.printf("ENTER YOUR NAME : ");
				name = scan.nextLine();

				System.out.printf("SET YOUR PASSWORD : ");
				password = scan.nextLine();

				System.out.printf("ENTER YOUR EMAIL ID : ");
				email = scan.nextLine();

				System.out.printf("ENTER YOUR PHONE NUMBER : ");
				phnnum = scan.nextLine();

				String sql = "INSERT INTO user(password,name,email,phoneNo) VALUES ('" + password + "', " + "'" + name
						+ "', " + "'" + email + "', " + "'" + phnnum + "');";
				stmt.execute(sql);

				System.out.printf("ACCOUNT ADDED SUCCESSFULLY ADDED !!!\n\n");
				sql = "Select custid From user order by custid desc limit 0,1;";
//         password = '"+ password +"' 
				try (ResultSet rs = stmt.executeQuery(sql)) {
					while (rs.next()) {
						// Retrieve by column name
						idval = rs.getString("custid");
					}
					// Close the result set
					rs.close();
				}
				System.out.printf("ID ASSIGNED TO YOU IS : ");
				System.out.printf(idval);
				System.out.printf("\n");
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
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
				System.out.println("Error closing connection to the database!");
			}
		}
	}
}