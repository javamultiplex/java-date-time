package com.javamultiplex.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DatesArraySorter {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter how many dates you want to sort?");
		int size = input.nextInt();
		String[] dates = new String[size];
		System.out.println("Enter dates in MM/dd/yyyy format");
		for (int i = 0; i < size; i++) {
			dates[i] = input.next();
		}
		input.close();
		String[] output = getSortedDateArray(dates);
		System.out.println(Arrays.toString(output));
	}

	private static String[] getSortedDateArray(String[] dates) throws ParseException {

		int length = dates.length;
		SimpleDateFormat myDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date[] myDates = new Date[length];
		for (int i = 0; i < length; i++) {
			myDates[i] = myDateFormat.parse(dates[i]);
		}
		Arrays.sort(myDates);
		for (int i = 0; i < length; i++) {
			dates[i] = myDateFormat.format(myDates[i]);
		}
		return dates;
	}

}
