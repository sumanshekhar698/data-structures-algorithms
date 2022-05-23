package com.dsa.general;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		final ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		
//		ZonedDateTime now = ZonedDateTime.now((ZoneId.of("IST")));
		
        SimpleDateFormat sd = new SimpleDateFormat(
                "yyyy.MM.dd G 'at' HH:mm:ss z");
            Date date = new Date();
            // TODO: Avoid using the abbreviations when fetching time zones.
            // Use the full Olson zone ID instead.
            sd.setTimeZone(TimeZone.getTimeZone("IST"));
            System.out.println(sd.format(date));
            
            
            String s = "HH:MM:TMZ";
            String substring1 = s.substring(0, 5);
            String substring2 = s.substring(6);
            System.out.println(substring1);
            System.out.println(substring2);
            
//		System.out.println(now);

	}

}
