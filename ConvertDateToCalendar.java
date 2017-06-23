package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to convert Date to Calendar?
 *
 */
public class ConvertDateToCalendar {

	/*
	 * For converting Date to Calendar we have to use
	 * setTime() method of Calendar class.
	 */
	public static void main(String[] args) {
		
		Scanner input=null;
		try
		{
			input=new Scanner(System.in);
			System.out.println("Enter date in dd/MM/yyyy format :");
			String date=input.next();
			//If Date is valid, converting String to date.
			Date mydate=getValidDate(date);
			if(mydate!=null)
			{
				System.out.println("My date : "+mydate);
				/*
				 * Creating Calendar class instance
				 * By default it returns current date. 
				 */
				Calendar calendar=Calendar.getInstance();
				//Converting Date to Calendar.
				calendar.setTime(mydate);
				//Converting Calendar to Date.
				Date calendarDate=calendar.getTime();
				System.out.println("Calendar date : "+calendarDate);
			}
			else
			{
				System.out.println("Date is invalid.");
			}
		}
		finally
		{
			if(input!=null)
			{
				input.close();
			}
		}
	
		
	}
	
	
	private static Date getValidDate(String date) {
		
		Date mydate=null;
		if(isValidDateFormat(date))
		{
			/*
			 * d -> Day of month
			 * M -> Month of year
			 * y -> Year
			 */
			DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
			/*
			 * By default setLenient() is true.
			 * We should make it false for strict date validations.
			 * 
			 * If setLenient() is true - It accepts all dates.
			 * If setLenient() is false - It accepts only valid dates.
			 */
			dateFormat.setLenient(false);
			try {
				mydate=dateFormat.parse(date);
			} catch (ParseException e) {
				mydate=null;
			}
		}
		return mydate;
	}


	private static boolean isValidDateFormat(String date) {
		
		/*
		 * Regular Expression that matches String with format dd/MM/yyyy.
		 * dd -> 01-31
		 * MM -> 01-12
		 * yyyy -> 4 digit number
		 */
		String pattern="(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
		boolean result=false;
		if(date.matches(pattern))
		{
			result=true;
		}
		return result;
	}

	
}
