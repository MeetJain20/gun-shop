package GS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Adminpage extends preparedstmt {

	public void adpage(Scanner scan) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			conn =  preparedstmt.pstmt();
			// STEP 3: Execute a query
			// System.out.printf("Creating statement...\n");
			stmt = conn.createStatement();

			boolean querying = true;
			System.out.printf("\n\n- - - -╾━╤デ╦︻  Admin Page  ︻╦デ╤━╾- - - -\n\n\n");

			try {
				while (querying) {
					// Print the menu
					System.out.printf("\n\n- - - -╾━╤デ╦︻ *********************** ︻╦デ╤━╾- - - -\n\n");
					System.out.println("Please select a query below!");

					System.out.printf("1. Enter New Model\n");
					System.out.printf("2. Update Price\n");
					System.out.printf("3. Update Availablity\n");
					System.out.printf("4. Delete Model\n");
					System.out.printf("5. Print All Customer Details\n");
					System.out.printf("6. Search Customer by Customer ID\n");
					System.out.printf("7. Logout\n");
					System.out.printf("\n\n- - - -╾━╤デ╦︻ *********************** ︻╦デ╤━╾- - - -\n\n");

					System.out.printf("Enter Your Choice : ");
					String input = scan.nextLine();
					int answer;
					try {
						answer = Integer.valueOf(input);
					} catch (Exception e) {
						answer = -1;
					}
					if (answer == -1 || answer < 1 || answer > 7) {
						// User entered incorrect input
						System.out.printf("Incorrect Input !!!\n");
						System.out.printf("Please enter a number from 1-7 !!!\n");
					}

					else if (answer == 1) {
						String Model = "";
						String Details = "";
						Integer Price = 0;
						Integer Avail = 0;
						System.out.printf("Enter Firearm Model : ");
						Model = scan.nextLine();

						System.out.printf("Enter Firearm Details : ");
						Details = scan.nextLine();

						System.out.printf("Enter Price : ");
						String in = scan.nextLine();
						try {
							Price = Integer.valueOf(in);
						} catch (Exception e) {
							System.out.printf("Price should be in numbers !!!\n");
						}

						System.out.printf("Enter Availablity \n");
						in = scan.nextLine();
						try {
							Avail = Integer.valueOf(in);
						} catch (Exception e) {
							System.out.printf("Availability should be in numbers !!!\n");
						}

						String sql = "INSERT INTO model VALUES " + "( '" + Model + "' , " + "'" + Details + "', " + ""
								+ Price + ", " + "" + Avail + ")";
						try {
							stmt.execute(sql);
							System.out.printf("Successfully Inserted !!!\n");
						} catch (SQLException e) {
							System.out.printf("FireArm Model already exists\n");
						}

					}

					else if (answer == 2) {
						String in;
						String Model = "";
						Integer Price = 0;

						System.out.printf("Enter FireArm Model : ");
						Model = scan.nextLine();

						System.out.printf("Enter New Price : ");
						in = scan.nextLine();
						try {
							Price = Integer.valueOf(in);
						} catch (Exception e) {
							System.out.printf("Price should be in numbers !!!\n");
						}

						String sql1 = "UPDATE model SET price = ? where Gunmodel=?";
						PreparedStatement stmt1 = conn.prepareStatement(sql1);
						stmt1.setInt(1, Price);
						stmt1.setString(2, Model);
						try {
							stmt1.executeUpdate(sql1);
							System.out.printf("Successfully Updated Price !!!\n");
						} catch (SQLException e) {
							e.printStackTrace();
							System.out.printf("FireArm Model already exists !!!\n");
						}
					}

					else if (answer == 3) {
						String Model = "";
						Integer Avail = 0;

						System.out.printf("Enter FireArm model : ");
						Model = scan.nextLine();

						System.out.printf("Enter New Availability : ");
						String in = scan.nextLine();
						try {
							Avail = Integer.valueOf(in);
						} catch (Exception e) {
							System.out.printf("Availability should be in numbers !!!\n");
						}

						String sql1 = "UPDATE model SET availability = '" + Avail + "' where Gunmodel= '" + Model + "'";
						PreparedStatement stmt1 = conn.prepareStatement(sql1);
						boolean x = stmt1.execute(sql1);
						if (x)
							System.out.printf("Successfully Updated Availability !!!\n");
						else
							System.out.printf("Wrong Model Name !!!\n");
					}

					else if (answer == 4) {
						String Model = "";

						System.out.println("Enter Firearm Model : ");
						Model = scan.nextLine();
						String sqlDel = "DELETE FROM model WHERE LOWER(Gunmodel) LIKE LOWER('%" + Model + "%')";

						// Execute the sql
						stmt.execute(sqlDel);

						System.out.println("The Firearm Model is deleted !!!\n");

					}

					else if (answer == 5) {
						System.out.println("User Present Are : \n");
						String mee = "Select * from user";
						try (ResultSet rs = stmt.executeQuery(mee)) {
							boolean mt = true;
							while (rs.next()) {
								mt = false;
								String CustID = rs.getString("custid");
								System.out.println(CustID);
								String CustName = rs.getString("name");
								System.out.println(CustName);
								String CustEmail = rs.getString("email");
								System.out.println(CustEmail);
								String CustPhone = rs.getString("phoneNo");
								System.out.println(CustPhone);
								System.out.printf("\n\n");
							}
							if (mt) {
								System.out.println("No User present with Given Customer Id !!!\n");
							}

							// Close the result set
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
							System.out.printf("Error! Could Not get result from the Database !!!\n");
						}

					}

					else if (answer == 6) {
						int Cust_id = 0;
						System.out.printf("Enter Customer ID : ");
						String in = scan.nextLine();
						try {
							Cust_id = Integer.valueOf(in);
						} catch (Exception e) {
							System.out.printf("Availability should be in numbers !!!\n");
						}
						System.out.println("User Present with Given Customer Id Is : \n");
						String me = "Select * from user where custid = " + Cust_id + "";
						try (ResultSet rs = stmt.executeQuery(me)) {
							boolean m = true;
							while (rs.next()) {
								m = false;
								String CustID = rs.getString("custid");
								System.out.println(CustID);
								String CustName = rs.getString("name");
								System.out.println(CustName);
								String CustEmail = rs.getString("email");
								System.out.println(CustEmail);
								String CustPhone = rs.getString("phoneNo");
								System.out.println(CustPhone);
							}
							if (m) {
								System.out.println("No User present with Given Customer Id !!!\n");
							}

							// Close the result set
							rs.close();
						} catch (Exception e) {
							e.printStackTrace();
							System.out.printf("Error! Could Not get result from the Database !!!\n");
						}

					} else if (answer == 7) {

						querying = false;
					}
				}

			}

			catch (Exception e) {
				System.out.println(e);
			}

		} catch (SQLException e) {
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
		return;
	}

}
