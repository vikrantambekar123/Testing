package PageTests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.GetReveiwCount;
import Pages.Login;

public class Rev_Summary_Daily extends Base
{

	public static Login login;
	public static GetReveiwCount rev;
	
	public Rev_Summary_Daily()
	{
		super();
	}
	
	@BeforeClass
	public void setup() throws InterruptedException
	{
		Initiliazation();
		login=new Login();
		rev=login.LoginCredentials();
		rev.Common_Selection();
	}
	

	@Test
	public void Rev_Summary_Count() throws InterruptedException , NumberFormatException
	{
//		rev.Response_Reminder();
//		rev.Rev_Summary_Daily();
//		rev.Rev_Summary_Weekly();
//		rev.Rev_Summary_Monthly();
//		rev.All_Teams_Creation();
	}
	
	
	
	
	
//	@AfterTest
//	public void Teardown()
//	{
//		driver.quit();
//	}
	
	
	
}
