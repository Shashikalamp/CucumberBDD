package bddpro1;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 @CucumberOptions(
				// features = "/home/iram/Desktop/2023/bddpro1/Feature1/DashboardAqi.feature",
				features = "/home/iram/Desktop/2023/bddpro1/Feature1/login1.feature",
				glue = {"stepDefinitions"},
				dryRun = true,
				monochrome = false,
			  plugin = {
						"pretty", // Console output
						//"html:target/cucumber-reports", // HTML report
					//	"json:target/cucumber-report.json" ,
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
						 }

				)
		public class Runner extends AbstractTestNGCucumberTests {

	}


