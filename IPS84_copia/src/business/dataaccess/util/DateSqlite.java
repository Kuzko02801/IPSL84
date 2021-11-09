package business.dataaccess.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateSqlite implements Comparable<DateSqlite> {

	final static String DATE_FORMAT = "yyyy/MM/dd";	
	private LocalDate date;
	private DateTimeFormatter formatter;
	
	public DateSqlite() {}
	
	public DateSqlite(String date) {
		formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);		
		this.date = LocalDate.parse(date, formatter);
		
	}
	
	@Override
	public boolean equals(Object o) {		
		return this.date.isEqual(toLocalDate((DateSqlite) o));
	}
	
	@Override
	public String toString() {
		return this.date.format(formatter);
	}

	@Override
	public int compareTo(DateSqlite date) {
		return this.date.compareTo(toLocalDate(date));
	}
	
	public boolean isAfter(DateSqlite date) {
		return this.date.isAfter(toLocalDate(date));
	}

	public boolean isBefore(DateSqlite date) {
		return this.date.isBefore(toLocalDate(date));
	}
	
	private ChronoLocalDate toLocalDate(DateSqlite date) {
		return LocalDate.parse(date.toString(), formatter);
	}
	
	public boolean isTwoDaysHigher(DateSqlite date) {
		String[] a = dateComponents();
		String[] b = date.dateComponents();
		
		int day_a = Integer.valueOf(a[2]);
		int day_b = Integer.valueOf(b[2]);
		if ((day_b - day_a) > 2) {
			return true;
		}
		return false;
	}
	
	public DateSqlite actual() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return new DateSqlite(sdf.format(new Date()));
	}
	
	public String[] dateComponents() {
		return toString().split("/");
	}
	
	public int subYears(DateSqlite date) {
		String[] a = dateComponents();
		String[] b = date.dateComponents();
		
		int ya = Integer.valueOf(a[0]); 
		int yb = Integer.valueOf(b[0]);
		return ya >= yb ? ya - yb : yb - ya;
	}
}
