package com.javamultiplex.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//How to check whether given date is valid or not?
public class DateValid {

	/*
	 * Date is valid if It's format is correct (For ex : dd/MM/yyyy) It exist in
	 * reality, I mean 30/02/2016 is in correct format but there is not such
	 * date in reality, So invalid.
	 */
	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter date in dd/MM/yyyy format : ");
			String date = input.next();
			if (isDateValid(date)) {
				System.out.println("Date is valid.");
			} else {
				System.out.println("Date is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	private static boolean isDateValid(String date) {

		boolean result = false;

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
				dateFormat.parse(date);
				result = true;
			} catch (ParseException e) {
				result = false;
			}
		}
		return result;
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
