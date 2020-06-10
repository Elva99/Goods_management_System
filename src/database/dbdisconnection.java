package database;
import java.sql.*;
public class dbdisconnection {

	public static void dbClose(PreparedStatement pstmt,ResultSet rs,Connection conn)
	{
		try {
			if (pstmt!=null)
				pstmt.close();
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		try {
			if (rs!=null)
				rs.close();
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		try {
			if (conn!=null)
				conn.close();
			
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		//System.out.print("The database is closed.\n");
	}

}
