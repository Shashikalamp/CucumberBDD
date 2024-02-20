package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjects.LoginPage;

public class Tags {
	public static WebDriver driver;
	public LoginPage lp;
	/*public Tags() {
        this.driver = Hooks.getDriver();
        this.lp = new LoginPage(driver);
    }*/
	@Given("user navigates to the chrome browser")
	public void user_navigates_to_the_chrome_browser() {
		System.out.println("Launch the chrome browser");
	}
	@Given("user enter the url {string}")
	public void user_enter_the_url(String string) {
		driver.get("http://127.0.0.1:8282/ems");
		 System.out.println(" Navigate to the url");
	}

	@Given("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String string, String string2) throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(3000);
		lp.setusername(string);
		Thread.sleep(3000);
		lp.setpassword(string2);

	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() throws InterruptedException {
		Thread.sleep(3000);
		LoginPage lp= new LoginPage(driver);
	   lp.clickSubmit();
	   Thread.sleep(5000);
	}

	@Then("login is successful")
	public void login_is_successful() {
		
		 Assert.assertTrue(isLoginSuccessful(), "Login was not successful");
		 
	}
	 private boolean isLoginSuccessful() {
	        // Implement logic to check if login is successful
	        return true; // Example logic, replace with actual verification
	    }
	
}
