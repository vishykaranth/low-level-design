package com.de.codecentric.java8examples.timeapi;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

//import sun.util.BuddhistCalendar;

/**
 * <a href="http://blog.joda.org/2009/11/why-jsr-310-isn-joda-time_4941.html">Why JSR-310 isn't Joda-Time</a><br/>
 * <a href="http://jug.ua/wp-content/uploads/2013/02/JODAjsr310.pdf">nice presentation (JUG Ukraine)</a><br/>
 * <a href="http://openjdk.java.net/projects/threeten/">project page</a><br/>
 * <a href= "http://download.java.net/jdk8/docs/api/java/time/package-summary.html" >Java-Doc</a><br/>
 * 
 * <br>
 * <h3>Joda</h3>
 * <ul>
 * <li>Instant - Milliseconds from 1970-01-01T00:00Z</li>
 * <li>Partial - Only partially represent a date or time in the datetime continuum.</li>
 * <li>Interval - Time between two instants (TimeZone aware)</li>
 * <li>Duration - No TimeZone aware or Chronology, just millis</li>
 * <li>Period - No TimeZone aware or Chronology, defined in terms of fields, for ex: 1 day 5 hrs. Differs from Duration in that it is inexact in terms of
 * millis.</li>
 * <li>Chronology - Pluggable chronologies. A Chronology is obtained and used in Joda-Time as a singleton (Iso is default)</li>
 * <li>TimeZone - Bazed on TZ(Olson). Frquently updatable. You can also update whenever required.</li>
 * </ul>
 * <ul>
 * <li>LocalDate - just date w/o tz, e.g. 2013-02-22</li>
 * <li>LocalTime - just time w/o tz, e.g. 10:15:30</li>
 * <li>LocalDateTime - date and time w/o offset, e.g. 2013-02-22 T10:15:30</li>
 * <li>DateTime - date with time and DateTimeZone</li>
 * </ul>
 * 
 * <h3>JSR-310</h3>
 * <ul>
 * <li>Instant - An instant is a specific point on a discretized timeline. An example of an instant is "January 7, 2008, at time 23:00:00.0 UTC."</li>
 * <li>
 * Partial (for example MonthDay, YearMonth)- A partial is an indication of date or time that is not sufficient to specify a specific, unique point on the
 * timeline. For example, "June 7" is a partial, because it specifies a month and day, but it does not specify a year or time of day.</li>
 * <li>Interval - Was planned, but removed later - NOT EXISTING</li>
 * <li>Duration - A duration represents a length of elapsed time, defined to the nanosecond level; for example, "100,000 nanoseconds" is a duration.</li>
 * <li>Period - Like durations, periods represent a length of elapsed time. Examples of periods are "4 years, 8 days," and "1 hour." As shown by these examples,
 * periods are defined using calendar fields (years, days, hours, etc.), rather than by an exact number of nanoseconds.</li>
 * <li>Chronology - A calendar system, used to organize and identify dates. (Iso is default for LocalDate)</li>
 * </ul>
 * <ul>
 * <li>LocalDate - just date w/o tz, e.g. 2013-02-22</li>
 * <li>LocalTime - just time w/o tz, e.g. 10:15:30</li>
 * <li>LocalDateTime - date and time w/o offset, e.g. 2013-02-22 T10:15:30</li>
 * <li>ZoneOffset - offset against UTC (positive or negative), e.g. +05:00, +01:00, -02:00, +04:30, Z, CEST, UTC, GMT</li>
 * <li>OffsetDate - date w/o time but with offset, e.g. 2013-12-03+02:00</li>
 * <li>OffsetTime - time w/o date but with offset, e.g. 10:15:30+02:00</li>
 * <li>OffsetDateTime - date with time and offset</li>
 * <li>ZonedDateTime - date with time and Zone</li>
 * </ul>
 * 
 * @author daniel.reuter
 */
public class TimeApiTest {

    @Test
    public void timeBetweenToDates() {
	// JSR-310
	LocalDate birthday = LocalDate.of(1981, 9, 3);
	Period between = Period.between(birthday, LocalDate.now());
	System.out.println(between.getYears() + " Years " + between.getMonths() + " Months " + between.getDays() + " Days.");
	assertEquals(32, between.getYears());
	assertEquals(2, between.getMonths());

	// Joda
	org.joda.time.LocalDate birthdayJoda = new org.joda.time.LocalDate(1981, 9, 3);
	org.joda.time.Period betweenJoda = new org.joda.time.Period(birthdayJoda, org.joda.time.LocalDate.now());
	System.out.println(betweenJoda.getYears() + " Years " + betweenJoda.getMonths() + " Months " + betweenJoda.getDays() + " Days.");
	assertEquals(32, betweenJoda.getYears());
	assertEquals(2, betweenJoda.getMonths());
	
	// Date & Calendar
	Calendar birthdayCalendar = Calendar.getInstance();
	birthdayCalendar.set(1981, Calendar.SEPTEMBER, 3);
	int diffYears = Calendar.getInstance().get(Calendar.YEAR) - birthdayCalendar.get(Calendar.YEAR);
	int diffMonth = Calendar.getInstance().get(Calendar.MONTH) - birthdayCalendar.get(Calendar.MONTH);
	assertEquals(32, diffYears);
	assertEquals(2, diffMonth);
    }

    @Test
    public void checkDateIsInInterval() {
	// JSR-310 - No support - manually
	LocalDate birthday = LocalDate.of(1981, 9, 3);
	LocalDate now = LocalDate.now();
	assertFalse(checkInterval(birthday, now, LocalDate.of(1980, 1, 1)));
	assertTrue(checkInterval(birthday, now, LocalDate.of(1985, 1, 1)));

	// Joda
	Interval interval = new Interval(new DateTime(1981, 9, 3, 12, 0), DateTime.now());
	assertFalse(interval.contains(new DateTime(1980, 1, 1, 12, 0)));
	assertTrue(interval.contains(new DateTime(1985, 1, 1, 12, 0)));
	
	// Date & Calendar
	Calendar birthdayCalendar = Calendar.getInstance();
	birthdayCalendar.set(1981, Calendar.SEPTEMBER, 3);
	Calendar nowCalendar = Calendar.getInstance();
	assertFalse(checkInterval(birthdayCalendar, nowCalendar, new GregorianCalendar(1980, 1, 1)));
	assertTrue(checkInterval(birthdayCalendar, nowCalendar, new GregorianCalendar(1985, 1, 1)));
	
    }

    private boolean checkInterval(LocalDate from, LocalDate to, LocalDate date) {
	return from.isBefore(date) && to.isAfter(date);
    }
    
    private boolean checkInterval(Calendar from, Calendar to, Calendar date) {
	return date.getTime().after(from.getTime()) && date.getTime().before(to.getTime());
    }

    @Test
    public void calculate5Years() {
	// JSR-310
	LocalDate birthday = LocalDate.of(1981, 9, 3);
	LocalDate birthdayPlus = birthday.plusYears(10);
	assertEquals(birthdayPlus.getDayOfMonth(), 3);
	assertEquals(birthdayPlus.getMonth(), Month.SEPTEMBER);
	assertEquals(birthdayPlus.getYear(), 1991);

	// Joda
	org.joda.time.LocalDate birthdayJoda = new org.joda.time.LocalDate(1981, 9, 3);
	org.joda.time.LocalDate birthdayPlusJoda = birthdayJoda.plusYears(10);
	assertEquals(birthdayPlusJoda.getDayOfMonth(), 3);
	assertEquals(birthdayPlusJoda.getMonthOfYear(), 9);
	assertEquals(birthdayPlusJoda.getYear(), 1991);
	
	// Date & Calendar
	Calendar birthdayCalendar = Calendar.getInstance();
	birthdayCalendar.set(1981, Calendar.SEPTEMBER, 3);
	birthdayCalendar.add(Calendar.YEAR,10);
	assertEquals(birthdayCalendar.get(Calendar.DAY_OF_MONTH), 3);
	// !! 0-based
	assertEquals(birthdayCalendar.get(Calendar.MONTH), Calendar.SEPTEMBER);
	assertEquals(birthdayCalendar.get(Calendar.YEAR), 1991);
    }

    @Test
    public void chronologies() {
	// JSR-310
	ThaiBuddhistDate thaiBuddhistDate = ThaiBuddhistDate.now();
	int thaiYear = thaiBuddhistDate.get(ChronoField.YEAR);
	LocalDate isoDate = LocalDate.now();
	int isoYear = isoDate.get(ChronoField.YEAR);
	assertEquals(thaiYear, isoYear + 543);

	// Joda
	org.joda.time.LocalDate buddhistDateJoda = new org.joda.time.LocalDate(BuddhistChronology.getInstance());
	int buddhistYearJoda = buddhistDateJoda.get(DateTimeFieldType.year());
	org.joda.time.LocalDate dateJoda = new org.joda.time.LocalDate();
	int yearJoda = dateJoda.get(DateTimeFieldType.year());
	assertEquals(buddhistYearJoda, yearJoda + 543);
	
	// Date & Calendar
//	BuddhistCalendar buddhistCalendar = new BuddhistCalendar();
//	int buddhistYearCalendar = buddhistCalendar.get(BuddhistCalendar.YEAR);
	Calendar calendar = Calendar.getInstance();
	int yearCalendar = calendar.get(Calendar.YEAR);
//	assertEquals(buddhistYearCalendar, yearCalendar + 543);
    }
    

    @Test
    public void timezoneAndOffset() throws InterruptedException {
	// JSR-310
	LocalDateTime dateTime = LocalDateTime.now();
	ZonedDateTime zonedDateTimeEurope = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
	ZonedDateTime zonedDateTimeUTC = ZonedDateTime.of(dateTime, ZoneId.of("UTC"));

	assertEquals(60 * 60 * 1, zonedDateTimeEurope.getOffset().getTotalSeconds());
	assertEquals("Europe/Berlin", zonedDateTimeEurope.getZone().getId());
	//!!
	assertTrue(zonedDateTimeEurope.isBefore(zonedDateTimeUTC)); 
	assertFalse(zonedDateTimeEurope.isAfter(zonedDateTimeUTC));
	assertFalse(zonedDateTimeEurope.isEqual(zonedDateTimeUTC));

	// Joda
	Date date = new Date();
	DateTime dateTimeEuropeJoda = new DateTime(date.getTime(),DateTimeZone.getDefault());
	DateTime dateTimeUTCJoda = new DateTime(date.getTime(),DateTimeZone.UTC);

	assertEquals(60 * 60 * 1 * 1000, dateTimeEuropeJoda.getZone().getOffset(dateTimeEuropeJoda.getMillis()));
	assertEquals("Europe/Berlin", dateTimeEuropeJoda.getZone().getID());
	//!!
	assertFalse(dateTimeEuropeJoda.isBefore(dateTimeUTCJoda));
	assertFalse(dateTimeEuropeJoda.isAfter(dateTimeUTCJoda));
	assertTrue(dateTimeEuropeJoda.isEqual(dateTimeUTCJoda));
	
	// Date & Calendar
	Calendar calendarEurope = Calendar.getInstance();
	calendarEurope.setTime(date);
	Calendar calendarUTC = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	calendarEurope.setTime(date);
	assertFalse(calendarEurope.getTime().before(calendarUTC.getTime()));
	assertFalse(calendarEurope.getTime().after(calendarUTC.getTime()));
	assertTrue(calendarEurope.getTime().equals(calendarUTC.getTime()));
    }

    @Test
    public void parsingAndFormatting() {
	// JSR-310
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	LocalDate parsedLocalDate = LocalDate.parse("03.09.1981", fmt);
	assertEquals(LocalDate.of(1981, 9, 3), parsedLocalDate);
	assertEquals("03.09.1981", fmt.format(LocalDate.of(1981, 9, 3)));

	// Joda
	org.joda.time.format.DateTimeFormatter fmtJoda = DateTimeFormat.forPattern("dd.MM.yyyy");
	org.joda.time.LocalDate parsedDateJoda = org.joda.time.LocalDate.parse("03.09.1981", fmtJoda);
	assertEquals(new org.joda.time.LocalDate(1981, 9, 3), parsedDateJoda);
	assertEquals("03.09.1981", fmtJoda.print(new org.joda.time.LocalDate(1981, 9, 3)));
	
	// Date & Calendar
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	Date parsedDate = null;
	try {
	    parsedDate= dateFormat.parse("03.09.1981");
	} catch (ParseException e) {
	    // handle
	}
	assertEquals(new GregorianCalendar(1981, Calendar.SEPTEMBER,3).getTime(), parsedDate);
	assertEquals("03.09.1981", dateFormat.format(new GregorianCalendar(1981, Calendar.SEPTEMBER,3).getTime()));
    }

}