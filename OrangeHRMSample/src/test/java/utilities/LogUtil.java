package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import config.Settings;

public class LogUtil {

	// File format for the log name
	ZonedDateTime dateTime = ZonedDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
	String fileNameFormat = dateTime.format(formatter);

	private BufferedWriter bufferedWriter = null;

	// create log file
	public void CreateLogFile() throws IOException {
		try {
			File dir = new File(Settings.LogPath);
			if (!dir.exists())
				dir.mkdir();
			// create file
			File logFile = new File(dir + "/" + fileNameFormat + ".log");

			FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
			bufferedWriter = new BufferedWriter(fileWriter);
		} catch (Exception e) {

		}
	}

	// Write message within the log
	public void Write(String message) {
		try {
			formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
			String dateFormat = dateTime.format(formatter);
			bufferedWriter.write("[" + dateFormat + "]" + message);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (Exception e) {

		}
	}

}
