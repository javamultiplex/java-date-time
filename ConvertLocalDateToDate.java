package date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to convert LocalDate to Date?
 *
 */
public class ConvertLocalDateToDate {

	
	public static void main(String[] args) {
		
		ZoneId defaultTimeZone=ZoneId.systemDefault();
		//Get current date.
		LocalDate localDate=LocalDate.now();
		System.out.println("LocalDate : "+localDate);
		//Convert LocaleDate to Instant.
		Instant instant=localDate.atStartOfDay(defaultTimeZone).toInstant();
		//Convert Instant to Date.
		Date date=Date.from(instant);
		System.out.println("Date : "+date);
		
	}
	
}
