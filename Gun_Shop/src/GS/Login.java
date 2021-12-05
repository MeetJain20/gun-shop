package GS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
		public void log(Scanner scan){
		Connection conn = null;
		Statement stmt = null;
		try{
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/firearms", "root", "kali");
		      stmt = conn.createStatement();
		      System.out.println("\t\t\t\t\tLOGIN PAGE");
		      try  {
		    	  System.out.println("ENTER YOUR ID -");
		    	  String input = scan.nextLine();
		    	  int idv=0;
	              try{
	            	   idv=Integer.valueOf(input);
	               }
	              catch(Exception e)
	               {
	            	   System.out.println("ENTER CORRECT ID");
	               }
	              System.out.println("ENTER YOUR PASSWORD -");
		    	  String Password = scan.nextLine();
		    	  
		    	  String sql = "SELECT password FROM user where custId="+idv+"";
		    	  try (ResultSet rs = stmt.executeQuery(sql)) {
                      
                      while(rs.next()){
                         String title = rs.getString("Password");
//                          System.out.println(title);
                          if (title.equals(Password))
                          {
                        	  System.out.println("\t\t\tLOGIN SUCCESSFUL !!!!\n\t\t\tWELCOME");
                        	  User U =new User();
                        	  U.fun(scan, idv);
                          }
                          else
                          {
                        	  System.out.println("INCORRECT PASSWORD");
                          }
                      }
                      rs.close();
                  }
                  catch(Exception e) {
                       e.printStackTrace();
                       System.out.println("Error! Invalid Username");
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
		         System.out.println("Error closing connection to the database!");
		      }
		   }
	}
}
