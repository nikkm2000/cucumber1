package parallel;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.Messages.Timestamp;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)//run before (order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);			
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_")+"nikhilji";
					//Timestamp.SECONDS_FIELD_NUMBER;			
				
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
//			File destinationFile= new File("C:\\Users\\nkumar\\eclipse-workspace\\LatestCucumber6WithPOM-master\\LatestCucumber6WithPOM-master\\target");
//			File sourceFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(sourceFile, destinationFile);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
	@After(order = 0)//run after (order = 1)
	public void quitBrowser() {
		driver.quit();
	}

}
