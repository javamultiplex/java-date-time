package com.javamultiplex.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem Number of weeks between two given dates.
 *
 */
public class WeeksBetweenTwoDates {

	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter first date in dd/MM/yyyy format :");
			String first = input.next();
			System.out.println("Enter second date in dd/MM/yyyy format :");
			String second = input.next();
			// If Date is valid, converting String to date.
			Date mydate1 = getValidDate(first);
			Date mydate2 = getValidDate(second);
			if (mydate1 != null && mydate2 != null) {

				int days=getNumberofDaysBetweenTwoDates(mydate1,mydate2);
				int weeks=days/7;
				int remainingDays=days%7;
				System.out.println(weeks + " Weeks "+remainingDays+" Days");
				
			} else {
				System.out.println("Dates are invalid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static int getNumberofDaysBetweenTwoDates(Date mydate1, Date mydate2) {
		/*
		 * Calculation for Date 1 We have to convert Milliseconds to
		 * Days. Step by step we are converting.
		 */
		long millisecondsInDate1 = mydate1.getTime();
		// Converting milliseconds to seconds.
		double secondsInDate1 = getSeconds(millisecondsInDate1);
		// Converting seconds to minutes.
		double minutesInDate1 = getMinutes(secondsInDate1);
		// Converting minutes to hours.
		double hourInDate1 = getHours(minutesInDate1);
		// Converting hours to days.
		double daysInDate1 = getDays(hourInDate1);

		/*
		 * Calculation for Date 2 We have to convert Milliseconds to
		 * Days. Step by step we are converting.
		 */
		long millisecondsInDate2 = mydate2.getTime();
		// Converting milliseconds to seconds.
		double secondsInDate2 = getSeconds(millisecondsInDate2);
		// Converting seconds to minutes.
		double minutesInDate2 = getMinutes(secondsInDate2);
		// Converting minutes to hours.
		double hourInDate2 = getHours(minutesInDate2);
		// Converting hours to days.
		double daysInDate2 = getDays(hourInDate2);

		int daysDiff = (int) Math.ceil(Math.abs(daysInDate1 - daysInDate2));
		return daysDiff;
	}

	//1 Second=1000 Milliseconds
	private static double getSeconds(long ms) {
		double seconds = (double) ms / 1000;
		return seconds;
	}
	
	//1 Minute=60 Seconds
	private static double getMinutes(double s) {
		double minutes = s / 60;
		return minutes;
	}
	
	//1 Hour=60 Minutes
	private static double getHours(double m) {
		double hours = m / 60;
		return hours;
	}

	//1 Day=24 Hours
	private static double getDays(double h) {
		double days = h / 24;
		return days;
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
