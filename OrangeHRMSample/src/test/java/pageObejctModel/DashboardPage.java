package pageObejctModel;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverContext;

public class DashboardPage extends BasePage {

	private WebDriverWait wait;
	
	@FindBy (xpath = "//input[@placeholder='Search'][contains(@class,'input')]")
	protected WebElement searchInput;
	
	@FindBy (xpath = "//li[contains(@class,'wrapper')]")
	protected List<WebElement> mainMenuList;
	
	@FindBy (xpath = "//h6[contains(@class,'topbar-header')]")
	protected WebElement pageNameHeader;
	
	@FindBy (xpath = "//button[contains(@class,'menu-button')]")
	protected WebElement hideMenuBtn;
	
	@FindBy (xpath = "//span[contains(@class,'userdropdown')]")
	protected WebElement userDropDownMenu;
	
	@FindBy (xpath = "//a[contains(@class,'userdropdown-link')]")
	protected List <WebElement> userMenuList;
	
	@FindBy (xpath = "//img[contains(@src,'orangehrm-logo.png')]")
	protected WebElement mainLogo;
	
	public DashboardPage() {
		PageFactory.initElements(DriverContext.Driver, this);
	}
	
	public void checkBasePageElements() {
		Assert.assertTrue(searchInput.isEnabled());
		Assert.assertTrue(hideMenuBtn.isEnabled());
		Assert.assertTrue(mainLogo.isDisplayed());
		
		String mainMenuHideCond = "//button[contains(@class,'main-menu')]//i[contains(@class,'chevron-right')]";
		try {
			if(DriverContext.Driver.findElement(By.xpath(mainMenuHideCond)).isDisplayed())
				hideMenuBtn.click();
		} catch (Exception e) {
		}
		
		for (WebElement webElement : mainMenuList) 
			Assert.assertTrue(webElement.isEnabled());
		openUserMenuDropDown();
	
		for (WebElement webElement : userMenuList) {
			Assert.assertTrue(webElement.isEnabled());
		}
	}
	
	public void clickUserMenu(String nameBtn) {
		openUserMenuDropDown();
		DriverContext.Driver.findElement(By.xpath("//a[contains(.,'" + nameBtn + "')]")).click();
	}
	
	public void logout() {
		openUserMenuDropDown();
		DriverContext.Driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
	}
	
	private void openUserMenuDropDown() {
		
		userDropDownMenu.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(userMenuList));
	}
}
