package database;
import java.sql.*;
public class dbconnection {

	public static Connection getConn ()
	{
		Connection conn=null;
		String username="java";
		String password="password";
		String url="jdbc:mysql://localhost:3306/goodslist";
		try
		{
			conn=DriverManager.getConnection(url, username, password);
			//System.out.println("database connected.");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

}
