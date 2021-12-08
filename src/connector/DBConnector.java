package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	public static Connection getConnection() throws SQLException{
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/funcionarios", "root", ""); 
		
		return connect;
	}
}
