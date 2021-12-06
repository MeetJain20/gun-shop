package GS;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CSVReader extends preparedstmt {
	public static void fill(String path, int rank) {
		String line = "";
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			Connection conn = preparedstmt.pstmt();
			Statement stmt = conn.createStatement();
			BufferedReader br = new BufferedReader(new FileReader(path));
			boolean flag = true;
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if(!flag) {
				if(rank == 1) {
					int val = Integer.parseInt(values[2]);
					int val2 = Integer.parseInt(values[3]);
					PreparedStatement Stat = conn.prepareStatement("INSERT INTO model VALUES (?,?,?,?)");
					Stat.setString(1, values[0]);
					Stat.setString(2, values[1]);
					Stat.setInt(3, val);
					Stat.setInt(4, val2);
					
					Stat.execute();
				}
				if(rank == 2) {
					int val = Integer.parseInt(values[0]);
					PreparedStatement Stat = conn.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?)");
					Stat.setInt(1, val);
					Stat.setString(2, values[1]);
					Stat.setString(3, values[2]);
					Stat.setString(4, values[3]);
					Stat.setString(5, values[4]);
									
					Stat.execute();
					}
				if(rank == 3) {
					int val = Integer.parseInt(values[0]);
					PreparedStatement Stat = conn.prepareStatement("INSERT INTO logbook VALUES (?,?,?,?)");
					Stat.setInt(1, val);
					Stat.setString(2, values[1]);
					Stat.setString(3, values[2]);
					Stat.setString(4, values[3]);
					
					Stat.execute();
					}
				
				}
				flag = false;				
			}
			br.close();
			stmt.close();
		}catch(FileNotFoundException e) {
			System.out.println("File Not Found!");
		}catch(IOException e) {
			System.out.println("File Not Found!");
		}catch(SQLException e) {
			System.out.print("Dupliate Detected");
			e.printStackTrace();
		}
	}
}
