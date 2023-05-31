package stepDefinations;

import java.sql.Connection;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.Base;
import base.BasePage;
import base.BrowserType;
import base.DriverContext;
import base.FrameworkInitilize;
import config.ConfigReader;
import config.Settings;
import hooks.TestInitilizer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObejctModel.LoginPage;
import utilities.DatabaseUtil;
import utilities.LogUtil;

public class LoginSteps extends FrameworkInitilize {

	@Given("^Open a browser$")
	public void open_a_browser() throws Throwable {
		// Initialize Config
		ConfigReader.PopulateSettings();

		// Util config for logs-Check logs working
		Settings.Logs = new LogUtil();
		Settings.Logs.CreateLogFile();
		Settings.Logs.Write("Code initialize");

		// Connection with Database- Check connection of mysqlDb
		// Connection conn = DatabaseUtil.Open(Settings.ConnectionUrl,
		// Settings.ConnectionUsername,
		// Settings.ConnectionPassword);
		// DatabaseUtil.ExecuteQuery("SELECT * FROM employee_info", conn);

		InitializeBrowser(Settings.BrowserType);
		Settings.Logs.Write("Browser Initialize");
		DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@And("^Navigates to Login Page$")
	public void user_is_on_login_page() throws Throwable {
		DriverContext.Browser.GoToUrl(Settings.AUT);
		Settings.Logs.Write("Navigates to page");
	}

	@When("^User entered admin username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_entered_admin_username_as_admin_and_password_as_admin123(String validUsername,
			String validPassword) throws Throwable {
		LoginPage loginPage = new LoginPage();
		System.out.println("enter valid credentials");
		loginPage.enterUsername(validUsername);
		loginPage.enterPassword(validPassword);
		System.out.println(validPassword);
		System.out.println("credentials entered");
		Settings.Logs.Write("Valid credentials entered");
		Thread.sleep(2000);
	}

	@And("^User clicked on Login Button$")
	public void user_clicked_on_login_button() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnLoginButton();
		Settings.Logs.Write("Click on login button");
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		System.out.println(DriverContext.Driver.getCurrentUrl());
		System.out.println("Login successful");
		Settings.Logs.Write("Login successful and close the browser");
		DriverContext.Driver.close();
	}

	@When("^User entered username as (.*) and password as (.*)$")
	public void user_entered_username_as_and_password_as(String username, String password) throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		Settings.Logs.Write("Invalid credentials entered");
	}

	@And("^User clicked on Login button$")
	public void user_clicked_on_login_button1() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnLoginButton();
		Settings.Logs.Write("Click on login button");
	}

	@Then("^Login failed$")
	public void login_failed() throws Throwable {
		Settings.Logs.Write("Login fail and close the browser");
		DriverContext.Driver.close();
	}

}
