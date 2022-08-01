package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import resources.Utils;

public class Demo {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/home/vaibhav/Downloads/chromedriver_linux64/chromedriver");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://one-staging.brandify.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("sage@leanst.com");
		driver.findElement(By.name("password")).sendKeys("Sage521802");
		driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='sc-dyGzUR jsoyVx']")).click(); //Account SElecing
		driver.findElement(By.xpath("//input[@placeholder='Select Accounts']")).sendKeys("Cheesecake Factory");
					Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Select Accounts']")).click();

		driver.findElement(By.xpath("//*[text()='Cheesecake Factory']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='cs-resulttext sc-cJOK czCkLy'][normalize-space()='All Locations']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[normalize-space()='REVIEWS']//div[@id='menu-id-menu-item-label']")).click();
		driver.findElement(By.xpath("//*[text()='Reviews Feed']")).click();
	
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='sc-iELTvK kjcjce']")).click(); // Clicking on All Reviews
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='1a48ccec-8051-455f-824e-24c49f7afd2a-label-item-4']")).click(); // Clicking on All Reviews
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='button__email-icon sc-jAaTju dTZuXp']")).click(); // Clicking on MAil Icon
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='NEW SCHEDULE']")).click();
		
		WebElement drop1=driver.findElement(By.xpath("//span[@class='sc-cmTdod jqwwMa']")); // CLicking on Dropdown to select REponse REminder
		drop1.click();
		Thread.sleep(1000);
		WebElement Response_Reminder=driver.findElement(By.id("responseReminder-item-2"));
		Response_Reminder.click();
		JavascriptExecutor js11 = (JavascriptExecutor) driver;

		js11.executeScript("arguments[0].click();", Response_Reminder); // For Clicking SElect ALl 

		Thread.sleep(1000);
		List<WebElement>cus=driver.findElements(By.xpath("//label[@class='sc-hGoxap eLZasF']"));
		System.out.println(cus.size());
		cus.get(1).click(); // Clicking on Customer Filter
		
		
	
		
//		js12.executeScript("arguments[0].click();", defaultfilter); // For Clicking SElect ALl 
		WebElement EmailSubjectmessage=driver.findElement(By.xpath("//input[@placeholder='Email Subject']")); // Clicking on Email Subject to Enter Email Subject Name
		EmailSubjectmessage.sendKeys("Hello World"); // Entering EMail Subject

		WebElement SaveasMessage=driver.findElement(By.xpath("//input[@placeholder='Schedule Name']")); // Clicking on Email Subject to Enter Email Subject Name			
		SaveasMessage.sendKeys("Hello World"); // Entering SaveasEmail
		
		WebElement EmailAddress=driver.findElement(By.xpath("//input[@placeholder='Email addresses...']")); // Clicking on Email Subject to Enter Email Subject Name			
		EmailAddress.sendKeys("vikrant123@gmail.com"); // Entering Email
		EmailAddress.sendKeys(Keys.ENTER);
		
		WebElement datepicker=driver.findElement(By.xpath("//div[@id='qaId-date-picker-container-date-picker-input']")); // Clicking on Email Subject to Enter Email Subject Name			
		datepicker.click();

		
		
		List<WebElement> datepickpopup=driver.findElements(By.xpath("//div[starts-with(@class,'react-datepicker__day react-datepicker')]")); // SElecting Post DAta for Custom Previous and Today
		
		
		Iterator<WebElement>it=datepickpopup.iterator();
		while(it.hasNext())
		{
			WebElement l=it.next();
//			js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');",l);
//			System.out.println( l.getText().toString());
			if(l.getText().equalsIgnoreCase(Utils.Todayd_Date()))
			{
				l.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@placeholder='HH:MM']")).click(); // Clicking on Hours and Mins
		
		//Tiem Selection
		Date date = new Date();
	    SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm");
	    String time1 = formatTime.format(date); // changing the format of 'date'
      	DateTimeFormatter formatter = DateTimeFormat.forPattern("HH.mm");
        LocalTime time = formatter.parseLocalTime(time1);
        time = time.plusMinutes(6);
        System.out.println(time);
//        System.out.println(time);
        String time11=time.toString();
        String [] time2=time11.split("[:]");
        
        int latesttime=Integer.parseInt(time2[1]);
        System.out.println(latesttime);
        System.out.println("LatestTime :-"+latesttime);
        
        
	    
	    for(int i=1;i<=12;i++)
	    {
	    	if(i<=9)
	    {
			WebElement data1=driver.findElement(By.xpath("//div[@class='dropdown-styled sc-kgoBCf ZIVjI']//div[@class='dropdownlabel 0"+i+" sc-jKJlTe YlOeE'][normalize-space()='0"+i+"']"));
//			WebElement data1=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel 0"+i+"')]"));
			System.out.println(time2);
			if(data1.getText().toString().equalsIgnoreCase(time2[0]))		
			{
			JavascriptExecutor js13 = (JavascriptExecutor) driver;
			js13.executeScript("arguments[0].setAttribute('style', 'background: white; border: 4px solid red;');",data1);
			data1.click();
			break;
			}
			
			//Here Minutes will come
			
	    }
	    	else if(i>9)
	    	{
	    		String h="//div[@class='dropdown-styled sc-kgoBCf ZIVjI']//div[@class='dropdownlabel "+i+" sc-jKJlTe YlOeE'][normalize-space()='"+i+"']";
	    		System.out.println(h);
	    		WebElement data2=driver.findElement(By.xpath("//div[@class='dropdown-styled sc-kgoBCf ZIVjI']//div[@class='dropdownlabel "+i+" sc-jKJlTe YlOeE'][normalize-space()='"+i+"']"));
//	    		WebElement data2=driver.findElement(By.xpath("//div[starts-with(@class,'dropdownlabel "+i+"')]"));
				if(data2.getText().toString().equalsIgnoreCase(time2[0]))		
				{
					JavascriptExecutor js13 = (JavascriptExecutor) driver;
					js13.executeScript("arguments[0].setAttribute('style', 'background: white; border: 7px solid red;');",data2);
					data2.click();
					break;
				}
	    	}
	    	
	    }
	    
	        	for(int j=1;j<=12;j++)
	    		{
	        		List<WebElement>ele=driver.findElements(By.xpath("(//div[@id='undefined-item-"+j+"'])[2]"));
	        		Iterator<WebElement>it2=ele.iterator();
	        		while(it2.hasNext())
	        		{
	        			WebElement l=it2.next();
//	        			js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');",l);
	        			
	        			System.out.println( l.getText().toString());
	        			String temp=l.getText().toString();
//	        			int webtime=Integer.parseInt(temp);
	        			int webtime=0;
	        			try { 
	        				webtime = Integer.parseInt(temp); 
	        				} 
	        			catch (NumberFormatException err) 
	        			{ 
	        				err.printStackTrace(); 
	        			}


	        			System.out.println(webtime);
	        			if(webtime>=latesttime)
	        			{
	        				System.out.println();
	        				l.click();
	        	        	Thread.sleep(4000);

	        				
	        				break;
	        			}
	        		}
	    		}
	        	
	        	
	        WebElement Am_Pm=driver.findElement(By.id("core_TimePicker_TimePickerButton_1"));
	        if(!Am_Pm.getText().equals(Utils.Timing_Am_PM()))
	        {
	        	System.out.println(Am_Pm.getText());
				JavascriptExecutor js4 = (JavascriptExecutor) driver;

				js4.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');",Am_Pm);
	        	Thread.sleep(2000);

	        	Am_Pm.click();
	        }
	        
	        Thread.sleep(1000);
//	        driver.findElement(By.xpath("//div[contains(text(),'Weekly')]")).click();
        
	     
	        WebElement ele5=driver.findElement(By.xpath("//button[@class='sc-bZQynM kjssSV']"));
			JavascriptExecutor js12 = (JavascriptExecutor) driver;
			js12.executeScript("arguments[0].setAttribute('style', 'background: white; border: 4px solid red;');",ele5);
			ele5.click();
			Thread.sleep(2000);
			String sucessmail=driver.findElement(By.xpath("//p[normalize-space()='Successfully created an email schedule']")).getText().toString();
			System.out.println(sucessmail);
	        	
//	        driver.close();
	    				
			
		
		
	    
	  }

}
