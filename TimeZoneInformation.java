package date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneInformation {

	public static void main(String[] args) {
		
		//Get Current date.
		Date date=new Date();
		//Get Default Time Zone.
		TimeZone time=TimeZone.getDefault();
		System.out.println("ID : "+time.getID());
		System.out.println("TimeZone name :"+time.getDisplayName());
		//z - General timezone
		SimpleDateFormat format=new SimpleDateFormat("z");
		//Convert Date to String.
		String timezone=format.format(date); 
		System.out.println("Timezone : "+timezone);
	}
	
}
