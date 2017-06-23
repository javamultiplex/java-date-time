package date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumberOfDaysAndWeekPerMonth {

	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter month name : ");
			String monthName = input.next();
			String year = null;
			int[] weeksAndRemainingDays = new int[2];
			int days = 0;
			// Converting String to uppercase
			monthName = monthName.toUpperCase();
			if (monthName.equals("FEBRUARY") || monthName.equals("FEB")) {
				System.out.println("Enter Year : ");
				year = input.next();
			}
			if (isValidMonth(monthName)) {
				if ((monthName.equals("FEBRUARY") || monthName.equals("FEB"))) {
					if (isValidYear(year)) {
						if (isLeapYear(year)) {
							days = 29;
						} else {
							days = 28;
						}
						System.out.println("Number of days in " + monthName
								+ " " + year + " are : " + days);
						weeksAndRemainingDays = getWeeksAndRemainingDays(days);
						System.out.println("Number of weeks in " + monthName
								+ " " + year + " are : "
								+ weeksAndRemainingDays[0] + " Weeks + "
								+ weeksAndRemainingDays[1] + " Day/s");
					} else {
						System.out.println("Year should be 4 digit long.");
					}

				} else {

					days = getNumberofDaysByMonthName(monthName);
					System.out.println("Number of days in " + monthName
							+ " are : " + days);
					weeksAndRemainingDays = getWeeksAndRemainingDays(days);
					System.out
							.println("Number of weeks in " + monthName
									+ " are : " + weeksAndRemainingDays[0]
									+ " Weeks + " + weeksAndRemainingDays[1]
									+ " Day/s");

				}
			} else {
				System.out.println("Month name is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static int[] getWeeksAndRemainingDays(int days) {

		int weeks[] = new int[2];
		weeks[0] = days / 7;
		weeks[1] = days % 7;
		return weeks;
	}

	private static int getNumberofDaysByMonthName(String monthName) {

		int days = 0;
		switch (monthName) {
		case "JANUARY":
		case "JAN":
			days = 31;
			break;
		case "MARCH":
		case "MAR":
			days = 31;
			break;
		case "APRIL":
		case "APR":
			days = 30;
			break;
		case "MAY":
			days = 31;
			break;
		case "JUNE":
			days = 30;
			break;
		case "JULY":
			days = 31;
			break;
		case "AUGUST":
		case "AUG":
			days = 31;
			break;
		case "SEPTEMBER":
		case "SEP":
			days = 30;
			break;
		case "OCTOBER":
		case "OCT":
			days = 31;
			break;
		case "NOVEMBER":
		case "NOV":
			days = 30;
			break;
		case "DECEMBER":
		case "DEC":
			days = 31;
			break;
		}

		return days;
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
