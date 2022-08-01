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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.Base;
import resources.Utils;

public class GetReveiwCount extends Base
{
		
	@FindBy(xpath = "//div[@class='sc-dyGzUR jsoyVx']")
	WebElement Account_Selection;
	
	@FindBy(xpath = "//input[@placeholder='Select Accounts']")
	WebElement Enter_Cheesecakefactory;
	
	@FindBy(xpath = "//*[text()='Cheesecake Factory']")
	WebElement Select_Cheesecakefactory;
	
	@FindBy(xpath = "//div[@class='cs-resulttext sc-cJOK czCkLy'][normalize-space()='All Locations']")
	WebElement Select_AllLocation;
	
	@FindBy(xpath = "//div[normalize-space()='REVIEWS']//div[@id='menu-id-menu-item-label']")
	WebElement ReviewTab;
	
	@FindBy(xpath = "//*[text()='Reviews Feed']")
	WebElement Reviews_FeedTab;
	
	@FindBy(xpath = "//div[@class='sc-iELTvK kjcjce']")
	WebElement Clicking_All_Reveiws_Dropdown;
	
	@FindBy(xpath = "//div[@id='1a48ccec-8051-455f-824e-24c49f7afd2a-label-item-4']")
	WebElement Selecting_All_Reveiws;
	
	@FindBy(xpath = "//a[@id='fltrOptPosting Date']")
	WebElement Clicking_on_PostingDate;
	
	@FindBy(xpath = "//a[normalize-space()='Custom']")
	WebElement Clicking_on_Custom;
	
	@FindBy(xpath ="//button[starts-with(@class,'react-calendar__tile react-calendar')]")
	List<WebElement> Selecting_Custom_Date;
	
	@FindBy(id = "fltrOptPublisher")
	WebElement Publisher;
	
	@FindBy(xpath = "//li[@id='Publisher']//div//ul//li//a")
	WebElement Select_All_Publisher;
	
	@FindBy(xpath = "//*[text()='Apply']")
	WebElement ApplyButton;
	
	@FindBy(xpath = "//div[@class='button__email-icon sc-jAaTju dTZuXp']")
	WebElement Click_Mail_Icon;
	
	@FindBy(xpath = "//*[text()='NEW SCHEDULE']")
	WebElement Click_On_NewSchedule;
	
	@FindBy(xpath = "//span[@class='sc-cmTdod jqwwMa']")
	WebElement TypeofMail_Dropdown;
	
	@FindBy(id = "responseReminder-item-2")
	WebElement Select_ResponseReminder_Mail;
	
	@FindBy(xpath = "(//div[@class='sc-bHwgHz gcnwuA'])[2]")
	WebElement Click_Custom_Email_Subject_Radio;
	
	@FindBy(xpath = "(//div[@class='sc-bHwgHz gcnwuA'])[1]")
	WebElement Custom_Review_Filter;
	
	@FindBy(xpath = "//input[@placeholder='Email Subject']")
	WebElement Enter_Custom_Email_Subject;
	
	@FindBy(xpath = "//input[@placeholder='Schedule Name']")
	WebElement Save_As_SchduelueName;
	
	@FindBy(xpath = "//input[@placeholder='Email addresses...']")
	WebElement Enter_Email_Address;
	
	@FindBy(xpath = "//div[@id='qaId-date-picker-container-date-picker-input']")
	WebElement DatePicker;
	
	@FindBy(xpath = "//input[@placeholder='HH:MM']")
	WebElement Hours_and_Min;
	
	@FindBy(xpath = "//div[starts-with(@class,'react-datepicker__day react-datepicker')]")
	List<WebElement> Email_Date_Selection;
	
	@FindBy(xpath = "(//div[@class='sc-bGbJRg fDPFOs'])[1]")
	WebElement AM_PM_Selection;
	
	@FindBy(xpath = "//button[@class='sc-bZQynM kjssSV']")
	WebElement SaveButton;
	
	@FindBy(xpath = "//p[normalize-space()='Successfully created an email schedule']")
	WebElement SuccessMessage;
	
	@FindBy(xpath = "//span[normalize-space()='Close']")
	WebElement CloseButton;
	
	@FindBy(xpath = "//div[@color='lightPurple']")
	WebElement Reviewtotalcount;
	
	@FindBy(xpath = "//a[normalize-space()='7 days']")
	WebElement Custom_7_Days_Selection;
	
	@FindBy(xpath = "//a[normalize-space()='30 days']")
	WebElement Select_30_Days;
	
	@FindBy(xpath = "//a[@id='filterAdd']") 
	WebElement Addfilter;
	
	@FindBy(id = "adtlFiltOpts") 
	WebElement Select_FIlter;
	
	@FindBy(xpath = "//a[@id='adtlOptApplyBtn']") 
	WebElement Modified_Apply;
	
	
	
	
	

	
	
	
	
	public GetReveiwCount()
	{
		PageFactory.initElements(driver, this);
	}
	
//		public static String Timeset;
	
		public void Common_Selection() throws InterruptedException
		{
			Thread.sleep(5000);
			Account_Selection.click(); //Account SElecing
			Enter_Cheesecakefactory.sendKeys("Cheesecake Factory"); // Entering CheesecakeFactory
			Thread.sleep(2000);
			Enter_Cheesecakefactory.click();    // Entering CheescakeFactory to select
			Select_Cheesecakefactory.click();   // Selecting Searched CheescakeFactory Location
			Select_AllLocation.click();   // Selecting All Location
			Thread.sleep(7000);
			
			ReviewTab.click();  //Clicking on Reveiws Tab
			Reviews_FeedTab.click(); // Clicking on Reviews Feed Tab

			Thread.sleep(5000);
			Clicking_All_Reveiws_Dropdown.click(); // Clicking on All Reviews
			Thread.sleep(2000);
			Selecting_All_Reveiws.click(); // S on All Reviews
		}
		
		
		
		public void Response_Reminder() throws InterruptedException ,NumberFormatException
		{			
			Click_Mail_Icon.click(); // Clicking on MAil Icon
			Thread.sleep(2000);
			Click_On_NewSchedule.click();
			
			Utils.Webdriverwait_elementtobeclickable(TypeofMail_Dropdown);
			TypeofMail_Dropdown.click(); // CLicking on Dropdown to select REponse REminder
			Thread.sleep(1000);
			Select_ResponseReminder_Mail.click();
			Thread.sleep(1000);
			
			Utils.JavascriptExecutor_Click(Click_Custom_Email_Subject_Radio); // Clicking on Email Customer Filter
			
			Enter_Custom_Email_Subject.sendKeys("Response Reminder "+Utils.Todayd_Date()+"  "+Utils.Currnet_Month()); // Entering Custom EMail Subject
			
			Save_As_SchduelueName.sendKeys("Response Reminder "+Utils.Todayd_Date()+"  "+Utils.Currnet_Month()); // Entering SaveasEmail
			Enter_Email_Address.sendKeys("vikrant.ambekar@testriq.com"); // Entering Email
			Enter_Email_Address.sendKeys(Keys.ENTER);		
			DatePicker.click();	
			
			Iterator<WebElement>it=Email_Date_Selection.iterator(); // Iterating Post DAta for Custom Previous and Today
			while(it.hasNext())
			{
				WebElement l=it.next();
				if(l.getText().equalsIgnoreCase(Utils.Todayd_Date()))
				{
					l.click();
					break;
				}
			}
			
	 
			
	        Thread.sleep(1000);

	        Hours_and_Min.click(); // Clicking on Hours and Mins
			Thread.sleep(2000);
			
			Utils.Setdatetime();
        	System.out.println(Utils.Timing_Am_PM());
		        Thread.sleep(6000);	
		        String am_pm_Selection=AM_PM_Selection.getText().toString();
		        if(!am_pm_Selection.equals(Utils.Timing_Am_PM()))
		        {
		        	Utils.JavascriptExecutor_Highlightelement(AM_PM_Selection);
		        	AM_PM_Selection.click();
		        }
		        
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//div[contains(text(),'Daily')]")).click(); // For Selecting Frequency Currently Not Applicable in Response Reminder
				
		        Utils.JavascriptExecutor_Highlightelement(SaveButton);
		        Utils.JavascriptExecutor_Click(SaveButton);
		        
				Thread.sleep(1000);
				String sucessmail=SuccessMessage.getText().toString(); // Getting Success Message
				System.out.println(sucessmail);	
				
				CloseButton.click(); 
		}		
		
		
		
		public void Rev_Summary_Daily() throws InterruptedException
		{
			Thread.sleep(2000);
			Clicking_on_PostingDate.click(); //CLicking on Posting Date
			Thread.sleep(2000);

			Clicking_on_Custom.click(); //CLicking on Custom
			//Iterating Date to Select Previous Date and Current Date 
			Iterator<WebElement>it=Selecting_Custom_Date.iterator();
			while(it.hasNext())
			{
				WebElement l=it.next();
//				Thread.sleep(2000);//			
				Utils.JavascriptExecutor_Highlightelement(l);
				if(l.getText().equalsIgnoreCase(Utils.Previous_Day()))
				{
					System.out.println("Selected Prev");
//					Thread.sleep(2000);
					Utils.JavascriptExecutor_Highlightelement(l);
					Utils.JavascriptExecutor_Click(l);
//					Thread.sleep(2000);
//										break;
				}
				else if(l.getText().equalsIgnoreCase(Utils.Todayd_Date()))
				{
					System.out.println("Selected today");
					Utils.JavascriptExecutor_Highlightelement(l);
					Utils.JavascriptExecutor_Click(l);
					Utils.JavascriptExecutor_Click(ApplyButton);
					break;
				}
			}

			
			Thread.sleep(2000);
			Publisher.click(); //Clicking on Publisher
			Thread.sleep(2000);
		
			Utils.JavascriptExecutor_Click(Select_All_Publisher); // For Clicking SElect ALl of Publisher
			Utils.JavascriptExecutor_Click(ApplyButton); // For Clciking on APply Button

			System.out.println("---------------- Rev Summary Daily Count-------------------");
			
			Thread.sleep(3000);
			String Revdailycount=Reviewtotalcount.getText().toString();
			System.out.println("Revdailycount :"+Revdailycount);
			System.out.println();
			System.out.println();
			System.out.println("------------------------------------------------------------");
		
			Thread.sleep(2000);
			Click_Mail_Icon.click(); // Clicking on MAil Icon
			Thread.sleep(2000);
			Click_On_NewSchedule.click();
		
			Thread.sleep(1000);

			Utils.JavascriptExecutor_Click(Click_Custom_Email_Subject_Radio);
			
			Enter_Custom_Email_Subject.sendKeys("Rev Summary Daily "+Utils.Todayd_Date()+" "+Utils.Currnet_Month()); // Entering Custom EMail Subject
			
			Save_As_SchduelueName.sendKeys("Rev Summary Daily "+Utils.Todayd_Date()+" "+Utils.Currnet_Month()); // Entering SaveasEmail
			Enter_Email_Address.sendKeys("vikrant.ambekar@testriq.com"); // Entering Email
			Enter_Email_Address.sendKeys(Keys.ENTER);		
			DatePicker.click();	
			
			Iterator<WebElement>it2=Email_Date_Selection.iterator(); // Iterating Post DAta for Custom Previous and Today
			while(it2.hasNext())
			{
				WebElement l=it2.next();
				System.out.println( l.getText().toString());
				if(l.getText().equalsIgnoreCase(Utils.Todayd_Date()))
				{
					l.click();
					break;
				}
			}
			
			Hours_and_Min.click(); // Clicking on Hours and Mins
			Thread.sleep(2000);
			
			Utils.Setdatetime();
        	System.out.println(Utils.Timing_Am_PM());
		        Thread.sleep(6000);	
		        String am_pm_Selection=AM_PM_Selection.getText().toString();
		        if(!am_pm_Selection.equals(Utils.Timing_Am_PM()))
		        {
		        	Utils.JavascriptExecutor_Highlightelement(AM_PM_Selection);
		        	AM_PM_Selection.click();
		        }
		        
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//div[contains(text(),'Daily')]")).click(); // For Selecting Frequency Currently Not Applicable in Response Reminder
				
		        Utils.JavascriptExecutor_Highlightelement(SaveButton);
		        Utils.JavascriptExecutor_Click(SaveButton);
		        
				Thread.sleep(1000);
				String sucessmail=SuccessMessage.getText().toString(); // Getting Success Message
				System.out.println(sucessmail);	
				
				CloseButton.click(); 
	
		}	

		public void Rev_Summary_Weekly() throws InterruptedException 
		{
			System.out.println("-------------  Rev Summary Weeekly -----------------");
			
			Clicking_on_PostingDate.click(); //CLicking on Posting Date
			Thread.sleep(2000);
			Utils.JavascriptExecutor_Click(Custom_7_Days_Selection);
			
			Thread.sleep(1000);

//			ApplyButton
			Utils.JavascriptExecutor_Click(ApplyButton);
			Thread.sleep(6000);

			
			String REvWeekly=Reviewtotalcount.getText().toString();
			System.out.println("-------------------------------------------");
			System.out.println("Rev Summary Weeekly :- "+REvWeekly);
			System.out.println();
			System.out.println("---------------------------------------------");
			
			
			Click_Mail_Icon.click(); // Clicking on MAil Icon
			Thread.sleep(2000);
			Click_On_NewSchedule.click();
			
			Thread.sleep(1000);

			Utils.JavascriptExecutor_Click(Click_Custom_Email_Subject_Radio);
			
			Enter_Custom_Email_Subject.sendKeys("ReV Summary Weekly "+Utils.Todayd_Date()+" "+Utils.Currnet_Month()); // Entering Custom EMail Subject
			
			Save_As_SchduelueName.sendKeys("ReV Summary Weekly "+Utils.Todayd_Date()+" "+Utils.Currnet_Month()); // Entering SaveasEmail
			Enter_Email_Address.sendKeys("vikrant.ambekar@testriq.com"); // Entering Email
			Enter_Email_Address.sendKeys(Keys.ENTER);		
			DatePicker.click();	
			
			Iterator<WebElement>it=Email_Date_Selection.iterator(); // Iterating Post DAta for Custom Previous and Today
			while(it.hasNext())
			{
				WebElement l=it.next();
				Utils.JavascriptExecutor_Highlightelement(l);
				if(l.getText().equalsIgnoreCase(Utils.Todayd_Date()))
				{
					l.click();
					break;
				}
			}
			
			Hours_and_Min.click(); // Clicking on Hours and Mins
			Thread.sleep(2000);
			
			Utils.Setdatetime();
        	System.out.println(Utils.Timing_Am_PM());
		        Thread.sleep(6000);	
		        String am_pm_Selection=AM_PM_Selection.getText().toString();
		        if(!am_pm_Selection.equals(Utils.Timing_Am_PM()))
		        {
		        	Utils.JavascriptExecutor_Highlightelement(AM_PM_Selection);
		        	AM_PM_Selection.click();
		        }
		        
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//div[contains(text(),'Daily')]")).click(); // For Selecting Frequency Currently Not Applicable in Response Reminder
				
		        Utils.JavascriptExecutor_Highlightelement(SaveButton);
		        Utils.JavascriptExecutor_Click(SaveButton);
		        
				Thread.sleep(1000);
				String sucessmail=SuccessMessage.getText().toString(); // Getting Success Message
				System.out.println(sucessmail);	
				
				CloseButton.click(); 
			
		}		
			
		public void Rev_Summary_Monthly() throws InterruptedException
		{
			//Rev Summary Monthly
			
			Clicking_on_PostingDate.click(); //CLicking on Posting Date
			
			Utils.JavascriptExecutor_Click(Select_30_Days);
			Utils.JavascriptExecutor_Click(ApplyButton);
			Thread.sleep(2000);

			Addfilter.click(); //CLicking on Addfilter
			Select_FIlter.click(); //CLicking on select Filter
			Thread.sleep(2000);
			Utils.Selectby_VisibleText(Select_FIlter, "Modified Review"); //Selecting Modified Review
			
			driver.findElement(By.xpath("(//input[@id='availableModified'])[1]")).click();
			Thread.sleep(5000);
			
			Utils.JavascriptExecutor_Click(Modified_Apply);
			Clicking_on_PostingDate.click(); //CLicking on Posting Date
			Utils.JavascriptExecutor_Click(Select_30_Days);
			Utils.JavascriptExecutor_Click(ApplyButton);
			Thread.sleep(5000);

			String Rev_Monthlycount=Reviewtotalcount.getText().toString();
			System.out.println("----------------------------------------------");
			System.out.println("Rev MOnthly Count :-"+Rev_Monthlycount);
			System.out.println("------------------------------------------------");
			
			Click_Mail_Icon.click(); // Clicking on MAil Icon
			Thread.sleep(2000);
			Click_On_NewSchedule.click();
			
			Thread.sleep(1000);
			Utils.JavascriptExecutor_Click(Custom_Review_Filter);
			Thread.sleep(1000);

			Utils.JavascriptExecutor_Click(Click_Custom_Email_Subject_Radio);
			
			Enter_Custom_Email_Subject.sendKeys("ReV Summary Monthly "+Utils.Todayd_Date()+" "+Utils.Currnet_Month()); // Entering Custom EMail Subject
			Save_As_SchduelueName.sendKeys("ReV Summary Monthly "+Utils.Todayd_Date()+" "+Utils.Currnet_Month()); // Entering SaveasEmail
			Enter_Email_Address.sendKeys("vikrant.ambekar@testriq.com"); // Entering Email
			Enter_Email_Address.sendKeys(Keys.ENTER);		
			DatePicker.click();	
			
			Iterator<WebElement>it=Email_Date_Selection.iterator(); // Iterating Post DAta for Custom Previous and Today
			while(it.hasNext())
			{
				WebElement l=it.next();
				System.out.println( l.getText().toString());
				if(l.getText().equalsIgnoreCase(Utils.Todayd_Date()))
				{
					l.click();
					break;
				}
			}
			Thread.sleep(1000);
			Hours_and_Min.click(); // Clicking on Hours and Mins
//			Thread.sleep(2000);
			
			
			Utils.Setdatetime();
//        	System.out.println(Utils.Timing_Am_PM());
//		        Thread.sleep(7000);	
		      String am_pm_Selection=AM_PM_Selection.getText().toString();
	        if(!am_pm_Selection.equals(Utils.Timing_Am_PM()))
	        {
	        	Utils.JavascriptExecutor_Highlightelement(AM_PM_Selection);
	        	AM_PM_Selection.click();
	        }
	        
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//div[contains(text(),'Daily')]")).click(); // For Selecting Frequency Currently Not Applicable in Response Reminder
			
	        Utils.JavascriptExecutor_Highlightelement(SaveButton);
	        Utils.JavascriptExecutor_Click(SaveButton);
	        
			Thread.sleep(1000);
			String sucessmail=SuccessMessage.getText().toString(); // Getting Success Message
			System.out.println(sucessmail);	
			
			CloseButton.click(); 
			
			
		}		
		
		
		public void All_Teams_Creation() throws InterruptedException
		{
	        Thread.sleep(2000);
//			driver.findElement(By.id("appbar-avatar")).click(); // CLicking on Profile
//			driver.findElement(By.id("/users/teams-label-item-4")).click();  //CLicking on TEams TAb
//	        Thread.sleep(2000);
//			driver.findElement(By.xpath("//p[@class='add']")).click();  //CLicking on TEams TAb
//			driver.findElement(By.name("teamName")).sendKeys("All Locations User "+Utils.Todayd_Date()+" "+Utils.Currnet_Month());  //ENter TEam NAMe
//			driver.findElement(By.xpath("(//input[@id='_efd0a877-7b49-4749-970b-76c3aa1c61f5'])[1]")).click(); //Click on All Power
//	        Thread.sleep(2000);
//			
//	        
//	        
//			List<WebElement> ele=driver.findElements(By.xpath("//*[text()='Next']"));
//			// CLickking on NExts
//			System.out.println(ele.get(0).getText());
////			System.out.println(ele.get(1).getText());
//			Utils.JavascriptExecutor_Highlightelement(ele.get(0));
//			Utils.Element_Visible_Click(ele.get(0));
//			ele.get(0).click(); // Clicking on FIrst NExt BUtton
//			ele.get(1).click(); //Clicking on Second NExt BUtton
//			driver.findElement(By.xpath("//button[normalize-space()='Create Team']")).click(); // CLicking on Create Team
			
			//Creating New User
			
			driver.findElement(By.id("appbar-avatar")).click(); // CLicking on Profile
			driver.findElement(By.id("/users-label-item-5")).click(); //Clicking on tab
			Thread.sleep(3000);
			
			WebElement elo=driver.findElement(By.xpath("//*[text()='Add User']")); // Clicking on Add User Button
			Utils.JavascriptExecutor_Click(elo);
					
			driver.findElement(By.xpath("//*[text()='Add a User']")).click(); //Clicking on Add a user BUtton
			Thread.sleep(3000);
			WebElement fname=driver.findElement(By.name("firstName"));  // ENtering Fname
			Utils.JavascriptExecutor_Highlightelement(fname);
			Utils.JavascriptExecutor_Click(fname);
			
			fname.sendKeys("Xyz34");
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Xyz1");  //Entering Lname
			
			WebElement emailbox=driver.findElement(By.xpath("//input[@placeholder='Email Address']")); // ENtering Emailid
			emailbox.sendKeys("vikrat.ambekar+2294@testriq.com");
			Thread.sleep(2000);
			
			
			
			WebElement Teamlist=driver.findElement(By.xpath("//select[@placeholder='Team Name']")); // Selecting TEam name fromm Dropdown
//			Teamlist.click();
			Thread.sleep(2000);

			
			
			Utils.JavascriptExecutor_Highlightelement(Teamlist);
			Teamlist.sendKeys("Belk Region");
			Thread.sleep(2000);
			WebElement radio=driver.findElement(By.xpath("//*[text()='Send registration email to this user']"));
			System.out.println(radio.getText());
			Utils.JavascriptExecutor_Click(radio);
			System.out.println("Finally Its Done");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[normalize-space()='Save']")).click(); // CLicking on Save Button
			Thread.sleep(3000);
			String User_Created_Success=driver.findElement(By.xpath("//*[text()='The user was successfully saved.']")).getText().toString();
			System.out.println(User_Created_Success);
			driver.findElement(By.xpath("//*[text()='Close']")).click();
			System.out.println("Closing the Save Dailog");
			
			
			
			
			
			
			

			
			
			

			
			
			

		}
			
		    	

		}
		



