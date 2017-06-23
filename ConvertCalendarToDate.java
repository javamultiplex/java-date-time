package date;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem Convert Calendar to Date.
 *  
 */
public class ConvertCalendarToDate {

	/*
	 * For converting Calender to Date we have to use
	 * getTime() method of Calendar class.
	 */
	public static void main(String[] args) {
		
		//Creating Calendar class instance
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		System.out.println("Current date : " + date);
		
	}
	
}
