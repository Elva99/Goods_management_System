package Tools;

import java.util.Scanner;

import Goods.Good;
import Goods.Goodsdb;
public class Query {
	private static Goodsdb gdb=new Goodsdb();
	public static int QueryGood(int key,Scanner sc)
	{
		int gid=-1;
		Good good=null;
		switch(key)
		{
		case 1:
			int user_input_id=ScannerChoice.readInt(sc);
			good=gdb.GooddisplayGoodByID(user_input_id);
			if (good==null)
			{
				//need to add query
				
			}
			else
			{
				System.out.println("The good ID is:"+good.getGid());
				System.out.println("The good name is:"+good.getGname());
				System.out.println("The good price is:"+good.getGprice());
				if (good.getGnum()==0)
				{System.out.println("The good is sold out.");}
				else
				{System.out.println("The number of good left is"+good.getGnum());}
				gid=good.getGid();
			}
			break;
		case 2:
			String user_input_name=ScannerChoice.readString(sc);
			good=gdb.displayGoodByName(user_input_name);
			if (good==null)
			{
				//need to add query
				
			}
			else
			{
				System.out.println("The good ID is:"+good.getGid());
				System.out.println("The good name is:"+good.getGname());
				System.out.println("The good price is:"+good.getGprice());
				if (good.getGnum()==0)
				{System.out.println("The good is sold out.");}
				else
				{System.out.println("The number of good left is"+good.getGnum());}
				gid=good.getGid();
			}
			break;
		default:
			//need to add query
			break;
		}
			
		return gid;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int result=QueryGood(2,sc);
		sc.close();
	}

}
