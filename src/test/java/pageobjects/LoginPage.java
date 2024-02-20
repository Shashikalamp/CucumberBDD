package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
  public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
		}
	@FindBy(id ="login_loginId")
	@CacheLookup
	WebElement txtUserName;
	 @FindBy(id ="login_password")
	@CacheLookup
	WebElement txtpassword;
	 
	@FindBy(xpath ="/html/body/div/div/div/div/div/div/form/div[5]/div/div/div/div/button")
	@CacheLookup
	WebElement btnLogin;
	
  public void setusername(String uname) {
	  txtUserName.sendKeys(uname);
	}
  public void setusername1(String uname) {
		 txtUserName.sendKeys(uname);
		 
	}
  
	 public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	 }
	public void clickSubmit() {
		btnLogin.click();
	}
	
	
	    }	


