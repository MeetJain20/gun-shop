package GS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class preparedstmt {
    public final static Connection pstmt(){
        try {
            return DriverManager.getConnection("jdbc:mysql://Localhost:3306/firearms", "root", "1432001");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
