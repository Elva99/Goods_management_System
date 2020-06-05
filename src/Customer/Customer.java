package Customer;

public class Customer {
	private String cusername;
	private String cpassword;
	private double money;
	public Customer(String cusername,String cpassword,double money) {
		this.cusername=cusername;
		this.cpassword=cpassword;
		this.money=money;
		
	}
	public String getCusename()
	{
		return this.cusername;
	}
	public String getCpassword()
	{
		return this.cpassword;
	}
	public double getMoneyAmount()
	{
		return this.money;
	}
	public void setCusername(String newusername)
	{
		this.cusername=newusername;
	}
	public void setCpassword(String newpassword)
	{
		this.cpassword=newpassword;
	}
	public void setCmoney(double newmoney)
	{
		this.money=newmoney;
	}
	

}
