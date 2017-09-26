package DB;
import java.sql.*;

public class DBConnection
{
	public static Connection CreateConecction()
	{
		Connection conn = null;
		// creating connect to database
		String url = "jdbc:mysql://localhost:3306/exampledropdownlist"; 	// localhost:3306 = username sql , testjdbc = name of database which wanna connect to.
		String username = "root";
		String password = "2010";
		
		try 
		{	// load driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}
