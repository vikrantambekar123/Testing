package PageTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.Login;

public class Login_pagetest extends Base
{

	public static Login login;
	
	
	public Login_pagetest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		Initiliazation();
		login=new Login();
	}
	
	@Test
	public void LoginCreden_Test()
	{
		System.out.println("In Login Test");
		login.LoginCredentials();
	}
	
}
