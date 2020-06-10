import java.util.Scanner;

public class test {

	public static void main(String[] args)
	{
		
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter username");
		//String inputString=sc.next();
		//System.out.println(inputString);
		//sc.close();
		String regex = "([1-9][0-9]*)";
		String num="100";
		System.out.println(num.matches(regex));
	}

}
