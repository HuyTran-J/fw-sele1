package helpers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Timer {
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getCurrentDate() {
		return getCurrentDate("MM/dd/yyyy");
	}

	public static String getCurrentDate(String pattern) {
		String timeStamp = new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	public static LocalDateTime getToday() {
		return LocalDateTime.now();
	}
}
