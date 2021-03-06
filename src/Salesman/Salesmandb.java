package Salesman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.dbconnection;
import database.dbdisconnection;

public class Salesmandb {
	public Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	public Salesmandb() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * add a new salesman to the salesmen table
	 * @param man
	 * @return
	 */
	public boolean signUp(Salesman man)
	{
		Boolean ifsuccess=false;
		conn=dbconnection.getConn();
		String sql="INSERT INTO salesmen (Username,Password) VALUES (?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, man.getSausername());
			pstmt.setString(2, man.getSapassword());
			int rs=pstmt.executeUpdate();
			if (rs>0)
			{
				ifsuccess=true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {dbdisconnection.dbClose(pstmt, null, conn);}
		return ifsuccess;
		
	}
	/**
	 * log into the salesman system
	 * @param man
	 * @return
	 */
	public Salesman signIn(Salesman man)
	{
		Salesman staff=null;
		conn=dbconnection.getConn();
		String sql="SELECT * FROM salesmen WHERE Username=? AND Password=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, man.getSausername());
			pstmt.setString(2, man.getSapassword());
			rs=pstmt.executeQuery();
			if (rs.next())
			{
				String username=rs.getString(1);
				String pd=rs.getString(2);
				staff=new Salesman(username,pd);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {dbdisconnection.dbClose(pstmt, rs, conn);}
		return staff;
	}
	public boolean updateSalesmanPd(Salesman man,String newpd)
	{
		Boolean ifsuccess=false;
		conn=dbconnection.getConn();
		String sql="UPDATE salesmen SET Password=? WHERE Username=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newpd);
			pstmt.setString(2, man.getSausername());
			int rs=pstmt.executeUpdate();
			if (rs>0)
			{
				ifsuccess=true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {dbdisconnection.dbClose(pstmt, rs, conn);}
		return ifsuccess;
	}
	public static void main(String[] args)
	{
		Salesmandb sdb=new Salesmandb();
		Salesman man=new Salesman("B","54321");
		//Salesman man2=new Salesman("B","00000");
		//sdb.signUp(man);
		//Boolean ifsuccess=sdb.signIn(man2);
		Boolean ifsuccess=sdb.updateSalesmanPd(man, "99999");
		System.out.println(ifsuccess);
	}
	

}
