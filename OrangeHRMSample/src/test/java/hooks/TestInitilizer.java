package hooks;

import java.io.IOException;
import java.sql.Connection;
import java.time.Duration;

import base.DriverContext;
import base.FrameworkInitilize;
import config.ConfigReader;
import config.Settings;
import io.cucumber.java.Before;
import utilities.DatabaseUtil;
import utilities.LogUtil;

public class TestInitilizer extends FrameworkInitilize {

	@Before
	public void Initialize() throws IOException {
		
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

		Settings.Logs.Write("Test Cycle created");
		InitializeBrowser(Settings.BrowserType);
		Settings.Logs.Write("Browser Initialize");
		DriverContext.Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		DriverContext.Browser.GoToUrl(Settings.AUT);
		Settings.Logs.Write("Navigates to page have URL"+Settings.AUT);
		}

}
