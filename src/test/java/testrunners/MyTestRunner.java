package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features = "src/test/resources/feature", 
		//glue = {"parallel/LoginPageSteps", "ApplicationHooks"},
				glue = {"parallel"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html",
				"timeline:test-output-thread/"}
		
		)

public class MyTestRunner extends AbstractTestNGCucumberTests {
	
//	@DataProvider(parallel=true)
//	@Override
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}

}
