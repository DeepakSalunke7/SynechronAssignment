package pageObejctModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverContext;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(DriverContext.Driver, this);
	}

	public void enterUsername(String username1) {
		username.sendKeys(username1);
	}

	public void enterPassword(String password1) {
		password.sendKeys(password1);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

}
