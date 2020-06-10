package Pages;

import java.util.Scanner;


import Tools.ScannerChoice;

public class changeInfoNextPage {

	public static void changePage(Scanner sc)
	{
		String choice;
		do {
			System.out.println("Exit or not (Y/N)");
			choice=ScannerChoice.readString(sc);
			if (!(choice.equals("Y")||choice.equals("N")))
			{
				System.out.println("Wrong format of input.");
				continue;
			}
			break;
		}while(true);
		if (choice.equals("Y"))
		{
			System.out.println("exit.");
			System.exit(1);
		}
		else
		{
			
			System.out.println("choose the page that you want to go.");
			System.out.println("*************************");
			System.out.println("Enter the number to choose an operation.");
			System.out.println("1.customer page");
			System.out.println("2.salesman page");
	
			System.out.println("*************************");
			
			int key3;
			do {
				key3=ScannerChoice.readInt(sc);
				if (!(1==key3||key3==2))
				{
					System.out.println("\"The number you enter is invalid, please enter a number from 1 to 2.\"");
					continue;
				}
				break;
				}while(true);
				if (key3==1)
				{
					mainPage.customerPage(sc);
					
				}
				else {
					mainPage.salesmanPage(sc);
				}
			
			
		}
	}

}
