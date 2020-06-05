import java.sql.*;
public class test {

	public static void main(String[] args)
	{
		try {
			String url = "jdbc:mysql://localhost:3306/goodslist";
			String username="java";
			String password="password";
			//Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, username, password);
			System.out.println("database connected.");
			if (conn!=null)
			{
				conn.close();
				conn=null;
				System.out.println("database disconnected.");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
