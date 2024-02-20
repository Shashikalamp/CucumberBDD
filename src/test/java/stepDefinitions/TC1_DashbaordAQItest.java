package stepDefinitions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.DashboardAQITest1;
import pageobjects.DashboardWeatherTest;
import pageobjects.LoginPage;

public class TC1_DashbaordAQItest   {
	private WebDriver ldriver;
	public LoginPage lp;
	public static WebDriver driver;
	public TC1_DashbaordAQItest() {
        this.driver = Hooks.getDriver();
        this.lp = new LoginPage(driver);
    }

	@Given("user launch the chrome browser")
	public void user_launch_the_chrome_browser() throws InterruptedException {
		System.out.println("Chrome browser is launching");
		/*System.setProperty("webdriver.chrome.driver", "/home/iram/Desktop/chromedriver-linux64/chromedriver");
		driver = new ChromeDriver();*/
		WebDriver driver = Hooks.getDriver();
		Thread.sleep(3000);
	}

	@When("user navigate to the URL {string}")
	public void user_navigate_to_the_url(String url) throws InterruptedException {
		driver.get(url);
		Thread.sleep(3000);
	}

	@Given("user enter the username {string} and password {string}")
	public void user_enter_the_username_and_password(String uname, String pwd) throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(3000);
		lp.setusername("admin");
		Thread.sleep(3000);
		lp.setpassword("admin123");
	}

	@Given("click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		LoginPage lp= new LoginPage(driver);
		Thread.sleep(5000);
		lp.clickSubmit();
	}
	@Then ("login is successfully")
	public void login_is_successfully() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Login is successfully and home page is displayed");
	}

	@Given("user on the dashboard page")
	public void useronthedashboard_page() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Dashboard page shown");
		Thread.sleep(3000);		
	}

	@When("user click on AQI button")
	public void user_click_on_aqi_button() throws InterruptedException {
		DashboardAQITest1 dashaqi = new DashboardAQITest1(driver);
		dashaqi.clickSubmit();
		Thread.sleep(5000);
	}
	@Then("user can view the Environment aqi page")
	public void user_can_view_the_environment_aqi_page() throws InterruptedException {
		System.out.println("Environment aqi page shown");

	}
	@When("user click back button")
	public void user_click_back_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().back();
	}
	@Then(" User can view the dashboard aqi page")
	public void dashboardaqipage() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Dashboard page is opened");

	}

	@Given("user navigate to dashboard aqi value page")
	public void user_navigate_to_dashboard_aqi_value_page() {
		System.out.println("dashboard aqi value page shown");
	}


	@When("user click on AQi button and get AQI value")
	public void user_again_click_on_aqi_button_and_get_aqi_value() throws InterruptedException {
		DashboardAQITest1 dashaqi = new DashboardAQITest1(driver);
		Thread.sleep(3000);
		String cardvalue =dashaqi.getValue();
		Thread.sleep(3000);
		System.out.println("UI AQI value is " + cardvalue );

	}
	@Then ("print the Ui AQI value")
	public void UIAQIValueis() throws InterruptedException {

	}

	@When("user get the AQI value from backend server using shellscript")
	public String user_get_the_aqi_value_from_backend_server_using_shellscript() {
		try {
			String command = "/opt/iram/karimnagar_ems/ems_2.2.1/bin/ems_summary_info | jq -r '.response.summary[] | select(.title == \"AQI\") | .data'";
			ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
			processBuilder.redirectErrorStream(true);

			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuilder output = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				String aqiData = line.trim();
				System.out.println("AQI server data is: " + aqiData);
				output.append(aqiData).append("\n");
			}

			process.waitFor();
			int exitCode = process.exitValue();
			System.out.println("Script executed with exit code: " + exitCode);

			return output.toString().trim();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}

	}


	@And("compare the UI AQI value with Server AQI value")
	public void compare_ui_aqi_value_with_server_aqi_value() {
		DashboardAQITest1 dt = new DashboardAQITest1(driver);
		try {
			String cardData = dt.getValue();
			System.out.println("AQI ui data  is " + cardData);
			String serverAQIData = user_get_the_aqi_value_from_backend_server_using_shellscript();
			System.out.println("AQI server data is: " + serverAQIData);
			if (cardData.equals(serverAQIData))
			{
				System.out.println("AQI data from UI is equal to AQI data from server");
			}
			else {
				System.out.println("AQI data from UI is not equal  to AQI data from server");
			}
		} catch (Exception e) {
			Assert.fail("Failed to get AQI value: " + e.getMessage()); 
		}

	}
	@Then("print Both Ui and server AQI value is matched or not")
	public void print_both_ui_and_server_aqi_value_is_matched_or_not() {
	System.out.println("Both Ui and server AQI value should be matched ");
	}
	@Given ("user on the dashboard weather page")
	public void dashboardweatherpage() {
		System.out.println("Navigate to dashboard weather page ");
	}
	@When("user click on Weather button")
	public void user_click_on_weather_button() throws InterruptedException {
		DashboardWeatherTest Dwt = new DashboardWeatherTest(driver);
		Thread.sleep(4000);
		Dwt.ClickSubmitbtn();
		Thread.sleep(3000);

	}
	@Then("user can view the Environment weather page")
	public void user_can_view_the_environment_weather_page() {
		System.out.println("Environment weather page shown");

	}
	@When(" user click back button")
	public void clickonbackbtn() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().back(); 
	}

	@Given("user navigate to dashboard weather value page")
	public void user_navigate_to_dashboard_weather_value_page() {
		System.out.println("dashboard weather value page shown");
	}

	@When("user click on weather button and get weather value")
	public void user_click_on_weather_button_and_get_weather_value() throws InterruptedException {
		DashboardWeatherTest Dwt = new DashboardWeatherTest(driver);
		Thread.sleep(4000);
		String cardvalue =Dwt.getValue();
		Thread.sleep(3000);
		System.out.println("UI Weather value is " + cardvalue );

	}

	@Then("print the Ui weather value")
	public void print_the_ui_weather_value() {

	}
	@When("user get the Weather value from backend server using shellscript")
	public String user_get_the_Weather_value_from_backend_server_using_shellscript() {
		try {
		String command = "/opt/iram/karimnagar_ems/ems_2.2.1/bin/ems_summary_info | jq -r '.response.summary[] | select(.title == \"Weather\") | .data'";
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            String serverWeatherData= line.trim();
           // System.out.println("Weather server data is: " + serverWeatherData);
            output.append(serverWeatherData).append("\n");
        }

        process.waitFor();
        int exitCode = process.exitValue();
        System.out.println("Script executed with exit code: " + exitCode);

        return output.toString().trim();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
        return null;
     
    }
	}
@And("compare the UI Weather value with Server Weather value")
public void compare_ui_Weather_value_with_server_Weather_value() {
	 DashboardWeatherTest dw = new DashboardWeatherTest(driver);
		try {
			String cardWeatherData = dw.getValue();
			 System.out.println("Weather ui data  is " + cardWeatherData);
		       String serverWeatherData = user_get_the_Weather_value_from_backend_server_using_shellscript();
	            System.out.println("Weather server data is: " + serverWeatherData);
	            if (cardWeatherData.equals(serverWeatherData))
	            {
	            	System.out.println("Weather data from UI is equal to Weather data from server");
	            }
	            else {
	            	System.out.println("Weather data from UI is  not equal to Weather data from server");
	            }
	        } catch (Exception e) {
			 Assert.fail("Failed to get Weather value: " + e.getMessage()); 
	    }
}
@Then("print Both Ui and server Weather value is matched or not")
public void print_both_ui_and_server_Weather_value_is_matched_or_not() {
System.out.println("Both Ui and server Weather value should be matched ");
}

}
