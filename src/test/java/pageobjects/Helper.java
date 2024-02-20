 package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Helper {
	private WebDriver driver;

	 public Helper(WebDriver driver) {
	        this.driver = driver;
	    }
   

    public void launchChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "/home/iram/Desktop/chromedriver-linux64/chromedriver");
        driver = new ChromeDriver();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void enterUsernameAndPassword(String uname, String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(3000);
        lp.setusername(uname);
        lp.setpassword(pwd);
    }

    public void clickOnLoginButton() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(3000);
        lp.clickSubmit();
    }

    public void Loginsuccesful() {
        System.out.println("Login successful");
    }
}


