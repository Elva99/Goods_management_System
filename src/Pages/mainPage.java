package Pages;

import java.util.Scanner;

import Salesman.Salesman;
import Tools.ScannerChoice;

public class mainPage {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		menuPage(sc);
	}
	
	public static void menuPage(Scanner sc)
	{
		System.out.println("***************************");
		System.out.println("Use the system as a (Enter the number):");
		System.out.println("1.customer");
		System.out.println("2.staff");
		System.out.println("3.Exit");
		System.out.println("***************************");
		do {
		int key=ScannerChoice.readInt(sc);
		switch(key){
		case 1:
			System.out.println("1.customer");
			customerPage(sc);
			break;
		case 2:
			salesmanPage(sc);
			break;
		case 3:
			System.out.println("exit.");
			System.exit(1);
			break;
		default:
			System.out.println("The number you enter is invalid, please enter a number from 1 to 3.");
			continue;
		
		}
		System.exit(1);
		}while(true);
	}
	public static void customerPage(Scanner sc)
	{
		System.out.println("*************************");
		System.out.println("Enter the number to choose an operation.");
		System.out.println("1.search a good by name");
		System.out.println("2.display all goods in the depot.");
		System.out.println("3.purchase a good.");
		System.out.println("4.Exit");
		System.out.println("***************************");
		do {
			int key=ScannerChoice.readInt(sc);
			switch(key){
			case 1:
				GoodsPage.displayGoodByNamePage(sc);
				changeInfoNextPage.changePage(sc);
				break;
			case 2:
				GoodsPage.displayAllGoodsPage(sc);
				changeInfoNextPage.changePage(sc);
				//staffPage(sc);
				break;
			case 3:
				GoodsPage.purchaseGoodPage(sc);
				changeInfoNextPage.changePage(sc);
			case 4:
				System.out.println("exit.");
				System.exit(1);
				break;
			default:
				System.out.println("The number you enter is invalid, please enter a number from 1 to 4.");
				continue;
			
			}
			System.exit(1);
			}while(true);
		
	}
	public static void salesmanPage(Scanner sc)
	{
		System.out.println("*************************");
		System.out.println("Enter the number to choose an operation.");
		System.out.println("1.Sign up");
		System.out.println("2.Sign in");
		System.out.println("3.Exit");
		System.out.println("***************************");
		do {
			int key=ScannerChoice.readInt(sc);
			switch(key){
			case 1:
				
				SalesmanPage.SalesmanSignUpPage(sc);
				changeInfoNextPage.changePage(sc);
				break;
			case 2:
				int key2;
				Salesman staff=SalesmanPage.SalesmanSignInPage(sc);
				if (staff==null)
				{
					System.out.println("fail to Sign in ");
					System.exit(-1);
				}
				System.out.println("Sign in successfully.");
				System.out.println("*************************");
				System.out.println("Enter the number to choose an operation.");
				System.out.println("1.add a new good to the depot");
				System.out.println("2.update the good information");
				System.out.println("3.delete a good");
				System.out.println("4.change the password");
				System.out.println("5.display all goods");
				System.out.println("6.search a good by name");
				System.out.println("7.Exit");
				System.out.println("***************************");
				do {
				key2=ScannerChoice.readInt(sc);
				if (!(1<=key2&&key2<=7))
				{
					System.out.println("\"The number you enter is invalid, please enter a number from 1 to 7.\"");
					continue;
				}
				break;
				}while(true);
				SalesmanPage.SalesmanManipulationPage(sc, staff, key2);
				changeInfoNextPage.changePage(sc);
				break;
			case 3:
				System.out.println("exit.");
				System.exit(1);
				break;
			default:
				System.out.println("The number you enter is invalid, please enter a number from 1 to 3.");
				continue;
			
			}
			System.exit(1);
			}while(true);
	}
}




















