package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.Driver;

public class DBConnection {
	
	/**
	 * 1. Add the driver in the project Build Path
	 * rt click on project -> build path-> Configure Build Path -> Libraries Tab
	 * -> Add External Jars -> go the path of mysql.jar file and add it.
	 * 
	 * 2. check if driver was loaded successfully
	 */
		public static Connection dbConn()
		{
			Connection conn = null;
			try {
				//1. Load the driver
				// this Driver class knows how to communicate with the DB
				Class.forName("org.h2.Driver");
				System.out.println("Driver loaded");
				// 2. location or IP address and port number
				// MAC
				conn = DriverManager.getConnection("jdbc:h2:mem:voda2023");

				// windows
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voda2023", 
//						"root", "root");
				// LMS
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voda2023", 
//						"root", "Simplilearn");
				
				System.out.println("DB conected");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
		}
}
