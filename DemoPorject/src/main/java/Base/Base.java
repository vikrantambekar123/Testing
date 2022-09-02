package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base 
{
	public static Properties prop;
	public static WebDriver driver;	
	public static DesiredCapabilities capabilities;
	
	public Base()
	{
		File file = new File("C:\\Users\\Testriq_D30\\Downloads\\Vikrant\\UpdatedProject\\Testing\\DemoPorject\\config.properties");
		  
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
//		capabilities = DesiredCapabilities.internetExplorer();
//		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//		browserstackOptions.put("resolution", "1024x768");
//		capabilities.setCapability("bstack:options", browserstackOptions);
		
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Testriq_D30\\Downloads\\Vikrant\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	

}
