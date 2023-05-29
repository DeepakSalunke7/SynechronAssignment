package stepDefinations;

import java.sql.Connection;
import java.time.Duration;

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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObejctModel.LoginPage;
import utilities.DatabaseUtil;
import utilities.LogUtil;

public class LoginSteps extends FrameworkInitilize {

	@Given("^Open a browser$")
	public void open_a_browser() throws Throwable {	
		
		ConfigReader.PopulateSettings();
		
		//Util config for logs-Check logs working
		LogUtil logUtil = new LogUtil();
		logUtil.CreateLogFile();
		logUtil.Write("Code initialize");

		//Connection with Database- Check connection of mysqlDb	
		//Connection conn = DatabaseUtil.Open(Settings.AUTConnectionString);
		//DatabaseUtil.ExecuteQuery("SELECT * FROM employee_info", conn);	
		
		InitializeBrowser(Settings.BrowserType);
		DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@And("^Navigates to Login Page$")
	public void user_is_on_login_page() throws Throwable {
		DriverContext.Browser.GoToUrl(Settings.AUT);
	}

	@When("^User entered admin username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_entered_admin_username_as_admin_and_password_as_admin123(String username, String password)
			throws Throwable {
		LoginPage loginPage = new LoginPage();
		System.out.println("enter valid credentials");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		System.out.println(password);
		System.out.println("credentials entered");
		Thread.sleep(2000);
	}

	@And("^User clicked on Login Button$")
	public void user_clicked_on_login_button() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnLoginButton();
		Thread.sleep(2000);
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Throwable {
		System.out.println(DriverContext.Driver.getCurrentUrl());
		System.out.println("Login successful");
	}

	@When("^User entered username as (.*) and password as (.*)$")
	public void user_entered_username_as_and_password_as(String username, String password) throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		System.out.println(password);
		Thread.sleep(2000);
	}

	@And("^User clicked on Login button$")
	public void user_clicked_on_login_button1() throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.clickOnLoginButton();
		Thread.sleep(2000);
	}

	@Then("^Login failed$")
	public void login_failed() throws Throwable {
		System.out.println("failed");
		// Assert.assertTrue(driver.getCurrentUrl().contains("CSRF token validation
		// failed"));
		DriverContext.Driver.close();
	}

}
