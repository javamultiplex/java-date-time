package com.javamultiplex.datetime;

import java.util.Scanner;

//How to find all the leap years between two given years?
public class LeapYearsBetweenYears {

	
	public static void main(String[] args) {
		
		Scanner input=null;
		try
		{
			input=new Scanner(System.in);
			System.out.println("Enter lower limit of year : ");
			String lower=input.next();
			System.out.println("Enter upper limit of year : ");
			String upper=input.next();
			if(isValidYear(lower) && isValidYear(upper) && (lower.compareTo(upper)<0))
			{
				//Converting String to Integer
				int year1=Integer.parseInt(lower);
				int year2=Integer.parseInt(upper);
				System.out.println("Leap years : ");
				for(int i=year1;i<=year2;i++)
				{
					if(isLeapYear(i))
					{
						System.out.println(i);
					}
				}
			}
			else
			{
				System.out.println("Please enter valid year limits.");
			}
		}
		finally
		{
			if(input!=null)
			{
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
	
	private static boolean isLeapYear(int myYear) {

		boolean result = false;
		if ((myYear%4==0 && myYear%100!=0) || myYear % 400 == 0) {
			result = true;
		}
		return result;
	}
	
}
