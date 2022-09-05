package PortalDev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Automate {
	static Logger log = LogManager.getLogger(Automate.class);
public static void CallXpath(WebDriver driver,String xpath, int time) {
		
		try {
			
			log.info("Click on xpath:"+xpath);
		    driver.findElement(By.xpath(xpath)).click();
			log.info("Click on xpath Successfully:"+xpath);

			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("Xpath fail:"+xpath);
		
		}
	}
public static void callSenkeys(WebDriver driver,String Xpath, String Value, int time1) {
	try {
		driver.findElement(By.xpath(Xpath)).sendKeys(Value);
		Thread.sleep(time1);

	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
