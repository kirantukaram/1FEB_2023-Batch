package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OrderPage 
{
	   //1.
		@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement mobileNumField;
			
		@FindBy(id="lnk_signup1")private WebElement SignInButton;
		   
			//2.
			
	 public OrderPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
			//3.
			
	 public void enterMobileNumber(String mobNum)
			{
				mobileNumField.sendKeys(mobNum);
				
				Reporter.log("Entering mobile number",true);
			}	
	 public void clickOnSignInButton()
			{
				SignInButton.click();
				
				Reporter.log("Clicking on sign in button",true);
			}
		}

	


