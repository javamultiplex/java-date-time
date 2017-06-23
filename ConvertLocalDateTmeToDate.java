package date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to convert LocalDateTime to Date?
 *
 */
public class ConvertLocalDateTmeToDate {

	public static void main(String[] args) {

		//Get default time zone.
		ZoneId defaultTimeZone = ZoneId.systemDefault();
		// Get current date and time.
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime : " + localDateTime);
		// Convert LocaleDateTime to Instant.
		Instant instant = localDateTime.atZone(defaultTimeZone).toInstant();
		// Convert Instant to Date.
		Date date = Date.from(instant);
		System.out.println("Date : " + date);

	}

}
