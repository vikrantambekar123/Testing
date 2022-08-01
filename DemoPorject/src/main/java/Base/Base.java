package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	public static Properties prop;
	public static WebDriver driver;	
	
	public Base()
	{
		File file = new File("/home/vaibhav/Downloads/DemoPorject/DemoPorject/config.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void Initiliazation()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","/home/vaibhav/Downloads/chromedriver_linux64/chromedriver");	
			driver = new ChromeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	

}
