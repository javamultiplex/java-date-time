package com.javamultiplex.datetime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

//How to find working and non-working days in given month?
public class WorkingAndNonWorkingDays {

	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter month name : ");
			String monthName = input.next();
			String year = null;
			int dayAndMonthNumber[] = new int[2];
			int days = 0, workingDays = 0, nonWorkingDays = 0, monthNumber=0;
			// Converting String to uppercase
			monthName = monthName.toUpperCase();
			System.out.println("Enter Year (yyyy) : ");
			year = input.next();
			if (isValidMonth(monthName) && isValidYear(year)) {
				dayAndMonthNumber = getNumberofDaysAndMonthNumberByMonthName(
						monthName, year);
				days = dayAndMonthNumber[0];
				monthNumber = dayAndMonthNumber[1];
				// Converting String to int.
				int myYear = Integer.parseInt(year);
				// Creating Calendar class instance.
				Calendar cal = Calendar.getInstance();
				// Adding given month and year in Calendar.
				cal.set(Calendar.MONTH, monthNumber);
				cal.set(Calendar.YEAR, myYear);

				/*
				 * 
				 * Adding all the dates related to given month and year to Calendar.
				 * and checking day for each date. 
				 * If it is other than Saturday and Sunday then counting as a working day.
				 * otherwise non working day.
				 * 
				 */
				for (int i = 1; i <= days; i++) {
					
					// Adding day of month in Calendar.
					cal.set(Calendar.DAY_OF_MONTH, i);
					/*
					 * cal.get(Calendar.DAY_OF_WEEK) = 1 (Sunday)
					 * cal.get(Calendar.DAY_OF_WEEK) = 7 (Saturday)
					 */
					if (cal.get(Calendar.DAY_OF_WEEK) > 1
							&& cal.get(Calendar.DAY_OF_WEEK) < 7) {
						workingDays++;
					} else {
						nonWorkingDays++;
					}
				}
				System.out.println("Working days : " + workingDays);
				System.out.println("Non working days :" + nonWorkingDays);
			} else {
				System.out.println("Month name should be valid and Year should be 4 digit long.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static int[] getNumberofDaysAndMonthNumberByMonthName(
			String monthName, String year) {

		int dayAndMonthNumber[] = new int[2];
		int days = 0;
		int monthNumber = 0;
		switch (monthName) {
		case "JANUARY":
		case "JAN":
			days = 31;
			monthNumber = 0;
			break;
		case "FEBRUARY":
		case "FEB":
			if (isLeapYear(year)) {
				days = 29;
			} else {
				days = 28;
			}
			monthNumber = 1;
			break;
		case "MARCH":
		case "MAR":
			days = 31;
			monthNumber = 2;
			break;
		case "APRIL":
		case "APR":
			days = 30;
			monthNumber = 3;
			break;
		case "MAY":
			days = 31;
			monthNumber = 4;
			break;
		case "JUNE":
			days = 30;
			monthNumber = 5;
			break;
		case "JULY":
			days = 31;
			monthNumber = 6;
			break;
		case "AUGUST":
		case "AUG":
			days = 31;
			monthNumber = 7;
			break;
		case "SEPTEMBER":
		case "SEP":
			days = 30;
			monthNumber = 8;
			break;
		case "OCTOBER":
		case "OCT":
			days = 31;
			monthNumber = 9;
			break;
		case "NOVEMBER":
		case "NOV":
			days = 30;
			monthNumber = 10;
			break;
		case "DECEMBER":
		case "DEC":
			days = 31;
			monthNumber = 11;
			break;
		}
		dayAndMonthNumber[0] = days;
		dayAndMonthNumber[1] = monthNumber;
		return dayAndMonthNumber;
	}

	private static boolean isLeapYear(String year) {

		boolean result = false;
		// Converting String to int.
		int myYear = Integer.parseInt(year);
		if ((myYear % 4 == 0 && myYear % 100 != 0) || myYear % 400 == 0) {
			result = true;
		}
		return result;
	}

	private static boolean isValidMonth(String monthName) {

		boolean result = false;
		String[] fullMonthNames = { "JANUARY", "FEBRUARY", "MARCH", "APRIL",
				"MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
				"NOVEMBER", "DECEMBER" };
		String[] halfMonthNames = { "JAN", "FEB", "MAR", "APR", "AUG", "SEP",
				"OCT", "NOV", "DEC" };
		// Converting Array to List
		List<String> fullMonths = new ArrayList<>(Arrays.asList(fullMonthNames));
		List<String> halfMonths = new ArrayList<>(Arrays.asList(halfMonthNames));
		if (fullMonths.contains(monthName) || halfMonths.contains(monthName)) {
			result = true;
		}
		return result;
	}

	private static boolean isValidYear(String year) {

		boolean result = false;
		// Regular expression that matches a String contains 4 digits.
		String pattern = "[0-9]{4}";
		if (year.matches(pattern)) {
			result = true;
		}
		return result;
	}

}
