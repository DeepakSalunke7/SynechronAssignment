package pageObejctModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverContext;

public class AdminListPage extends BasePage {

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement username;

	// in-complete to handle dropdown
	@FindBy(xpath = "(//div[contains(text(),'-- Select --')])[1]")
	private WebElement usernameDropdown;

	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	private WebElement employeeName;

	// in-complete to handle dropdown
	@FindBy(xpath = "(//div[contains(text(),'-- Select --')])[2]")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addAdmin;
	
	public AdminListPage() {
		PageFactory.initElements(DriverContext.Driver, this);
	}
	
	public void enterUsername(String _employeeName) {
		username.sendKeys(_employeeName);
	}

	public void enterEmployeename(String _username) {
		username.sendKeys(_username);
	}
	
	 public CreateAdminPage ClickCreateNew()
	    {
		 addAdmin.click();
	        return GetInstance(CreateAdminPage.class);
	    }
}
