package com.javamultiplex.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//How to display day in different formats?
public class DisplayDay {

public static void main(String[] args) {
		
		Date date=new Date();
		DateFormat weekFormat=null;
		String day=null;
		/*
		 * u -> day number in Week (1-> Monday, 7-Sunday).
		 * MM -> Month in digits(1-12)
		 * E, EE,EEE -> day name in 3 chars
		 * EEE -> Full day name
		 */
		weekFormat=new SimpleDateFormat("u");
		day=weekFormat.format(date);
		System.out.println("Day number in week : "+day);
		weekFormat=new SimpleDateFormat("E");
		day=weekFormat.format(date);
		System.out.println("Day name in 3 chars : "+day);
		weekFormat=new SimpleDateFormat("EEEE");
		day=weekFormat.format(date);
		System.out.println("Full day name : "+day);
		
	}
	
	
}
