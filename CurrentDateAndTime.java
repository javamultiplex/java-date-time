package com.javamultiplex.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

//How to print current date and time in Java?
public class CurrentDateAndTime {

	public static void main(String[] args) {

		// Creating Date class instance
		Date date = new Date();
		System.out.println("Current Date and Time by Date class : " + date);

		// Creating Calendar class instance
		Calendar calendar = Calendar.getInstance();
		System.out.println("Current Date and Time by Calendar class : "
				+ calendar.getTime());

		/*
		 * Using Java 8 API classes. 1) LocalDate -> Print date 2) LocalDateTime
		 * -> Print date and Time 3) ZonedDateTime -> Print date, time and
		 * timezone
		 */

		LocalDate localDate = LocalDate.now();
		System.out.println("Current Date by LocalDate class : " + localDate);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Current Date and Time by LocalDateTime class : "
				+ localDateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Current Date, Time and Timezone by ZonedDateTime class : "
						+ zonedDateTime);
	}

}
