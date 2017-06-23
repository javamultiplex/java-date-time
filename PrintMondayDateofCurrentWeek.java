package com.javamultiplex.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time Problems
 * @problem What is the date on monday in current week?
 *
 */
public class PrintMondayDateofCurrentWeek {

	public static void main(String[] args) {

		// Creating Calendar class instance.
		Calendar calendar = Calendar.getInstance();
		String currentDate = getStringFromCalendar(calendar);
		System.out.println("Current date : " + currentDate);
		// In Calendar setting day of week = 2(Monday)
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		currentDate = getStringFromCalendar(calendar);
		System.out.println("Date on Monday : " + currentDate);

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
