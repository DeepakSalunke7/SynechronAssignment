package config;

import java.io.IOException;
import java.util.Properties;

import base.BrowserType;

public class ConfigReader {

	public static void PopulateSettings() throws IOException {
		ConfigReader configReader = new ConfigReader();
		configReader.ReadProperty();
	}

	private void ReadProperty() throws IOException {
		Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("Config.properties"));
		Settings.ConnectionUrl = properties.getProperty("ConnectionUrl");
		Settings.ConnectionUsername = properties.getProperty("ConnectionUrl");
		Settings.ConnectionPassword = properties.getProperty("ConnectionPassword");
		Settings.LogPath = properties.getProperty("LogPath");
		Settings.DriverType = properties.getProperty("DriverType");
		Settings.AUT = properties.getProperty("AUT");
		Settings.BrowserType = BrowserType.valueOf(properties.getProperty("BrowserType"));
	}

}
