package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
	private static SingletonDriver sd= new SingletonDriver();
	
	private WebDriver driver;
	

	
	private SingletonDriver() {
		driver= new ChromeDriver();
	}
	
	
	public static SingletonDriver getDriverInstance() {
		
		return sd;
		
	}
	

}
