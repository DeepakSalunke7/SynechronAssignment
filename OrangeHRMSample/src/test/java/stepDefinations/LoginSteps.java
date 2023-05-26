package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.Base;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObejctModel.LoginPage;

public class LoginSteps extends BasePage {

	WebDriver driver;
	LoginPage loginPage;

	@Given("^User is in the Login Page$")
	public void user_is_in_the_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\deepa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("open browser");
	}

	@When("^User entered admin username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_entered_admin_username_as_something_and_password_as_something(String validUsername,
			String validPassword) throws Throwable {
		loginPage.enterUsername(validUsername);
		loginPage.enterPassword(validPassword);

	}

	@And("^User clicked on Login Button$")
	public void user_clicked_on_login_button() throws Throwable {
		loginPage.clickOnLoginButton();
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		String actualUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,actualUrl);
		driver.close();
	}

	@When("^User entered username as (.*) and password as (.*)$")
	public void user_entered_username_as_and_password_as(String username, String password) throws Throwable {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@Then("^Login failed$")
	public void login_failed() throws Throwable {
		Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
				driver.getCurrentUrl());
		driver.close();
	}

}
