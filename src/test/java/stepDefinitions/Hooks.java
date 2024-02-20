package stepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;

public class Hooks {

	  private static WebDriver driver;
	  private  LoginPage lp;

	    @Before
	    public void setUp() {
	        System.out.println("Chrome browser is launching");
	        System.setProperty("webdriver.chrome.driver", "/home/iram/Desktop/chromedriver-linux64/chromedriver");
	        driver = new ChromeDriver();
	    }

	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	

	   public static WebDriver getDriver() {
	        return driver;
	    }
	
	}

