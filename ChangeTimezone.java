package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ChangeTimezone {

public static void main(String[] args) throws ParseException {

	//Get Current date.
	Date date=new Date();
	//Get default Time zone.
	TimeZone timezone=TimeZone.getDefault();
	System.out.println("Time Zone : "+timezone.getID() + " | "+timezone.getDisplayName() );
	/*
	 * d -> Day of month
	 * M -> Month of year
	 * Y -> Year
	 * h -> Hour (1-12)
	 * m -> minute
	 * s -> second
	 * a -> AM/PM
	 * z -> Time zone 
	 */
	DateFormat format=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a z");
	String dateInString=format.format(date);
	System.out.println("Current date in IST : " +dateInString);
	timezone=TimeZone.getTimeZone("Europe/London");
	System.out.println("Time Zone : "+timezone.getID() + " | "+timezone.getDisplayName() );
	format.setTimeZone(timezone);
	dateInString=format.format(date);
	System.out.println("Current date in GMT : " +dateInString);
	timezone=TimeZone.getTimeZone("America/New_York");
	System.out.println("Time Zone : "+timezone.getID() + " | "+timezone.getDisplayName() );
	format.setTimeZone(timezone);
	dateInString=format.format(date);
	System.out.println("Current date in EST : " +dateInString);
	
	}
	
}
