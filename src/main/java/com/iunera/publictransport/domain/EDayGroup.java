package com.iunera.publictransport.domain;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public enum EDayGroup {
	WEEKEND, WEEKDAY;

	

	// TODO: ensure all countries are added correctly:
	// https://en.wikipedia.org/wiki/Workweek_and_weekend#Asia_and_Australasia
	private static final List<String> sunWeekendDaysCountries = Arrays.asList(new String[] { "GQ", "IN", "TH", "UG" });
	private static final List<String> fryWeekendDaysCountries = Arrays.asList(new String[] { "DJ", "IR" });
	private static final List<String> frySunWeekendDaysCountries = Arrays.asList(new String[] { "BN" });
	private static final List<String> thuFryWeekendDaysCountries = Arrays.asList(new String[] { "AF" });
	private static final List<String> frySatWeekendDaysCountries = Arrays.asList(new String[] { "AE", "DZ", "BH", "BD",
			"EG", "IQ", "IL", "JO", "KW", "LY", "MV", "MR", "OM", "PS", "QA", "SA", "SD", "SY", "YE" });

	public static DayOfWeek[] getWeekendDays(Locale locale) {
		if (thuFryWeekendDaysCountries.contains(locale.getCountry())) {
			return new DayOfWeek[] { DayOfWeek.THURSDAY, DayOfWeek.FRIDAY };
		} else if (frySunWeekendDaysCountries.contains(locale.getCountry())) {
			return new DayOfWeek[] { DayOfWeek.FRIDAY, DayOfWeek.SUNDAY };
		} else if (fryWeekendDaysCountries.contains(locale.getCountry())) {
			return new DayOfWeek[] { DayOfWeek.FRIDAY };
		} else if (sunWeekendDaysCountries.contains(locale.getCountry())) {
			return new DayOfWeek[] { DayOfWeek.SUNDAY };
		} else if (frySatWeekendDaysCountries.contains(locale.getCountry())) {
			return new DayOfWeek[] { DayOfWeek.FRIDAY, DayOfWeek.SATURDAY };
		} else {
			return new DayOfWeek[] { DayOfWeek.SATURDAY, DayOfWeek.SUNDAY };
		}
	}
	
	public static EDayGroup getDayGroup(Instant time,ZoneId zone, Locale locale ) {
		if(Arrays.asList(getWeekendDays(locale)).contains(time.atZone(zone).getDayOfWeek() )){
			return EDayGroup.WEEKEND; 
		};
		return EDayGroup.WEEKDAY;
	}
	
}
