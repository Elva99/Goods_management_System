package Pages;

import java.util.Scanner;

import Salesman.Salesman;
import Salesman.Salesmandb;
import Tools.ScannerChoice;

public class SalesmanPage {

	public static void SalesmanManipulationPage(Scanner sc,Salesman staff,int key)
	{
		
			
			switch(key){
			case 1:
				GoodsPage.addGoodsPage(sc);
				break;
			case 2:
				GoodsPage.updateGoodsPage(sc);
				break;
			case 3:
				GoodsPage.deleteGoodsPage(sc);
				break;
			case 4:
				updateSalesmanPdPage(staff,sc);
				break;
			case 5:
				GoodsPage.displayAllGoodsPage(sc);
				break;
			case 6:
				GoodsPage.displayGoodByNamePage(sc);
				break;
			case 7:System.out.println("exit.");
			System.exit(1);
				break;
			default:
				break;
			}
				
			
			
	}
	public static void SalesmanSignUpPage(Scanner sc)
	{
		System.out.println("Ready to sign up.");
		System.out.println("Please enter the salesman username:");
		String name=ScannerChoice.readString(sc);
		System.out.println("Please enter the salesman password:");
		String pd=ScannerChoice.readString(sc);
		Salesman man=new Salesman(name,pd);
		Boolean ifsuccess=new Salesmandb().signUp(man);
		if (ifsuccess)
		{System.out.println("successfully sign up.");}
		else {System.out.println("fail to sign up.");}
	}
	public static Salesman SalesmanSignInPage(Scanner sc)
	{
		System.out.println("Ready to sign in.");
		System.out.println("Please enter the salesman username:");
		String name=ScannerChoice.readString(sc);
		System.out.println("Please enter the salesman password:");
		String pd=ScannerChoice.readString(sc);
		Salesman man=new Salesman(name,pd);
		Salesman staff=new Salesmandb().signIn(man);
		if (staff==null)
		{System.out.println("fail to sign in.");}
		else {System.out.println("successfully sign in.");}
		return staff;
	}
	public static void updateSalesmanPdPage(Salesman staff,Scanner sc)
	{
		System.out.println("Ready to update the password.");
		System.out.println("Please enter the salesman new password:");
		String newpd=ScannerChoice.readString(sc);
		Boolean ifsuccess=new Salesmandb().updateSalesmanPd(staff, newpd);
		if (ifsuccess)
		{System.out.println("successfully update the password.");}
		else {System.out.println("fail to update the password.");}
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		//SalesmanSignUpPage(sc);
		Salesman staff=SalesmanSignInPage(sc);
		updateSalesmanPdPage(staff,sc);
		sc.close();
	}
	

}
