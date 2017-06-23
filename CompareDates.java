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
 * @problem How to compare two given dates in java?
 *
 */
public class CompareDates {

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

				if(mydate1.compareTo(mydate2)==0)
				{
					System.out.println("Both dates are equal.");
				}
				else if(mydate1.compareTo(mydate2)>0)
				{
					System.out.println("First date comes after second date.");
				}
				else if(mydate1.compareTo(mydate2)<0)
				{
					System.out.println("First date comes before second date.");
				}
				
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
