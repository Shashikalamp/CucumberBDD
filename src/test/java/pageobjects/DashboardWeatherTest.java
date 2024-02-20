package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DashboardWeatherTest {
	WebDriver driver;
	WebDriver ldriver;
	  public DashboardWeatherTest(WebDriver rdriver)
		{
			ldriver= rdriver;
			PageFactory.initElements(rdriver,this);
			
			}
	  @FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[2]/div/a")
	  
	   @CacheLookup
		WebElement ClickWeatherbtn;
		@FindBy(xpath ="/html/body/div/div/div/div/main/div[1]/div[1]/div[2]/div/a/div[3]/span")
		@CacheLookup
		WebElement getWeathervalue;
		public void ClickSubmitbtn() {
			ClickWeatherbtn.click();
		}
		public String  getValue() {
			String cardweatherdata = getWeathervalue.getText();
				return cardweatherdata;
			}
		
}
