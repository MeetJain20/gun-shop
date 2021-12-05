import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Signup {
	static String idval = "";
	public void sign(Scanner scan){
		Connection conn = null;
		Statement stmt = null;
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/Gunshop", "root", "dbms");
		      stmt = conn.createStatement();
		      System.out.println("\t\t\t\t\tSIGN UP PAGE ");
		      try {
	                  String name = "";
        	          String password = "";
                	  String email = "";
                	  String phnnum = "";
		    	  System.out.println("ENTER YOUR NAME -");
		    	  name = scan.nextLine();
		    	  
		    	  System.out.println("SET YOUR PASSWORD -");
		    	  password = scan.nextLine();
		    	  
		    	  System.out.println("ENTER YOUR EMAIL ID -");
		    	  email = scan.nextLine();
		    	  
		    	  System.out.println("ENTER YOUR PHONE NUMBER -");
		    	  phnnum = scan.nextLine();

		    	  String sql = "INSERT INTO User(password,name,email,phoneNo) VALUES ('" + password + "', " + "'" + name + "', " + "'" + email + "', "+"'" + phnnum +"');";
		    	  stmt.execute(sql);
		    	 
		    	  System.out.println("SUCCESSFULLY ADDED");
		    	  sql = "Select custid From User where and custid = max(custid);";
//		    	  password = '"+ password +"'
		    	  try (ResultSet rs = stmt.executeQuery(sql)) {
                      while(rs.next()){
                          //Retrieve by column name
                          idval = rs.getString("custid");
                      }
                      //Close the result set
                      rs.close();
                  }
		    	  System.out.println("DEFAULT ID ASSIGNED TO YOU IS :");
		    	  System.out.println(idval);
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
		      }catch(SQLException se){}
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
