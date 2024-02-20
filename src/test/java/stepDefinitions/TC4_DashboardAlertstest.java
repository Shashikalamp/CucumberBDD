package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.DashboardAlertsTest;
import pageobjects.DashboardStationsTest;
import pageobjects.LoginPage;

public class TC4_DashboardAlertstest {
	private WebDriver ldriver;
	public LoginPage lp;
	public WebDriver driver;
	@When("user click on Alerts button")
	public void user_click_on_alerts_button() throws InterruptedException {
		DashboardAlertsTest dat = new DashboardAlertsTest(driver) ;
		Thread.sleep(7000);
		dat.ClickSubmit();
	}
	@Then("user can view the Device alerts page")
	public void user_can_view_the_device_alerts_page() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Alerts page shown");
	}

}
