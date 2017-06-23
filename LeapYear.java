package date;

import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem Year is leap year or not?
 *
 */
public class LeapYear {

	/*
	 * Year is called leap year if. 
	 * 1) It is evenly divisible by 4 and not by 100. 
	 * 2) It is evenly divisible by 400.
	 * 
	 */
	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter year : ");
			String year = input.next();
			if (isValidYear(year)) {
				if (isLeapYear(year)) {
					System.out.println("This is leap year.");
				} else {
					System.out.println("This is not leap year.");
				}
			} else {
				System.out.println("Year should be 4 digit long.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
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

	private static boolean isLeapYear(String year) {

		boolean result = false;
		// Converting String to int.
		int myYear = Integer.parseInt(year);
		if ((myYear % 4 == 0 && myYear % 100 != 0) || myYear % 400 == 0) {
			result = true;
		}
		return result;
	}
}
