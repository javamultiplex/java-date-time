package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Rohit Agarwal
 * @category Date and Time
 * @problem How to convert Date to String?
 *
 */
public class ConvertDateToString {

	/*
	 * For converting Date to String we have to use 
	 * format() method of DateFormat class.
	 */
	public static void main(String[] args) {
		
		//Creating Date class instance
		Date date=new Date();
		System.out.println("Current date in Date format : "+date);
		/*
		 * d -> Day of month
		 * M -> Month of year
		 * y -> Year
		 */
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		String string=dateFormat.format(date);
		System.out.println("Current date in String format dd/MM/yyyy : "+string);
	}
	
}
