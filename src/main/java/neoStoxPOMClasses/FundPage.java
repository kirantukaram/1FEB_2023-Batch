package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FundPage
{
	//1.Data member should be declared globaly with access level private using @findBy Automation
	
			@FindBy(id="txt_accesspin")private WebElement passwordField;
			
			@FindBy(id="lnk_submitaccesspin")private WebElement sumbmitButton;

			
		  //2.Initilize within a constructor with access level public using pagefactory
			  
	 public FundPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
		  //3.Utlilize within a method with access level public
			
	 public void enterPassword(CharSequence[] password)
			{
				passwordField.sendKeys(password);
				Reporter.log("entering password",true);
			}
	 public void clickOnSubmitButton() throws InterruptedException
			{
				Thread.sleep(500);
				sumbmitButton.click();
				Reporter.log("clicking on submit button",true);
			}
	        }



