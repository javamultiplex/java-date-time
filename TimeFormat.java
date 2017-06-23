package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to display time in different formats?
 *
 */
public class TimeFormat {

	
	public static void main(String[] args) {
		
		//Creating Date class instance.
		Date date=new Date();
		DateFormat timeFormat=null;
		String time=null;
		/*
		 * h -> Hour in day(1-12)
		 * H -> Hour in day(0-23)
		 * m -> Minute in hour
		 * s -> Second in minute
		 * a -> AM/PM
		 */
		timeFormat=new SimpleDateFormat("hh:mm:ss a");
		//Convert Date to String.
		time=timeFormat.format(date);
		System.out.println("Current time in 12 hour format : "+time);
		
		timeFormat=new SimpleDateFormat("HH:mm:ss a");
		//Convert Date to String.
		time=timeFormat.format(date);
		System.out.println("Current time in 24 hour format : "+time);
	}
	
}
