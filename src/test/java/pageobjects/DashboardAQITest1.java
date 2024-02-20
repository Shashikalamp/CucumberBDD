package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardAQITest1 {
	WebDriver driver;
	WebDriver ldriver;
	public DashboardAQITest1(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);

 } 
	@FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[1]/div/a")
	@CacheLookup 
	WebElement ClickAQIbtn;
	@FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[1]/div/a/div[3]/span")
	@CacheLookup
	WebElement getAQIvalue;



	public void clickSubmit() {
		ClickAQIbtn.click();
	}
	public String  getValue() {
		String carddata =getAQIvalue.getText();
		return carddata;
	}



}
