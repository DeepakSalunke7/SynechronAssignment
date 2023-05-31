package config;

import java.sql.Connection;

import base.BrowserType;
import utilities.LogUtil;

public class Settings {

	//application backend
	public static Connection AUTConnection;
	
	//application backend connection string
	public static String ConnectionUrl;
	public static String ConnectionUsername;
	public static String ConnectionPassword;
	//Logpath for framework
	public static String LogPath;
	
	public static String DriverType;
	
	public static String ExcelSheetPath;
	
	public static String AUT;
	
	public static BrowserType BrowserType;

	public static LogUtil Logs;
	
}
