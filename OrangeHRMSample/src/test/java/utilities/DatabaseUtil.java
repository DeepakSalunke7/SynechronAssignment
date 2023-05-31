package utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

import config.Settings;

public class DatabaseUtil {

	public static Connection Open(String connectionUrl, String connectionUsername, String connectionPassword) {
		try {
			Class.forName(Settings.DriverType).newInstance();
			return DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void Close() {
		//
	}

	public static void ExecuteQuery(String query, Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ExecuteStoredProc(String procedureName, Hashtable parameters, Connection connection) {
		try {

			int paramterLength = parameters.size();
			String paraAppender = null;
			StringBuilder builder = new StringBuilder();
			// Build the paramters list to be passed in the stored proc
			for (int i = 0; i < parameters.size(); i++) {
				builder.append("?,");
			}

			paraAppender = builder.toString();
			paraAppender = paraAppender.substring(0, paraAppender.length() - 1);

			CallableStatement stmt = connection.prepareCall("{Call " + procedureName + "(" + paraAppender + ")}");

			// Creates Enumeration for getting the keys for the parameters
			Enumeration params = parameters.keys();

			// Iterate in all the Elements till there is no keys
			while (params.hasMoreElements()) {
				// Get the Key from the parameters
				String paramsName = (String) params.nextElement();
				// Set Paramters name and Value
				stmt.setString(paramsName, parameters.get(paramsName).toString());
			}

			// Execute Query
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
