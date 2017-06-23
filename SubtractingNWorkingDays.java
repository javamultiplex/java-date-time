package com.blogspot.javamultiplex.datetime;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to subtract N working days from current date?
 * 
 */
public class SubtractingNWorkingDays {

 public static void main(String[] args) {

  Scanner input = null;
  try {
   input = new Scanner(System.in);
   System.out.println("Enter number of working days : ");
   int limit = input.nextInt();
   int orignalLimit = limit;
   // Create Calendar class instance
   Calendar calendar = Calendar.getInstance();
   System.out.println("Current Date : " + calendar.getTime());
   for (int i = 1; i <= limit; i++) {
    // Subtracting 1 day from calendar.
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    /*
     * calendar.get(Calendar.DAY_OF_WEEK) = 1 (Sunday)
     * calendar.get(Calendar.DAY_OF_WEEK) = 7 (Saturday)
     * 
     * If day is either Sunday or Saturday then it is non working
     * day so Increasing the limit to compensate working days.
     */
    if ( calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
     limit++;
    }
   }
   System.out.println("Before " + orignalLimit + " working day/s Date : " + calendar.getTime());
  } finally {
   if (input != null) {
    input.close();
   }
  }

 }

}
