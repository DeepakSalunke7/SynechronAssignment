package pageObejctModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import base.DriverContext;

public class DashboardPage extends BasePage {

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement logoutButton;

	@FindBy(xpath = "(//li[@class='oxd-main-menu-item-wrapper'])[8]")
	private WebElement dashboardTab;

	@FindBy(xpath = "(//li[@class='oxd-main-menu-item-wrapper'])[8]")
	private WebElement adminTab;

	public DashboardPage() {
		PageFactory.initElements(DriverContext.Driver, this);
	}

	public void clickOnLogout() {
		logoutButton.click();
	}

	public void clickOnDashboardTab() {
		dashboardTab.click();
	}

	public void clickOnAdminTab() {
		adminTab.click();
	}

	public String getDashboardPageURL() {
		return DriverContext.Driver.getCurrentUrl();

	}

	public String getDashboardTitle() {
		return DriverContext.Driver.getTitle();
	}

}
