package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public static String getCurrentDateTimeString(String pattern)
	{
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime currentDateTime = LocalDateTime.now();
		return currentDateTime.format(format);
	}
}
