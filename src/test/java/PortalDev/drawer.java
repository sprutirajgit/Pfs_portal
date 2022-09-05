package PortalDev;

import java.util.concurrent.TimeUnit;
import java.util.regex.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class drawer {
	public static Logger log = LogManager.getLogger(drawer.class);
	private static WebDriver driver;
	
	 @BeforeSuite  
		public  void initDriver() throws Exception {
			 ChromeOptions op = new ChromeOptions();
			 op.addArguments("--disable-notifications");
			 System.out.println("the:"+op);
			System.out.println("\n Welcome \n");
			log.info("=============Automate Testing============ ");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(op);
		
			log.info("Launching chrome browser");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://portal-dev.ken42.com/");
			log.info("Launching the FrontEnd portal");
		//driver.get(Url);
			driver.manage().window().maximize();
			log.info("Maximize the Browser");	
			
		}
	 @Test
	 public  void TestVerify() throws InterruptedException {
		int time =2000;	
		String regex="Null";
		
		Automate.callSenkeys(driver, ActionXpath.email, "anand.rathi@ken42.com", time);
		Automate.CallXpath(driver, ActionXpath.SignIn, time);
		Automate.CallXpath(driver, ActionXpath.mobile, time);
		Automate.CallXpath(driver, ActionXpath.mobile2, time);
		Automate.CallXpath(driver, ActionXpath.SignIn2, time);
		Alert alert = driver.switchTo().alert(); // switch to alert
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage); // Print Alert Message
	   alert.accept();
	   Pattern pt = Pattern.compile("-?\\d+");
       Matcher m = pt.matcher(alertMessage);
       while (m.find()) {
    	   regex = m.group();
    	  
       }
       Automate.callSenkeys(driver, ActionXpath.OtpInput, regex, time);
       Automate.CallXpath(driver, ActionXpath.submit, time);
       Thread.sleep(10000);
      Automate.CallXpath(driver, ActionXpath.expand, time);
      Thread.sleep(3000);
      Automate.CallXpath(driver, ActionXpath.clickCompletedEnroll, time);
      Automate.CallXpath(driver, ActionXpath.ClickOpenEnroll, time);
      Automate.CallXpath(driver, ActionXpath.CloseExapnd, time);
      Automate.CallXpath(driver, ActionXpath.ExpandAcademic, time);
      Automate.CallXpath(driver, ActionXpath.ClickDashboard, time);
      Automate.CallXpath(driver, ActionXpath.ClickLearn, time);
      Automate.CallXpath(driver, ActionXpath.CloseAcademicExapand, time);
      Automate.CallXpath(driver, ActionXpath.ClickExam, time);
      Automate.CallXpath(driver, ActionXpath.ClickAttendance, time);
      Automate.CallXpath(driver, ActionXpath.ClickTimetable, time);
      Automate.CallXpath(driver, ActionXpath.ExpandFees, time);
      Automate.CallXpath(driver, ActionXpath.clickMyCart, time);
      Automate.CallXpath(driver, ActionXpath.clickFeeSchedule, time);
      Automate.CallXpath(driver, ActionXpath.clickFeePayment, time);
      Automate.CallXpath(driver, ActionXpath.clickManualpayment, time);
      Automate.CallXpath(driver, ActionXpath.ClickMyTranscetion, time);
      Automate.CallXpath(driver, ActionXpath.closeExpandFees, time);
      Automate.CallXpath(driver, ActionXpath.feedBack, time);
      Automate.CallXpath(driver, ActionXpath.StudentService, time);
      Automate.CallXpath(driver, ActionXpath.Event, time);
	 }
}
