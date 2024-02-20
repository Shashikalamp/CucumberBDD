package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DashboardStationsTest {
  
	WebDriver driver;
	WebDriver ldriver;
	 public DashboardStationsTest(WebDriver rdriver)
		{
			ldriver= rdriver;
			PageFactory.initElements(rdriver,this);
			}
	  @FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[3]/div/a")
	  @CacheLookup
		WebElement ClickStationsbtn;
		@FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[3]/div/a/div[3]/span")
		@CacheLookup
		WebElement getStationsvalue;
		public void ClickstationSubmit() {
			ClickStationsbtn.click();
		}
		public String  getValue() {
			String cardStationsdata = getStationsvalue.getText();
				return cardStationsdata;
			}
		
}

