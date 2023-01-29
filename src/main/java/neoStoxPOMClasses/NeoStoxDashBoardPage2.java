package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class NeoStoxDashBoardPage2
{
	 
	//1.Data member should be declared globaly with access level private using @findBy Automation
	
   @FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement PopUpOKButton;
    
// @FindBy(xpath="(//a[text()='Close'])[5]")private WebElement PopUpCloseButton;
    
    @FindBy(id="lbl_username")private WebElement UserName;
   
   @FindBy(xpath="//span[text()='Logout']") private WebElement logOutButton;
   
   @FindBy(id="lbl_curbalancetop")private WebElement acBalance;
   

   //2.Initilize within aconstructor with access level public using pagefactory

   public NeoStoxDashBoardPage2(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
 //3.Utlilize within a method with access level public
   
//   public void handlePopUp(WebDriver driver)throws InterruptedException
//   {
//	  //using  read data from excel sheet format.
//      Thread.sleep(5000); 
//      //using excel sheet format.
//	   Utility.scrollIntoView(driver, PopUpOKButton);
//	   PopUpOKButton.click();
//	   Thread.sleep(500);
//   }
	 
   // using Read data from Perproperty Files Valiate username & Ac balance verify.
   
	  public void handlePopUp(WebDriver driver)throws InterruptedException
	  { 
		  
	  Thread.sleep(5000);
      if(PopUpOKButton.isDisplayed())
      {
    	  Utility.scrollIntoView(driver, PopUpOKButton);
    	  PopUpOKButton.click();
    	  Reporter.log("clicking on PopUp OK Button ",true);
    	  Thread.sleep(500);
    	  }
      else
      { 
    	  Reporter.log("There is no PopUp", true);
      }}
	   
	 
   public void logOutFromNeostox()throws InterruptedException
   {   
	   Thread.sleep(1000);
	   UserName.click();
	   Thread.sleep(1000);
	   logOutButton.click();
	   Reporter.log("Logging out from neostox",true);
	   Thread.sleep(1000);
   }
   public String getActualUserName()
   {
	   String actualtext = UserName.getText();
	   Reporter.log("getting actual user Name",true);
	   Reporter.log("Actual user name is-->"+actualtext,true);
	   return actualtext;
   }
   public String getAcBalanace()
   {
	  String balance= acBalance.getText();
	  Reporter.log("getting AC Balance",true);
	  Reporter.log("Account balance is"+balance,true);
	  return balance;
   }}





