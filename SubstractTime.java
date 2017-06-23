package com.javamultiplex.datetime;

import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to subtract two given times?
 *
 */
public class SubstractTime {

	
	//1 Hour = 60 minutes = 60 * 60 =3600 seconds 
	public static final int secondsInHour=3600;
	//1 Minute = 60 seconds
	public static final int secondsInMinute=60;
	
	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(System.in);
			System.out.println("Enter first time(24 hour) in HH:mm:ss format");
			String time1 = input.next();
			System.out.println("Enter second time(24 hour) in HH:mm:ss format");
			String time2 = input.next();
			if (isTimeValid(time1) && isTimeValid(time2)) {

				// Separating first String using delimiter ":"
				String[] firstTimeParts = time1.split(":");
				// Converting String to Integer
				int hours1 = Integer.parseInt(firstTimeParts[0]);
				int minutes1 = Integer.parseInt(firstTimeParts[1]);
				int seconds1 = Integer.parseInt(firstTimeParts[2]);
				
				// Separating second String using delimiter ":"
				String[] secondTimeParts = time2.split(":");
				// Converting String to Integer
				int hours2 = Integer.parseInt(secondTimeParts[0]);
				int minutes2 = Integer.parseInt(secondTimeParts[1]);
				int seconds2 = Integer.parseInt(secondTimeParts[2]);

				int secondsInTime1=hours1*60*60 + minutes1*60 +seconds1;
				int secondsInTime2=hours2*60*60 + minutes2*60 +seconds2;
				
				int seconds=secondsInTime1-secondsInTime2;
				int hours=seconds/secondsInHour;
				int remainingSeconds=seconds-(hours*secondsInHour);
				int minutes=remainingSeconds/secondsInMinute;
				remainingSeconds=remainingSeconds-(minutes*secondsInMinute);
				
				// Converting each integer value of String and combining all strings.
				String finalTime = String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(remainingSeconds);
				System.out.println("New time is :\n" + finalTime);
				System.out.println("OR");
				System.out.println(hours + " Hours " + minutes + " Minutes " + remainingSeconds + " Seconds ");

			} else {
				System.out.println("Time is not valid.");
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

	private static boolean isTimeValid(String time) {

		boolean result = false;
		/*
		 * Regular expression that matches String with format HH:mm:ss 
		 * HH -> 0-23 
		 * mm -> 0-59 
		 * ss -> 0-59
		 */
		String pattern = "(0?[0-9]|1[0-9]|2[0-3]):(0?[0-9]|[1-5][0-9]):(0?[0-9]|[1-5][0-9])";
		if (time.matches(pattern)) {
			result = true;
		}
		return result;
	}

}
