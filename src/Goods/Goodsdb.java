package Goods;

import java.util.ArrayList;
import java.sql.*;
import database.dbconnection;
import database.dbdisconnection;
public class Goodsdb {
	public Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public Goodsdb() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	/**
	 * add a new good to the goodslist database
	 * @param good
	 * @return
	 */
	public boolean addGood(Good good)
	{
		
		Boolean ifadded=false;
		conn=dbconnection.getConn();
		String sql="INSERT INTO goods (ID,Name,Price,Number) VALUES (?,?,?,?)";
		try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, good.getGid());
		pstmt.setString(2,good.getGname());
		pstmt.setDouble(3, good.getGprice());
		pstmt.setInt(4, good.getGnum());
		int result=pstmt.executeUpdate();
		if (result>0)
		{
			ifadded=true;
			System.out.print("The new good is added to the database\n");
		}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			dbdisconnection.dbClose(pstmt, null, conn);
		}
		return ifadded;
	}
	
	/**
	 * delete a good in the goodslist database
	 * @param good
	 * @return
	 */
	
	public boolean deleteGood(int ID)
	{
		Boolean ifdeleted=false;
		conn=dbconnection.getConn();
		String sql="DELETE FROM goods WHERE ID=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ID);
			int result=pstmt.executeUpdate();
			if (result>0)
			{
				ifdeleted=true;
				System.out.print("The new good is deleted from the database\n");
			}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
		
		return ifdeleted;
	}
	
	
	/**
	 * update the information of a good in the goodslist database
	 * @param good
	 * @param newinfo "type=newvalue"
	 * @param key update choice
	 */
	public boolean updateGood(Good good,int key)
	{
		Boolean ifupdated=false;
		if (!(1<=key&&key<=3))
		{
			System.out.println("The update choice is not supported. Please choose a key from 1 to 3.");
			return ifupdated;
		}
		switch(key) {
		case 1:	
			System.out.println("ready to update the name.");
			try {
				conn=dbconnection.getConn();
				String sql="UPDATE goods SET Name=? WHERE ID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, good.getGname());
				pstmt.setInt(2, good.getGid());
				int result=pstmt.executeUpdate();
				if (result>0)
				{
					ifupdated=true;
					System.out.print("The name of the good is updated.\n");
				}
				
				
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
			break;
		case 2:
			System.out.println("ready to update the price.");
			try {
				conn=dbconnection.getConn();
				String sql="UPDATE goods SET Price=? WHERE ID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setDouble(1, good.getGprice());
				pstmt.setInt(2, good.getGid());
				int result=pstmt.executeUpdate();
				if (result>0)
				{
					ifupdated=true;
					System.out.print("The price of the good is updated.\n");
				}
				
				
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
			break;
		case 3:
			System.out.println("ready to update the number.");
			try {
				conn=dbconnection.getConn();
				String sql="UPDATE goods SET Number=? WHERE ID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, good.getGnum());
				pstmt.setInt(2, good.getGid());
				int result=pstmt.executeUpdate();
				if (result>0)
				{
					ifupdated=true;
					System.out.print("The number of the good is updated.\n");
				}
				
				
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				dbdisconnection.dbClose(pstmt, null, conn);
			}
			break;
		default:	
			break;
			
		}
		
		return ifupdated;
	}
	/**
	 * display all the goods with name gname
	 * @param gname
	 * @return
	 */
	public ArrayList<Good> displayGood(String gname)
	{
		return null;
	}
	/**
	 * display all the goods in the goodslist
	 * @return
	 */
	public ArrayList<Good> displayAllGood()
	{
		return null;
	}
	
	public static void main(String[] args)
	{
		//Good ng=new Good(2,"cat",99.9,1);
		Goodsdb nd=new Goodsdb();
		//nd.addGood(ng);
		Good ng2=new Good(2,"dog",299.9,2);
		nd.updateGood(ng2, 3);
		//nd.deleteGood(2);
	}
	
	
	

}
