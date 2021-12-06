package GS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class preparedstmt {
    public final static Connection pstmt(){
        try {
            return DriverManager.getConnection("jdbc:mysql://Localhost:3306/firearms", "root", "kali");
        } catch (SQLException e) {
        	System.out.println("Database is currently down!");
            e.printStackTrace();
        }
        return null;
    }
}