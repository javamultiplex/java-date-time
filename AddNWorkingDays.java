
package com.javamultiplex.datetime;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @Problem How to add N working days to the current date?
 * 
 */
public class AddNWorkingDays {

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
    // Adding 1 day to calendar.
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    /*
     * calendar.get(Calendar.DAY_OF_WEEK) = 1 (Sunday)
     * calendar.get(Calendar.DAY_OF_WEEK) = 7 (Saturday)
     * 
     * If day is either Sunday or Saturday then it is non working
     * day so Increasing the limit to compensate working days.
     */
    if (calendar.get(Calendar.DAY_OF_WEEK) == 1
      || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
     limit++;
    }
   }
   System.out.println("After " + orignalLimit
     + " working day/s Date : " + calendar.getTime());
  } finally {
   if (input != null) {
    input.close();
   }
  }

 }

}
