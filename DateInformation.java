package date;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to get all information about current date?
 *
 */
public class DateInformation {

	public static void main(String[] args) {
		
		//Creating Calendar class instance.
		Calendar calendar=Calendar.getInstance();
		//Converting Calendar to Date.
		Date date=calendar.getTime();
		System.out.println("Current date : "+date);
		System.out.println("\n--Date information--");
		int dayofMonth=calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Day of month : " +dayofMonth);
		int month=calendar.get(Calendar.MONTH); // 0 - January, 11 - December
		System.out.println("Month number : "+(month+1));
		String monthName=getMonthName(month);
		System.out.println("Month Name: "+monthName);
		int year=calendar.get(Calendar.YEAR);
		System.out.println("Year : "+year);
		int dayofWeek =calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day of week : "+dayofWeek);
		String dayName=getDayName(dayofWeek);
		System.out.println("Day name : "+dayName);
		int weekofMonth=calendar.get(Calendar.WEEK_OF_MONTH);
		System.out.println("Week of month :"+weekofMonth);
		int weekofYear=calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Week of year : "+weekofYear);
		int hour=calendar.get(Calendar.HOUR);
		System.out.println("Hour in 12-hour format : "+hour);
		int hourofDay=calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println("Hour in 24-hour format : "+hourofDay);
		int minute=calendar.get(Calendar.MINUTE);
		System.out.println("Minutes : "+minute);
		int second=calendar.get(Calendar.SECOND);
		System.out.println("Seconds : "+second);
		int millisecond=calendar.get(Calendar.MILLISECOND);
		System.out.println("Milliseconds : "+millisecond);
	}

	private static String getDayName(int dayofWeek) {
		
		String dayName=null;
		switch(dayofWeek)
		{
		case 1:
			dayName="Sunday";
			break;
		case 2:
			dayName="Monday";
			break;
		case 3:
			dayName="Tuesday";
			break;
		case 4:
			dayName="Wednesday";
			break;
		case 5:
			dayName="Thursday";
			break;
		case 6:
			dayName="Friday";
			break;
		case 7:
			dayName="Saturday";
			break;
		}
		return dayName;
	}

	private static String getMonthName(int month) {
	
		String monthName=null;
		switch(month)
		{
		case 0:
			monthName="January";
			break;
		case 1:
			monthName="February";
			break;
		case 2:
			monthName="March";
			break;
		case 3:
			monthName="April";
			break;
		case 4:
			monthName="May";
			break;
		case 5:
			monthName="June";
			break;
		case 6:
			monthName="July";
			break;
		case 7:
			monthName="August";
			break;
		case 8:
			monthName="September";
			break;
		case 9:
			monthName="October";
			break;
		case 10:
			monthName="November";
			break;
		case 11:
			monthName="December";
			break;
		}
		
		return monthName;
	}
	
}
