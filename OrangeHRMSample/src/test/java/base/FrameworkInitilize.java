package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FrameworkInitilize extends Base {

	public void InitializeBrowser(BrowserType browserType) {

		WebDriver driver = null;
		switch (browserType) {
		case Chrome: {
			// Open the browser
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\deepa\\Downloads\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

			break;
		}
		case Firefox: {
			// Open the browser
			// System.setProperty("webdriver.gecko.driver","path");
			driver = new FirefoxDriver();
			break;
		}
		case Safari: {
			driver = new SafariDriver();
			break;
		}
		}

		// Set the Driver
		DriverContext.setDriver(driver);
		// Browser
		DriverContext.Browser = new Browser(driver);

	}

}
