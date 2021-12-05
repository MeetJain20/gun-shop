/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Adminpage {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://Localhost:3306/test";
	static final String USER = "Enter your username";
	static final String PASS = "Enter Your pass";

	public void adpage(Scanner scan){
		Connection conn = null;
		Statement stmt = null;
		try{
		      //STEP 1: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 2: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 3: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      boolean querying = true;
		      System.out.println("Admin Page");
		      
		      try  {
		    	  while(querying)
		           {
		               //Print the menu
		    		   System.out.println();
		        	   System.out.println("********************************");
		               System.out.println("Please select a query below!");
		       
		               System.out.println("1. Enter New Model");
		               System.out.println("2. Update Price ");
		               System.out.println("3. Update Availablity");
		               System.out.println("4. Delete Model");
		               System.out.println("5. Place Order");
		               System.out.println("6. Logout");
		               System.out.println("********************************");
		               System.out.println();
		               
		               System.out.println("Enter Your Choice");
		               String input = scan.nextLine();
		               int answer;
		               try{
		            	   answer=Integer.valueOf(input);
		               }
		               catch(Exception e)
		               {
		            	   answer=-1;
		               }
		               if(answer == -1 || answer < 1 || answer > 6)
		               {
		                   //User entered incorrect input
		                   System.out.println("Incorrect Input!");
		                   System.out.println("Please enter a number 1-6");
		               }
		               
		               else if (answer==1)
		               {
		            	   String Model = "";
		                   String Details = "";
		                   Integer Price = 0;
		                   Integer Avail = 0;
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter Details");
		 		    	   Details = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter Price");
		 		    	   Price = scan.nextInt();
		 		    	  
		 		    	   System.out.println("Enter Availablity");
		 		    	   Avail = scan.nextInt();
		 		    	   String sql = "INSERT INTO wm VALUES " + "( '"+ Model + "' , " + "'" + Details + "', " + "" + Price + ", " + "" + Avail + ")";
				    	   stmt.execute(sql);
				    	   System.out.println("Success!");
		               }
		               
		               else if (answer==2)
		               {
		            	   String Model = "";  
		                   Integer Price = 0;
		                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter New Price");
		 		    	   Price = scan.nextInt();
		 		    	  
		 		    	   String sql1 = "UPDATE wm SET wm.Price = ? where wm.Title=?";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.setInt(1, Price);
	                	   stmt1.setString(2, Model);
	                	   stmt1.executeUpdate();
				    	   System.out.println("Success!");
		               }
		               
		               else if (answer==3)
		               {
		            	   String Model = "";  
		                   Integer Avail = 0;
		                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter New Availablity");
		 		    	   Avail = scan.nextInt();
		 		    	  
		 		    	   String sql1 = "UPDATE wm SET wm.Availablity = ? where wm.Title=?";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.setInt(1, Avail);
	                	   stmt1.setString(2, Model);
	                	   stmt1.executeUpdate();
				    	   System.out.println("Success!");
		               }
		               
		               else if (answer==4)
		               {
		            	   String Model = "";  
		                   
		                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	   String sqlDel = "DELETE FROM wm WHERE LOWER(Title) LIKE LOWER('%" + Model + "%')";
	                       
	                       //Execute the sql
	                       stmt.execute(sqlDel);
	                       
	                       System.out.println("Model deleted!");
				    	   
		               }
		               
		               else if (answer==5){
		            	   String Model = "";  
		                   
			                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	   String sqlDel = "DELETE FROM book WHERE LOWER(Model) LIKE LOWER('%" + Model + "%')";
	                       
	                       //Execute the sql
	                       stmt.execute(sqlDel);
	                       
	                       System.out.println("Model Ordered!");
				    	 
		            	   
		               }
		               
		               else if (answer==6)
		               {
		            	   
		            	   querying= false;
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
		return;
	}

}
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Adminpage {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://Localhost:3306/test";
	static final String USER = "Enter your username";
	static final String PASS = "Enter Your password";

	public void adpage(Scanner scan){
		Connection conn = null;
		Statement stmt = null;
		try{
		      Class.forName(JDBC_DRIVER);
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      stmt = conn.createStatement();
		      
		      boolean querying = true;
		      System.out.printf("\n\n- - - -╾━╤デ╦︻  LOGIN PAGE  ︻╦デ╤━╾- - - -\n\n\n");
		      
		      try  {
		    	  while(querying)
 
 		           {
		               //Print the menu
		    		   System.out.println();
		        	   System.out.printf("\n********************************\n");
		               System.out.printf("Please select a query below!\n\n");		       
		               System.out.printf("1. Enter New Model\n");
		               System.out.printf("2. Update Price\n");
		               System.out.printf("3. Update Availablity\n");
		               System.out.printf("4. Delete Model\n");
		               System.out.printf("5. Place Order\n");
		               System.out.printf("6. Logout\n");
		               System.out.printf("\n********************************\n");
		               System.out.println();
		               
		               System.out.printf("\nEnter Your Choice\n");
		               String input = scan.nextLine();
		               int answer;
		               try{
		            	   answer=Integer.valueOf(input);
		               }
		               catch(Exception e)
		               {
		            	   answer=-1;
		               }
		               if(answer == -1 || answer < 1 || answer > 6)
		               {
		                   //User entered incorrect input
		                   System.out.printf("\nIncorrect Input!\n");
		                   System.out.printf("Please enter a number 1-6\n");
		               }
		               
		               else if (answer==1)
		               {
		            	   String Model = "";
		                   String Details = "";
		                   Integer Price = 0;
		                   Integer Avail = 0;
		 		    	   System.out.printf("\nEnter Model No\n");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.printf("Enter Details\n");
		 		    	   Details = scan.nextLine();
		 		    	  
		 		    	   System.out.printf("Enter Price\n");
		 		    	   Price = scan.nextInt();
		 		    	  
		 		    	   System.out.printf("Enter Availablity\n");
		 		    	   Avail = scan.nextInt();
		 		    	   String sql = "INSERT INTO wm VALUES " + "( '"+ Model + "' , " + "'" + Details + "', " + "" + Price + ", " + "" + Avail + ")";
				    	   stmt.execute(sql);
				    	   System.out.printf("\nSuccess!\n");
		               }
		               
		               else if (answer==2)
		               {
		            	   String Model = "";  
		                   Integer Price = 0;
		                 
		 		    	   System.out.printf("\nEnter Model No\n");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.printf("Enter New Price\n");
		 		    	   Price = scan.nextInt();
		 		    	  
		 		    	   String sql1 = "UPDATE wm SET wm.Price = ? where wm.Title=?";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.setInt(1, Price);
	                	   stmt1.setString(2, Model);
	                	   stmt1.executeUpdate();
				    	   System.out.printf("\nSuccess!\n");
		               }
		               
		               else if (answer==3)
		               {
		            	   String Model = "";  
		                   Integer Avail = 0;
		                 
		 		    	   System.out.printf("\nEnter Model No\n");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.printf("Enter New Availablity\n");
		 		    	   Avail = scan.nextInt();
		 		    	  
		 		    	   String sql1 = "UPDATE wm SET wm.Availablity = ? where wm.Title=?";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.setInt(1, Avail);
	                	   stmt1.setString(2, Model);
	                	   stmt1.executeUpdate();
				    	   System.out.printf("\nSuccess!\n");
		               }
		               else if (answer==4)
		               {
		            	   String Model = "";  
		 		    	   System.out.printf("\nEnter Model No\n");
		 		    	   Model = scan.nextLine();
		 		    	   String sqlDel = "DELETE FROM wm WHERE LOWER(Title) LIKE LOWER('%" + Model + "%')";
	                       stmt.execute(sqlDel);
	                       System.out.printf("\nModel deleted!\n");
		               }
		               else if (answer==5){
		            	   String Model = "";  
		 		    	   System.out.printf("\nEnter Model No\n");
		 		    	   Model = scan.nextLine();
		 		    	   String sqlDel = "DELETE FROM book WHERE LOWER(Model) LIKE LOWER('%" + Model + "%')";
	                       stmt.execute(sqlDel);
	                       System.out.printf("\nModel Ordered!\n");
		               }
		               else if (answer==6)
		               {
		            	   querying= false;
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
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		         System.out.printf("\nError closing connection to the database!\n");
		      }
		   }
		return;
	}

}
