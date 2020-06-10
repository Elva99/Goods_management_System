package Pages;

import java.util.ArrayList;
import java.util.Scanner;

import Goods.Good;
import Goods.Goodsdb;
import Tools.ScannerChoice;



public class GoodsPage {
	

	public static void addGoodsPage(Scanner sc)
	{
		
		
		System.out.println("Ready to add a good.");
		System.out.println("Please enter the good ID:");
		int ID=ScannerChoice.readInt(sc);
		System.out.println("Please enter the good name:");
		String name=ScannerChoice.readString(sc);
		System.out.println("Please enter the good price:");
		double price=ScannerChoice.readDouble(sc);
		System.out.println("Please enter the good number:");
		int num=ScannerChoice.readInt(sc);
		
		Good good=new Good(ID,name,price,num);
		Boolean ifadded=(new Goodsdb()).addGood(good);
		if (ifadded)
		{
			System.out.println("The good is added.");
		}
		else
		{
			System.out.println("The good is not added.");
		}
	}
	public static void updateGoodsPage(Scanner sc)
	{
		int key;
		System.out.println("Ready to update the information of the good.");
		System.out.println("Please enter the name of the good to update the information.");
		
		String name=ScannerChoice.readString(sc);
		Good good=new Goodsdb().displayGoodByName(name);
		System.out.println("Enter 1 to update the good name.");
		System.out.println("Enter 2 to update the good price.");
		System.out.println("Enter 3 to update the good number.");
		do {
		key=ScannerChoice.readInt(sc);
		if (!(1<=key&&key<=3))
		{
			System.out.println("The update choice is not supported. Please choose a key from 1 to 3.");
			continue;
		}
		break;
		}while(true);
	
		Boolean ifupdated=(new Goodsdb()).updateGood(good, key,sc);
		if (!ifupdated)
		{
			System.out.println("The information is not updated.");
		}
		
	}
	public static void deleteGoodsPage(Scanner sc)
	{
		
		System.out.println("Ready to delete the good.");
		System.out.println("Enter the ID of the good to delete:");
		int ID=ScannerChoice.readInt(sc);
		Boolean ifdeleted=new Goodsdb().deleteGood(ID);
		
		if (!ifdeleted)
		{
			System.out.println("The good is not deleted.");
		}
	}
	
	public static void purchaseGoodPage(Scanner sc)
	{
		int number_want;
		System.out.println("Ready to purchase the good.");
		System.out.println("Enter the name of the good to purchase:");
		String name=ScannerChoice.readString(sc);
		Good good=new Goodsdb().displayGoodByName(name);
		if (good==null)
		{
			//System.out.println("The good does not exist.");
			return;
		}
		do {
		System.out.println("Enter the number of the good to purchase:");
		number_want=ScannerChoice.readInt(sc);
		if (number_want>good.getGnum())
		{
			System.out.println("Please enter the number<="+good.getGnum());
			continue;
		}
		else {break;}
		}
		while(true);
		
		Boolean ifsuccess=new Goodsdb().purchaseGood(good,number_want);
		if (!ifsuccess)
		{
			System.out.println("Successfully purchased the good.");
		}
		
	}
	public static void displayGoodByNamePage(Scanner sc)
	{
		System.out.println("Please enter the good name:");
		String name=ScannerChoice.readString(sc);
		Good good=new Goodsdb().displayGoodByName(name);
		if (good==null)
		{
			return;
		}
		System.out.println
		("Id="+good.getGid()+" Name="+good.getGname()+" Price="+good.getGprice()+" Number="+good.getGnum());
		
	}
	
	public static void displayAllGoodsPage(Scanner sc)
	{
		System.out.println("Ready to display all goods.");
		ArrayList<Good> list=(new Goodsdb()).displayAllGood();
		if (list.size()<=0)
		{
			System.out.println("The depot is empty.");
			return;
		}
		for (int i=0;i<list.size();i++)
		{
			System.out.println
			("Id="+list.get(i).getGid()+" Name="+list.get(i).getGname()+" Price="+list.get(i).getGprice()+" Number="+list.get(i).getGnum());
		}
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		//addGoodsPage(sc);
		//updateGoodsPage(sc);
		//deleteGoodsPage(sc);
		displayGoodByNamePage(sc);
		//displayAllGoodsPage(sc);
		sc.close();
		
	}

}
