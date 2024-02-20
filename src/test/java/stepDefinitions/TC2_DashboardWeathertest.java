package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.DashboardAQITest1;
import pageobjects.DashboardStationsTest;
import pageobjects.DashboardWeatherTest;
import pageobjects.LoginPage;

public class TC2_DashboardWeathertest {
	//private WebDriver ldriver;
   WebDriver ldriver;
   public LoginPage lp;
	public static WebDriver driver;
	

	@Given("user on the station dashboard page")
	public void user_on_the_station_dashboard_page() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(5000);
		System.out.println("Dashboard page shown");
				
	}

	@When("user click on Station button")
	public void user_click_on_Station_button() throws InterruptedException {
		DashboardStationsTest dashst = new DashboardStationsTest(driver);
		Thread.sleep(3000);
		dashst.ClickstationSubmit();
		Thread.sleep(5000);
	}
	
	@Then("user can view the Device station page")
	public void user_can_view_the_Device_station_page() throws InterruptedException {
		System.out.println("Device station page shown");

	}
	@When("user click on station back button")
	public void user_click_on_station_back_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().back();
	}
}
