package NeoStoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPOMClasses.NeoStoxDashBoardPage2;
import neoStoxPOMClasses.NeoStoxSignInPage2;
import neoStoxPOMClasses.NeostoxHomePage2;
import neoStoxPOMClasses.NeostoxPasswordPage2;
import neoStoxPOMClasses.Utility;



public class ValidateNeoStoxUserName1UsingPropertyFile extends Base
{
	// reading data from property files & Testmethod validate username & AcBalance Two Test pass 
	
        NeostoxHomePage2 home;
        NeoStoxSignInPage2 signIn;
	    NeostoxPasswordPage2 pass;
	    NeoStoxDashBoardPage2 dash;
	
	@BeforeClass
	public void launchNeoStoxApp() throws IOException 
	  {
	     lanuchBrowser();
	     home = new NeostoxHomePage2 (driver);
	     signIn =new  NeoStoxSignInPage2(driver);
         pass =new NeostoxPasswordPage2(driver);
         dash= new NeoStoxDashBoardPage2(driver);
    }    
	  	    
    @BeforeMethod
	 public void loginTONeoStox() throws InterruptedException, EncryptedDocumentException, IOException
	    {
	  	 home.clickOnSignInButton();
	  	 
	  	 Utility.implicitWait(1000, driver);
	  	 
	  	 signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobile"));
	  	 Thread.sleep(1000);
	  	 
	  	 signIn.clickOnSignInButton();
	  	 
	  	 Utility.implicitWait(1000, driver);
	  	 
	  	 pass.enterPassword(Utility.readDataFromPropertyFile("password"));
	  	 pass.clickOnSubmitButton();
	  	 
	  	
	  	 Utility.implicitWait(5000, driver);
	     dash.handlePopUp(driver);
	    }
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
    {
  	//Assert.fail();
  	 Assert.assertEquals(dash.getActualUserName(),Utility.readDataFromPropertyFile("UserName"),"Actual and Expected User Names are not matching TC is Failed"); 
  	 Utility.takeScreenShot(driver, Utility.readDataFromPropertyFile("TCD1"));
    }
  
    @Test
     public void validateAcBalance() throws IOException
	   {
	  	  Assert.assertNotNull(dash.getAcBalanace(),"AC balance is null Tc is failed");
	  	  Utility.takeScreenShot(driver, Utility.readDataFromPropertyFile("TCD2"));
	  	  }
    @AfterMethod
    public void logOutfromNeoStox() throws InterruptedException 
	 {
	  	  dash.logOutFromNeostox();
    }
     @AfterClass
	  public void CloseNeoStoxApp() throws InterruptedException
	    {
	  	  driver.close();
	  	  Reporter.log("Closing Application",true);
	  	  Thread.sleep(1000); 
	  	  
	    }}
	

  

