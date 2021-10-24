package business.dataaccess.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSqlite implements Comparable<DateSqlite> {

	private String date;
	
	public DateSqlite() {
		
	}
	
	public DateSqlite(String date) {
		this.date = date;
	}
	
	@Override
	public boolean equals(Object o) {		
		String[] a = ((DateSqlite) o).dateComponents();
		String[] b = dateComponents();	
		
		return a[0].equals(b[0]) && a[1].equals(b[1]) && a[2].equals(b[2]);
	}
	
	@Override
	public String toString() {
		return this.date;
	}

	@Override
	public int compareTo(DateSqlite date) {
		String[] a = dateComponents();
		String[] b = date.dateComponents();
		
		if(Integer.valueOf(a[0]) - Integer.valueOf(b[0]) != 0) {
			return Integer.valueOf(a[0]) - Integer.valueOf(b[0]);
		} else {
			if(Integer.valueOf(a[1]) - Integer.valueOf(b[1]) != 0) {
				return Integer.valueOf(a[1]) - Integer.valueOf(b[1]);
			} else {
				if(Integer.valueOf(a[2]) - Integer.valueOf(b[2]) != 0) {
					return Integer.valueOf(a[2]) - Integer.valueOf(b[2]);
				}
			}
		}
		return 0;
	}
	
	public DateSqlite actual() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return new DateSqlite(sdf.format(new Date()));
	}
	
	public String[] dateComponents() {
		return toString().split("-|/");
	}
	
	public int subYears(DateSqlite date) {
		String[] a = dateComponents();
		String[] b = date.dateComponents();
		
		int ya = Integer.valueOf(a[0]); 
		int yb = Integer.valueOf(b[0]);
		return ya >= yb ? ya - yb : yb - ya;
	}
}
