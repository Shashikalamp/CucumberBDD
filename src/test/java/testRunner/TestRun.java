package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		// features = "/home/iram/Desktop/2023/bddpro1/Feature1/DashboardAqi.feature",
		features = "/home/iram/Desktop/2023/bddpro1/Feature1/DashboardAqi.feature",
		glue = {"stepDefinitions"},
		tags ="@AQI or @Station and not @Weather",
        dryRun = true,
		monochrome = true,
		plugin = {
				"pretty", // Console output

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 

		}

		)
public class TestRun extends AbstractTestNGCucumberTests {

}
