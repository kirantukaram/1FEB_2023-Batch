package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility
{
  // excel
  // wait
  // ScreenShot
  // ScrollIntoView
	//read data from property file
	
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		//1.crate an objectof properties file
		Properties prop= new Properties();
		
		//2.crate file of fileInputStream
		FileInputStream myFile = new FileInputStream("C:\\Users\\Kiran\\eclipse-workspace\\kiranjava\\bin\\testpackage1\\Dipakjava\\Dipakjava\\src\\myproperty.properties");
		
		//3.load file
	    prop.load(myFile);
	    
	  //4.read data from file
	    
		String value = prop.getProperty(key);
		Reporter.log("Reading data from property file",true);
		Reporter.log("data is"+value,true);
		return value;
	}
	
	public static String  readDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
        File myFile = new File("C:\\selenium folder\\kiranExcelsheet.xlsx");
	     Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet5");
	     
	      String value= mySheet.getRow(row).getCell(cell).getStringCellValue();
		 Reporter.log("Reading data from excel row is"+row+"cell is"+cell+",true");
		 Reporter.log("data is"+value,true);
		 return value;
		 
	}
	public static void implicitWait(int time,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("waiting for"+time+"ms",true);
	}
	
	public static void takeScreenShot(WebDriver driver,String fileName) throws IOException
	{
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		 File desitination = new File("C:\\Users\\Kiran\\Desktop\\New folder 5\\Failed TC .png");
		 
		 FileHandler.copy(source, desitination);
		 Reporter.log("taking screenshot",true);
		 Reporter.log("screenShot taken and saved at"+desitination,true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		
		Reporter.log("scrolling into view to"+element.getText(),true);
	}
	
	}


	
	
	
	
	
	
	
	
	
	
	
