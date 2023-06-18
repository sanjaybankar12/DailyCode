package com.utility;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneConvertor {
	
	private static String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

	public static void main(String[] args) {

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		ZoneId asiaCalcuttaZoneId = ZoneId.of("Asia/Calcutta");
		System.out.println("Zoned Id: " + asiaCalcuttaZoneId);
		
		ZonedDateTime asiaCalcuttaDateTime = ZonedDateTime.of(ldt, asiaCalcuttaZoneId);
		System.out.println("Zone Date Time (Asia/Culcutta) : " + asiaCalcuttaDateTime);
		
		//System.out.println(ZoneId.getAvailableZoneIds());
		
		ZoneId americaChicagoZoneId = ZoneId.of("America/Chicago");
		System.out.println("Zoned Id: " + americaChicagoZoneId);
		
		ZonedDateTime americaChicagoDateTime = asiaCalcuttaDateTime.withZoneSameInstant(americaChicagoZoneId);
		System.out.println("Zone Date Time (America/Chicago) : " + americaChicagoDateTime);
		
		System.out.println("\n-----Date Time Formatter-----\n");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		System.out.println("Date (Asia/Culcutta) : " + asiaCalcuttaDateTime.format(dtf));
		System.out.println("Date (America/Chicago) : " + americaChicagoDateTime.format(dtf));

		
		
	}

}
