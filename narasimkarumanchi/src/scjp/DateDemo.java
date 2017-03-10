package scjp;

import java.text.DateFormat;
import java.util.*;
class DateDemo {
	public static void main(String[] args) {
		/*Date d1 = new Date(100000323L);
		
		System.out.println("1st date " + d1.toString());
		Calendar c = Calendar.getInstance();
		c.setTime(d1); // #1
		
		if(Calendar.SUNDAY == c.getFirstDayOfWeek()) // #2
			System.out.println("Sunday is the first day of the week");
			System.out.println("trillionth milli day of week is " + c.get(Calendar.DAY_OF_WEEK)); // #3
			c.add(Calendar.MONTH, 1); // #4
			Date d2 = c.getTime(); // #5
			System.out.println("new date " + d2.toString() );
			*/
			
			
			
			
			Calendar c = Calendar.getInstance();
			c.set(2010, 11, 14); // December 14, 2010
			// (month is 0-based
			Date d2 = c.getTime();
			Locale locIT = new Locale("it", "IT"); // Italy
			Locale locPT = new Locale("pt"); // Portugal
			Locale locBR = new Locale("pt", "BR"); // Brazil
			Locale locIN = new Locale("hi", "IN"); // India
			Locale locJA = new Locale("ja"); // Japan
			DateFormat dfUS = DateFormat.getInstance();
			System.out.println("US " + dfUS.format(d2));
			
			DateFormat dfUSfull = DateFormat.getDateInstance(
			DateFormat.FULL);
			System.out.println("US full " + dfUSfull.format(d2));
			DateFormat dfIT = DateFormat.getDateInstance(
			DateFormat.FULL, locIT);
			
			System.out.println("Italy " + dfIT.format(d2));
			DateFormat dfPT = DateFormat.getDateInstance(
			DateFormat.FULL, locPT);
			
			System.out.println("Portugal " + dfPT.format(d2));
			DateFormat dfBR = DateFormat.getDateInstance(
			DateFormat.FULL, locBR);
			
			System.out.println("Brazil " + dfBR.format(d2));
			DateFormat dfIN = DateFormat.getDateInstance(
			DateFormat.FULL, locIN);
			
			System.out.println("India " + dfIN.format(d2));
			DateFormat dfJA = DateFormat.getDateInstance(
			DateFormat.FULL, locJA);
			
			System.out.println("Japan " + dfJA.format(d2));
			
			
			
			
			
			
			
		}
	
	
	
}