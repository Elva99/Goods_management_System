package Pages;

import java.util.Scanner;

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
		
		do {
		int key=ScannerChoice.readInt(sc);
		switch(key){
		case 1:
			System.out.println("1.customer");
			//customerPage(sc);
			break;
		case 2:
			System.out.println("2.staff");
			//staffPage(sc);
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
