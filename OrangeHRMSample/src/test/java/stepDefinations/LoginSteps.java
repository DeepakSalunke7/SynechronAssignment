package stepDefinations;

import org.junit.Assert;

import base.Base;
import base.DriverContext;
import config.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObejctModel.LoginPage;

public class LoginSteps extends Base {

	@And("Ensure application is opened")
	public void ensure_application_is_opned() {
		CurrentPage = GetInstance(LoginPage.class);
		Assert.assertTrue(DriverContext.Driver.getCurrentUrl()
				.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
	}

	@When("^User entered admin username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_entered_admin_username_as_admin_and_password_as_admin123(String validUsername,
			String validPassword) throws Throwable {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername(validUsername);
		loginPage.enterPassword(validPassword);
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
		Settings.Logs.Write("Login successful and close the browser");
		Assert.assertTrue(DriverContext.Driver.getCurrentUrl()
				.contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
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
		Assert.assertTrue(DriverContext.Driver.getCurrentUrl()
				.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
		DriverContext.Driver.close();
	}

}
