package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeOptions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	public void enter_credential(DataTable data) {
	
		//List<List<String>> credential= data.asList(String.class);
		//credential.get(0).get(0);	
		
	//	List<Map<String, String>> credential1= data.asMaps(String.class, String.class);
		
		for(Map<Object, Object> credential2: data.asMaps(String.class, String.class) ) {			
		}
	}
	

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}


}
