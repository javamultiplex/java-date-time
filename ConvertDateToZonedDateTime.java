package com.javamultiplex.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to convert Date to ZonedDateTime?
 *
 */
public class ConvertDateToZonedDateTime {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println("Date : " + date);
		// Get system default time zone id.
		ZoneId defaultZoneId = ZoneId.systemDefault();
		// Convert Date to Instant.
		Instant instant = date.toInstant();
		// Instant + default time zone.
		ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
		System.out.println("ZonedDateTime : " + zonedDateTime);
	}

}
