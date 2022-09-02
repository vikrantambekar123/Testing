package resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class Utils extends Base
{
	public static LocalDate todayDate;
	public static String r;
	public static int latestr;
	
	public static int Todayd_Date()
	{
		
		LocalDate today = LocalDate.now();
		  
		//adding one day to the localdate
		//New way to deal with Dates
		LocalDate tomorrow = today.now();
//		System.out.println("--->"+tomorrow);
		String tom=tomorrow.toString();
		String h[]=tom.split("-");
		int y=Integer.parseInt(h[2]);
		return y;
//		System.out.println(y);
		//-----------------------------------------
		
		// This is Working 
//		 todayDate = LocalDate.now(); 
//		 todayDate.plusDays(10);
//		 System.out.println(todayDate);
//		 
//		 String Today=todayDate.toString();
//		 String Day[]=Today.split("-");
//		 System.out.println(Today);
//		 String today1=Day[2].toString();
//		 System.out.println(today1);
//		 
//		 return today1;
		

	}
	
	
	public static int Previous_Day()
	{
		todayDate = LocalDate.now();
//		System.out.println(todayDate.minusDays(1));
		 String Prev=todayDate.minusDays(1).toString();
		 String Previous[]=Prev.split("-");
		 int z=Integer.parseInt(Previous[2]);
//		 System.out.println(z);
		 return z;
	}
	
	
	public static String Timing_Am_PM()
	{
		 Date date = new Date();
	     SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm aa");
	     String time = formatTime.format(date); // changing the format of 'date'
	     System.out.println(time);
	     String [] data=time.split(" ");
	     String PM=data[1].toUpperCase();
	     System.out.println(PM);
	     return PM;
	}
	
	
	public  static JavascriptExecutor JavascriptExecutor_Click(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele); // For Clicking SElect ALl
		return js;
	}
	
	
	public void General()
	{
		String property = prop.getProperty("Email_ids");
//		System.out.println(property);
		String[] x = property.split(",");
		int emailidslen=x.length;
		System.out.println(emailidslen);
		for(int i=0;i<x.length;i++)
		{
			System.out.println(x[i]);
		}
	}
	
	
	public  static JavascriptExecutor JavascriptExecutor_Highlightelement(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", ele); // For Clicking SElect ALl
		return js;
	}
	
	
	public static WebDriverWait Webdriverwait_elementtobeclickable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return wait;
	}
	
	public static Select Selectby_VisibleText(WebElement ele,String text)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(text);
		return select;
	}
	
	public static Month Currnet_Month()
	{
		LocalDate currentdate = LocalDate.now();
		Month currentMonth = currentdate.getMonth();
		return currentMonth;
	}
	
	
	
	public static void Time_After_Adding_6_MInutes()
	{
		Date date = new Date();
	    SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm");
	    String time1 = formatTime.format(date); // changing the format of 'date'
      	DateTimeFormatter formatter = DateTimeFormat.forPattern("HH.mm");
        LocalTime time = formatter.parseLocalTime(time1);
        time = time.plusMinutes(6);
        System.out.println("Time After adding 6 Minute :-"+time);
        String time11=time.toString();
        String [] time2=time11.split("[:]");
        System.out.println(time2[0]);
		
	}
	
	public void open_Gmail() throws InterruptedException ,AWTException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Testriq_D30\\Downloads\\Vikrant\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://mail.google.com");
//		Thread.sleep(6000);
		WebElement username=driver.findElement(By.xpath("//input[@id='identifierId']"));
		Thread.sleep(2000);
//		username.click();
		username.sendKeys("vikrant.ambekar@testriq.com"); // Entering Username
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();  // Clicking on Next
		Thread.sleep(2000);
		WebElement pass=driver.findElement(By.name("password"));
		pass.click();
		pass.sendKeys("welcome@123");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();  // Clicking on Next
//		System.out.println("Done Login in Gmail Vikrant :)");
		Thread.sleep(7000);
//		
		driver.findElement(By.xpath("//*[text()='No thanks']")).click();
		Thread.sleep(3000);
		
		
		List<WebElement> finish_User_Regsitration=driver.findElements(By.xpath("//*[text()='Finish User Registration']"));

		finish_User_Regsitration.get(1).click();
		System.out.println("Done Clicking on Finish  Registration");
		
		Actions action = new Actions(driver);

		WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Finish Registration')]"));
		Actions ac=new Actions(driver);
//		 ac.moveToElement(ele);
		Thread.sleep(2000);
		action.contextClick(link).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement New_Password=driver.findElement(By.xpath("//input[@placeholder='New Password']"));
		New_Password.click();
		Thread.sleep(3000);
//		JavascriptExecutor_Highlightelement(New_Password);
		New_Password.sendKeys("welcome@123");
		Thread.sleep(2000);
		WebElement Retype_Password=driver.findElement(By.xpath("//input[@placeholder='Retype Password']"));
		Retype_Password.click();
		Retype_Password.sendKeys("welcome@123");
	}
	
	
	
	
	public void NOrmal_SHit() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","/home/vaibhav/Downloads/chromedriver_linux64/chromedriver");	
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://one-staging.brandify.com/finish-registration?token=3b329f69-0b03-4fc2-9e1c-8c7034ecebdc");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement New_Password=driver.findElement(By.xpath("//input[@placeholder='New Password']"));
		New_Password.click();
		Thread.sleep(3000);
//		JavascriptExecutor_Highlightelement(New_Password);
		New_Password.sendKeys("welcome@123");
		Thread.sleep(2000);
		WebElement Retype_Password=driver.findElement(By.xpath("//input[@placeholder='Retype Password']"));
		Retype_Password.click();
		Retype_Password.sendKeys("welcome@123");
	}
	
	
	
	
	public static JavascriptExecutor Element_Visible_Click(WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()",ele);
		return jse;
		
	}
	
	
	    public static void Setdatetime() throws InterruptedException
	    {
			Date date = new Date();
		    SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm");
		    String time1 = formatTime.format(date); // changing the format of 'date'
	      	DateTimeFormatter formatter = DateTimeFormat.forPattern("HH.mm");
	        LocalTime time = formatter.parseLocalTime(time1);
	        time = time.plusMinutes(6);
	        System.out.println("Time After adding 6 Minute :-"+time);
	        String time11=time.toString();
	        String [] time2=time11.split("[:]");
	        
	        int latesttime=Integer.parseInt(time2[1]);

	        
	        
	        //Iterating Over Time to select the Time in HH:MM Dropdown
	        
				WebElement data1=driver.findElement(By.xpath("//div[@class='dropdown-styled sc-kgoBCf ZIVjI']//div[@class='dropdownlabel "+time2[0]+" sc-jKJlTe YlOeE'][normalize-space()='"+time2[0]+"']"));

				if(data1.getText().toString().equalsIgnoreCase(time2[0]))		
				{
				System.out.println("----------------------------------");
				System.out.println(data1.getText().toString());	
//				System.out.println(time2[0]);
				System.out.println("----------------------------------");
				JavascriptExecutor js13 = (JavascriptExecutor) driver;
//				data1.click();
//				JavascriptExecutor je = (JavascriptExecutor) driver;
//				je.executeScript("arguments[0].scrollIntoView(true);",data1);
				js13.executeScript("arguments[0].setAttribute('style', 'background: white; border: 4px solid red;');",data1);
//				js13.executeScript("arguments[0].scrollIntoView(true);",data1);
				Thread.sleep(2000);
				data1.click();

				}
		   
		    
		        	for(int j=1;j<=12;j++)
		    		{
		        		List<WebElement>ele=driver.findElements(By.xpath("(//div[@id='undefined-item-"+j+"'])[2]"));
		        		Iterator<WebElement>it2=ele.iterator();
		        		while(it2.hasNext())
		        		{
		        			WebElement l=it2.next();
		        			String temp=l.getText().toString();
		        			System.out.println(temp);
	        				 

	        				int webtime = 0; // or any appllication default value try { number = Integer.parseInt(input); } catch (NumberFormatException nfe) { nfe.printStackTrace(); }
//		        				System.out.println("Priting temo value :-"+temp);
		        				try {
		        					webtime = Integer.parseInt(temp); 
								} catch (Exception e) {
									// TODO: handle exception
								}
		        				
		        		
		        			System.out.println(webtime);
		        			if(webtime>=latesttime)
		        			{
		        				System.out.println("Webtime :- "+webtime);
		        				System.out.println("latestTime :- "+latesttime);
//		        				JavascriptExecutor j1e = (JavascriptExecutor) driver;
//		        				j1e.executeScript("arguments[0].scrollIntoView(true);",l);
		        				Thread.sleep(1000);
		        				l.click();
		        				break;
		        			}
		        			
		     }
	    }
	}
	   
	    
	    
	
	    

	
	
	
	
	public static void main(String args[]) throws InterruptedException , AWTException
	{
		Utils u=new Utils();
		u.Previous_Day();
	}
//	
	

}
