package com.blogspot.javamultiplex.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time Problems
 * @problem Day after N years?
 *
 */
public class DayAfterNYears {

	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter number of years : ");
			int years = input.nextInt();
			// Creating Calendar class instance
			Calendar calendar = Calendar.getInstance();
			String currentDate = getStringFromCalendar(calendar);
			int dayofWeek = calendar.get(Calendar.DAY_OF_WEEK);
			String dayName = getDayName(dayofWeek);
			System.out.println("Current Date (dd/MM/yyyy) :" + currentDate + " and Day :" + dayName);
			// Adding years in Calendar.
			calendar.add(Calendar.YEAR, years);
			String newDate = getStringFromCalendar(calendar);
			dayofWeek = calendar.get(Calendar.DAY_OF_WEEK);
			dayName = getDayName(dayofWeek);
			System.out.println("After " + years + " year/s Date (dd/MM/yyyy) :" + newDate + " and Day :" + dayName);

		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static String getDayName(int dayofWeek) {

		String dayName = null;
		switch (dayofWeek) {
		case 1:
			dayName = "Sunday";
			break;
		case 2:
			dayName = "Monday";
			break;
		case 3:
			dayName = "Tuesday";
			break;
		case 4:
			dayName = "Wednesday";
			break;
		case 5:
			dayName = "Thursday";
			break;
		case 6:
			dayName = "Friday";
			break;
		case 7:
			dayName = "Saturday";
			break;
		}
		return dayName;
	}

	private static String getStringFromCalendar(Calendar calendar) {

		// Converting Calendar to Date.
		Date currentDate = calendar.getTime();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		// Converting Date to String.
		String myCurrentDate = format.format(currentDate);
		return myCurrentDate;
	}

}
