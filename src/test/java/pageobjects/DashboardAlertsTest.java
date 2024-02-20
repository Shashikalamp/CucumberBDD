package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DashboardAlertsTest {
	WebDriver driver;
	WebDriver ldriver;
	 public DashboardAlertsTest(WebDriver rdriver)
		{
			ldriver= rdriver;
			PageFactory.initElements(rdriver,this);
			}
	  @FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[4]/div/a")
	  @CacheLookup
		WebElement ClickAlertsbtn;
		@FindBy(xpath ="//*[@id=\"root\"]/div/section/div/main/div[1]/div[1]/div[4]/div/a/div[3]/span")
		@CacheLookup
		WebElement getAlertsvalue;
		public void ClickSubmit() {
			ClickAlertsbtn.click();
		}
		public String  getValue() {
			String cardAlertsdata = getAlertsvalue.getText();
				return cardAlertsdata;
			}
		
}