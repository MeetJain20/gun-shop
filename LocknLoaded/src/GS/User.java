package GS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Java-->Driver-->Mysql 
public class User extends preparedstmt{

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public void fun(Scanner sc, Integer Id1) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 2: Open a connection
			// System.out.println("Connecting to a selected database...");
			conn =  preparedstmt.pstmt();
			// System.out.println("Connected database successfully...");

			// STEP 3: Execute a query
			stmt = conn.createStatement();


			// Initialize our querying variable
			boolean flag = true;

			try {
				while (flag) {
					// Print the menu
					System.out.printf("\n\n- - - -╾━╤デ╦︻  Welcome To Lock 'N Loaded  ︻╦デ╤━╾- - - -\n\n\n");
					System.out.printf("Please choose an option \n\n");
					// 5 available options
					System.out.printf("1. List of all Fire Arms Models\n");
					System.out.printf("2. Model Details\n");
					System.out.printf("3. Purchase Fire Arms\n");
					System.out.printf("4. Check Your Orders\n");
					System.out.printf("5. Logout\n");
					System.out.printf("\n\n- - - -╾━╤デ╦︻ *********************** ︻╦デ╤━╾- - - -\n\n");

					System.out.printf("Enter Your Choice : ");
					String input = sc.nextLine();
					int reply;
					try {
						reply = Integer.valueOf(input);
					} catch (Exception e) {
						reply = -1;
					}
					if (reply == -1 || reply < 1 || reply > 5) {
						// User entered incorrect input
						System.out.printf("Incorrect Input !!!\n");
						System.out.printf("Please enter a number from 1-5\n");
					}

					else if (reply == 1) {
						String sql = "SELECT Gunmodel FROM model";

						try (ResultSet rs = stmt.executeQuery(sql)) {

							System.out.printf("Firearm Models : \n");
							while (rs.next()) {
								// Retrieve by column name
								String Gunmodel = rs.getString("Gunmodel");

								// Display values
								System.out.println(Gunmodel);
							}

							// Close the result set
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
							System.out.printf("Error! Could Not get result from the Database !!!\n");
						}
					}

					else if (reply == 2) {
						System.out.printf("Please enter the FireArm Model -> ");

						input = sc.nextLine();
						System.out.printf("\n");
						// Query the DB
						String sql = "SELECT * FROM model WHERE LOWER(Gunmodel) LIKE LOWER('%" + input + "%')";
						ResultSet rs = stmt.executeQuery(sql);
						boolean f = true;
						while (rs.next()) {
							f = false;
							// Retrieve by column name
							String Gunmodel = rs.getString("Gunmodel");
							String details = rs.getString("details");
							String Price = rs.getString("price");
							String Availablity = rs.getString("availability");

							// Display values
							System.out.print("Model: ");
							System.out.println(Gunmodel);
							System.out.print("Details: ");
							System.out.println(details);
							System.out.print("Price: ");
							System.out.println(Price);
							System.out.print("Availablity: ");
							System.out.println(Availablity);
							System.out.printf("\n");
						}

						if (f) {
							System.out.printf("This FireArm is not available...\n");
						}

						rs.close();
					}

					else if (reply == 3) {
						System.out.printf("Please Enter FireArm Model -> ");
						input = sc.nextLine();
						String sql = "SELECT availability FROM model WHERE LOWER(Gunmodel) = '" + input + "'";
						ResultSet rs = stmt.executeQuery(sql);

						if (rs.next()) {
							String Availablity = rs.getString("availability");

							int val = Integer.valueOf(Availablity);

							if (val <= 0) {
								System.out.printf("Currently Out of Stock It will be Available Soon !!!");
							} else {
								val = val - 1;

								String sql1 = "UPDATE model SET model.availability = ? where model.Gunmodel=?";
								PreparedStatement stmt1 = conn.prepareStatement(sql1);
								stmt1.setInt(1, val);
								stmt1.setString(2, input);
								stmt1.executeUpdate();
								System.out.printf("Enter your Address : ");
								String addr = sc.nextLine();
								System.out.printf("Enter Phone number : ");
								String Phno = sc.nextLine();
								String sql2 = "INSERT INTO LogBook Values" + "(" + Id1 + ", " + "'" + input + "', "
										+ "'" + addr + "'," + "'" + Phno + "')";
								stmt.execute(sql2);

								System.out.printf("Order Placed !!!");
							}
						}

						else {
							System.out.printf("This FireArm is not available...!!!\n");
						}
						rs.close();
					}

					else if (reply == 4) {
						String sql = "SELECT Gunmodel FROM LogBook where custid = '" + Id1 + "'";

						try (ResultSet rs = stmt.executeQuery(sql)) {
							boolean m = true;
							while (rs.next()) {
								// Retrieve by column name
								m = false;
								String Gunmodel = rs.getString("Gunmodel");

								// Display values
								System.out.println(Gunmodel);
							}
							if (m) {
								System.out.println("No Orders");
							}

							// Close the result set
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
							System.out.printf("Error! Could Not get result from the Database !!!\n");
						}
					}

					else if (reply == 5) {
						flag = false;

					}

				}

			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();

				// Inform user of error
				System.out.printf("Error closing connection to the database !!!\n");
			} // end finally try
		} // end try

	}

}