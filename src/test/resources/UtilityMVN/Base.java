package neoStoxBase;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.Utility;

public class Base
{ 
	protected WebDriver driver;

	public void lanuchBrowser() 
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\selenium folder\\chromedriver_win32\\chromedriver.exe");
	      
	      driver= new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://neostox.com/");
	      //driver.get(Utility.readDataFromPropertyFile("urlqa"));
	   
	      Utility.implicitWait(1000, driver);
	      Reporter.log("Launching lanuchNeoStoxApp",true);
	      
	  }
}
				
		 
	  

