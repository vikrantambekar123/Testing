package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Base;

public class Login extends Base
{

	public GetReveiwCount LoginCredentials()
	{
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
		return new GetReveiwCount();
	}
	
}
