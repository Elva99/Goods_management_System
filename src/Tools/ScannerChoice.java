package Tools;

import java.util.Scanner;

public class ScannerChoice {

	public static int readInt(Scanner sc)
	{
		int num=0;
		do {
			System.out.println("Please input an integer.");
			//sc=new Scanner(System.in);
			String regex="[1-9][0-9]*";
			String intString=sc.next();
			if (intString.matches(regex))
			{
				num=Integer.parseInt(intString);
				//sc.close();	
			}
			else
			{
				System.out.println("Wrong format of input!");
				
				continue;
			}
			
			break;
			}while(true);
		
		return num;
	}
	
	public static double readDouble(Scanner sc)
	{
		double num=0.00;
		do {
			System.out.println("Please input a double of 2 decimal places.");
			//Scanner sc=new Scanner(System.in);
			String regex="(([1-9][0-9]*)\\.([0-9]{2}))|([0]\\.([0-9]{2}))";
			String doubleString=sc.next();
			if (doubleString.matches(regex))
			{
				num=Double.parseDouble(doubleString);
				//sc.close();	
			}
			else
			{
				System.out.println("Wrong format of input!");
				
				continue;
			}
			
			break;
			}while(true);
		
		return num;
		
	}
	
	public static String readString(Scanner sc)
	{
		String str="";
		System.out.println("Please input a string.");
		//Scanner sc=new Scanner(System.in);
		str=sc.next();
		//sc.close();
		return str;
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str=readString(sc);
		System.out.println(str);
		int num=readInt(sc);
		System.out.println(num);
		sc.close();
		
	}

	
	
}
