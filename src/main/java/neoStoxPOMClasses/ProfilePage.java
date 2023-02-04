package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProfilePage 
{
	//1.Data member should be declared globaly with access level private using @findBy Automation
	
			@FindBy(xpath="(//a[text()='Sign In'])[1]")private WebElement signInButton;

		 //2.Initilize within a constructor with access level public using pagefactory
				  
			public ProfilePage(WebDriver driver)
			
			{
					PageFactory.initElements(driver, this);
					
			}
	//3.Utlilize within a method with access level public
			
				
		 public void clickOnSignInButton() throws InterruptedException
		 
			{
					Thread.sleep(1000);
					
					
					signInButton.click();
					
					
					
					Reporter.log("clicling on signin button",true);
		}
		   } 
	


