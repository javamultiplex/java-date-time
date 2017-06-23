package date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem how to convert ZonedDateTime to Date?
 *
 */
public class ConvertZonedDateTimeToDate {

	public static void main(String[] args) {

		//Get default time zone
		ZoneId defaultTimeZone = ZoneId.systemDefault();
		// Get current date and time.
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = localDateTime.atZone(defaultTimeZone);
		System.out.println("ZonedDateTime : " + zonedDateTime);
		// ZonedDateTime to Instant
		Instant instant = zonedDateTime.toInstant();
		// Convert Instant to Date.
		Date date = Date.from(instant);
		System.out.println("Date : " + date);

	}

}
