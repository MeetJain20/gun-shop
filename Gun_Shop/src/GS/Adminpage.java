package GS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Adminpage {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://Localhost:3306/firearms";
	static final String USER = "root";
	static final String PASS = "kali";

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
		               System.out.println("5. Logout");
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
		               if(answer == -1 || answer < 1 || answer > 5)
		               {
		                   //User entered incorrect input
		                   System.out.println("Incorrect Input!");
		                   System.out.println("Please enter a number 1-5");
		               }
		               
		               else if (answer==1)
		               {
		            	   String Model = "";
		                   String Details = "";
		                   Integer Price = 0;
		                   Integer Avail = 0;
		 		    	   System.out.println("Enter FireArm Name");
		 		    	   Model = scan.nextLine();
		 		    	   String sql1 = "SELECT Gunmodel FROM model WHERE LOWER(Gunmodel) = '"+Model+"'";
		                   ResultSet rs = stmt.executeQuery(sql1);
		                   if(rs.next()) {
		                	   System.out.println("FireArm Already exists in Database!");
		                   }
		                   else {
		 		    	   System.out.println("Enter Details");
		 		    	   Details = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter Price");
		 		    	   String in = scan.nextLine();
		 		    	  try{
			            	   Price=Integer.valueOf(in);
			               }
			              catch(Exception e)
			               {
			            	   System.out.println("Price should be in numbers!");
			               }
		 		    	   
		 		    	  
		 		    	   System.out.println("Enter Availablity");
		 		    	   in = scan.nextLine();
		 		    	  try{
		 		    		 Avail = Integer.valueOf(in);
			               }
			              catch(Exception e)
			               {
			            	   System.out.println("Availability should be in numbers!");
			               }
		 		    	   
		 		    	   String sql = "INSERT INTO model VALUES " + "( '"+ Model + "' , " + "'" + Details + "', " + "" + Price + ", " + "" + Avail + ")";
		 		    	   stmt.execute(sql);
				    	   System.out.println("Success!");
				    	   }
		               	}   
		               
		               
		               else if (answer==2)
		               {	String in;
		            	   String Model = "";  
		                   Integer Price = 0;
		                 
		 		    	   System.out.println("Enter FireArm Model");
		 		    	   Model = scan.nextLine();
		 		    	  String sql1 = "SELECT Gunmodel FROM model WHERE LOWER(Gunmodel) = '"+Model+"'";
		                   ResultSet rs = stmt.executeQuery(sql1);
		                   if(!rs.next()) {
		                	   System.out.println("Wrong FireArm Model");
		                   }
		                   else {
		 		    	  
		 		    	   System.out.println("Enter New Price");
		 		    	   in = scan.nextLine();
		 		    	   try{
			 		    		 Price = Integer.valueOf(in);
				               }
				              catch(Exception e)
				               {
				            	   System.out.println("Price should be in numbers!");
				               }
		 		    	  
		 		    	  
		 		    	  sql1 = "UPDATE model SET price = '"+Price+"' where Gunmodel= '"+Model+"'";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.executeUpdate(sql1);
				    	   System.out.println("Success!");
	                	   }
		               }
		               
		               else if (answer==3)
		               {
		            	   String Model = "";  
		                   Integer Avail = 0;
		                 
		 		    	   System.out.println("Enter FireArm model");
		 		    	   Model = scan.nextLine(); 
		 		    	   String sql1 = "SELECT Gunmodel FROM model WHERE LOWER(Gunmodel) = '"+Model+"'";
		                   ResultSet rs = stmt.executeQuery(sql1);
		                   if(!rs.next()) {
		                	   System.out.println("Wrong FireArm Model");
		                   }
		                   else {
		 		    	   System.out.println("Enter New Availability");
		 		    	   String in = scan.nextLine();
		 		    	   	try{
			 		    		 Avail = Integer.valueOf(in);
				               }
				              catch(Exception e)
				               {
				            	   System.out.println("Availability should be in numbers!");
				               }
		 		    	 
		 		    	   sql1 = "UPDATE model SET availability = '"+Avail+"' where Gunmodel= '"+Model+"'";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.execute(sql1);
				    	   System.out.println("Success!");
		                   }
		                   rs.close();
		               }
		               
		               else if (answer==4)
		               {
		            	   String Model = "";  
		                   
		                 
		 		    	   System.out.println("Enter FireArm Name");
		 		    	   Model = scan.nextLine();
		 		    	   String sql1 = "SELECT Gunmodel FROM model WHERE LOWER(Gunmodel) = '"+Model+"'";
		                   ResultSet rs = stmt.executeQuery(sql1);
		                   if(!rs.next()) {
		                	   System.out.println("Wrong FireArm Model");
		                   }
		                   else {   
		 		    	   String sqlDel = "DELETE FROM model WHERE LOWER(Gunmodel) = LOWER('" + Model + "')";
	                       
	                       //Execute the sql
	                       stmt.executeUpdate(sqlDel);
	                       
	                       System.out.println("Model deleted!");
		                   }   
		               }
		               
		               else if (answer==5)
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
