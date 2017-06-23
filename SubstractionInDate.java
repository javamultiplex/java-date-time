package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SubstractionInDate {

public static final String NEW_DATE_PATTERN ="MMM. dd yyyy, EEEE";
	
	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter date in dd/MM/yyyy format :");
			String date = input.next();
			// If Date is valid, converting String to date.
			Date mydate = getValidDate(date);
			if (mydate!=null) {

				System.out.println("Enter how many years you want to subtract? : ");
				int years=input.nextInt();
				System.out.println("Enter how many months you want to subtract? : ");
				int months=input.nextInt();
				System.out.println("Enter how many weeks you want to subtract? : ");
				int weeks=input.nextInt();
				System.out.println("Enter how many days you want to subtract? : ");
				int days=input.nextInt();
				
				//Creating Calendar class instance.
				Calendar calendar=Calendar.getInstance();
				//Converting Date to Calendar
				calendar.setTime(mydate);
				
				//Adding years to Calendar date.
				calendar.add(Calendar.YEAR, -years);
				//Adding months to Calendar date.
				calendar.add(Calendar.MONTH,-months);
				//Adding weeks to Calendar date.
				calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, -weeks);
				//Adding days to Calendar date.
				calendar.add(Calendar.DAY_OF_MONTH, -days);
				
				//Converting Calendar to Date.
				Date newDate=calendar.getTime();
				DateFormat format=new SimpleDateFormat(NEW_DATE_PATTERN);
				String myNewDate=format.format(newDate);
				System.out.println("New Date : "+myNewDate);
				
				
			} else {
				System.out.println("Dates are invalid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}
	private static Date getValidDate(String date) {

		Date mydate = null;
		if (isValidDateFormat(date)) {
			/*
			 * d -> Day of month 
			 * M -> Month of year 
			 * y -> Year
			 */
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			/*
			 * By default setLenient() is true. We should make it false for
			 * strict date validations.
			 * 
			 * If setLenient() is true - It accepts all dates. If setLenient()
			 * is false - It accepts only valid dates.
			 */
			dateFormat.setLenient(false);
			try {
				mydate = dateFormat.parse(date);
			} catch (ParseException e) {
				mydate = null;
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
		String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
		boolean result = false;
		if (date.matches(pattern)) {
			result = true;
		}
		return result;
	}
	
}
