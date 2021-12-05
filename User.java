
package Gun_Shop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


// Java-->Driver-->Mysql
public class User {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String URL = "jdbc:mysql://Localhost:3306/Gunshop";
	static final String USER = "root";
	static final String PASS = "dbms";

	public void fun(Scanner sc, Integer Id1)
	{
		Connection conn = null;
		Statement stmt = null;
		try{
		      //STEP 1: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 2: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 3: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      
		      //Welcome user!
		      System.out.println("Welcome to the Lock'n Loaded");
		      
		      //Initialize our querying variable
		      boolean flag = true;
		      
		      try  {
		           while(flag)
		           {
		               //Print the menu
		        	   System.out.println();
		        	   System.out.println("********************************");
		               System.out.println("Please choose an option->");
		               //5 available options
		               System.out.println("1. List of all Fire Arms Models");
		               System.out.println("2. Model Details");
		               System.out.println("3. Purchase Fire Arms");
		               System.out.println("4. Check Your Orders");
		               System.out.println("5. Dashboard");
		               System.out.println("6. Logout");
		               System.out.println("********************************");
		               System.out.println();
		               
		               System.out.println("Enter Your Choice");
		               String input = sc.nextLine();
		               int reply;
		               try{
		            	   reply=Integer.valueOf(input);
		               }
		               catch(Exception e)
		               {
		            	   reply=-1;
		               }
		               if(reply == -1 || reply < 1 || reply > 5)
		               {
		                   //User entered incorrect input
		                   System.out.println("Incorrect Input!");
		                   System.out.println("Please enter a number 1-5");
		               }
		               
		               else if (reply == 1)
		               {
		            	   String sql = "SELECT Gunmodel FROM model";
		            	   
		                   try (ResultSet rs = stmt.executeQuery(sql)) {
		                       
		                       System.out.println("Gun Models:");
		                       while(rs.next()){
		                           //Retrieve by column name
		                           String Gunmodel = rs.getString("Gunmodel");
		                           
		                           //Display values
		                           System.out.println(Gunmodel);
		                       }
		                       
		                       //Close the result set
		                       rs.close();
		                   }
		                   catch(Exception e) {
		                        e.printStackTrace();
		                        System.out.println("Error! Could Not get result from the Database");
		                   }
		               }
		               
		               
		               else if (reply == 2)
		               {
		            	   System.out.println("Please enter the FireArm Model ->");
		                   
		            	  
		                   input = sc.nextLine();
		                   
		                   //Query the DB
		                   String sql = "SELECT * FROM model WHERE LOWER(Gunmodel) LIKE LOWER('%" + input + "%')";
		                   ResultSet rs = stmt.executeQuery(sql);
		                   
		                   if(rs.next())
		                   {
		                       //Retrieve by column name
		                       String Gunmodel = rs.getString("Gunmodel");
		                       String details = rs.getString("details");
		                       String Price = rs.getString("price");
		                       String Availablity = rs.getString("availability");
		                       
		                       //Display values
		                       System.out.print("Model: ");
		                       System.out.println(Gunmodel);
		                       System.out.print("Details: ");
		                       System.out.println(details);
		                       System.out.print("Price: ");
		                       System.out.println(Price);
		                       System.out.print("Availablity: ");
		                       System.out.println(Availablity);
		                       
		                   }
		                   else
		                   {
		                       System.out.println("This FireArm is not available...");
		                   }
		                   
		                   rs.close();
		               }
		               
		               
		               else if (reply==3)
		               {
		            	   System.out.println("Please Enter FireArm Model ->");
		                   input = sc.nextLine();
		                   String sql = "SELECT availablity FROM model WHERE LOWER(Gunmodel) LIKE LOWER('%" + input + "%')";
		                   ResultSet rs = stmt.executeQuery(sql);
		                 
		                   if(rs.next())
		                   {
			                   String Availablity = rs.getString("availablity");
			                   
			                   int val=Integer.valueOf(Availablity);
			                   
			                   if (val<=0)
			                   {
			                	   System.out.println("Out of Stock");
			                   }
			                   else
			                   {
			                	   val=val-1;
			                	   
			                	   String sql1 = "UPDATE model SET model.availablity = ? where model.Gunmodel=?";
			                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
			                	   stmt1.setInt(1, val);
			                	   stmt1.setString(2, input);
			                	   stmt1.executeUpdate();
			                	   System.out.println("Enter your Address");
			                	   String addr= sc.nextLine();
			                	   String sql2 = "INSERT INTO model Values" + "("+ Id1 + ", " + "'" + input + "', " + "'" + addr + "')";
			                	   stmt.execute(sql2);
			     	
			                	   System.out.println("Order Placed");
			                   }
		                   }
		                   
		                   else
		                   {
		                	   System.out.println("This FireArm is not available..."); 
		                   }
		                   rs.close();
		               }
		               
		               
		               else if (reply == 4)
		               {
		            	   String sql = "SELECT Gunmodel FROM LogBook where custid = "+Id1+"";
		            	   
		                   try (ResultSet rs = stmt.executeQuery(sql)) {
		                	   
		                	   System.out.println("Gun Model :");
		                       while(rs.next()){
		                           //Retrieve by column name
		                           String Gunmodel = rs.getString("Model");
		                           
		                           //Display values
		                           System.out.println(Gunmodel);
		                           
		                       }
		                       
		                       //Close the result set
		                       rs.close();
		                   }
		                   catch(Exception e) {
		                        e.printStackTrace();
		                        System.out.println("Error! Could Not get result from the Database");
		                   }
		               }
		               
		               else if (reply == 5)
		               {
		            	   System.out.println("Dashboard");
		            	   System.out.println("********************************");
			               System.out.println("Please select a query below!");
			               //5 available options
			               System.out.println("1. Cart");
			               System.out.println("2. Edit information ");
			               System.out.println("3. Buy");
			       
			               System.out.println("4. Exit from Dashboard");
			               System.out.println("********************************");
			               
			               System.out.println("Enter Your Choice");
			               String input1 = sc.nextLine();
			               int reply1;
			               try{
			            	   reply1=Integer.valueOf(input1);
			               }
			               catch(Exception e)
			               {
			            	   reply1=-1;
			               }
			               if(reply1 == -1 || reply1 < 1 || reply1 > 4)
			               {
			                   //User entered incorrect input
			                   System.out.println("Incorrect Input!");
			                   System.out.println("Please enter a number 1-5");
			               }
			               
			               else if (reply1==1)
			               {
			            	   String sql = "SELECT Gunmodel FROM LogBook where custid = "+Id1+"";
			            	   
			                   try (ResultSet rs = stmt.executeQuery(sql)) {
			                	   
			                	   System.out.println("FireArm model: ");
			                       while(rs.next()){
			                           //Retrieve by column name
			                           String title = rs.getString("Model");
			                           
			                           //Display values
			                           System.out.println(title);
			                           
			                       }
			                       
			                       //Close the result set
			                       rs.close();
			                   }
			                   catch(Exception e) {
			                        e.printStackTrace();
			                        System.out.println("Error! Could Not get result from the Database");
			                   }
			            	   
			               }
			               
			               else if (reply1==3)
			               {
			            	   System.out.println("Enter your Address: ");
		                	   String addr= sc.nextLine();
		                	   String sql2 = "INSERT INTO LogBook Values" + "("+ Id1 + ", " + "'" + input + "', " + "'" + addr + "')";
		                	   stmt.execute(sql2);
		     	
			               }
		               }
		               else if (reply == 6)
		               {
		            	   flag = false;
		            	   
		               }
		               
		           }
	
		      }
		      catch (Exception e)
		      {
		    	  System.out.println(e);
		      }
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		         
		         //Inform user of error
		         System.out.println("Error closing connection to the database!");
		      }//end finally try
		   }//end try
		   System.out.println("Rock'n Roll Baby!");

	}

}
