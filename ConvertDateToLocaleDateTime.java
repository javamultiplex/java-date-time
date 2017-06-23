package date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to convert Date to LocalDateTime
 *
 */
public class ConvertDateToLocaleDateTime {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println("Date : " + date);
		// Get system default time zone id.
		ZoneId defaultZoneId = ZoneId.systemDefault();
		// Convert Date to Instant.
		Instant instant = date.toInstant();
		// Instant + default time zone + LocalDateTime
		LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
		System.out.println("LocalDateTime : " + localDateTime);
	}

}
