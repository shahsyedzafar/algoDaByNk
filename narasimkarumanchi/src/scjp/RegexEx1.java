package scjp;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.*;

class RegexEx1 implements Serializable{
	public static void main(String [] args) {
	
		boolean b2, b;
		int i;
		String s, hits = " ";
		Scanner s1 = new Scanner(args[0]);
		Scanner s2 = new Scanner(args[0]);
		while(b = s1.hasNext()) {
		s = s1.next(); hits += "s";
		
		}
		System.out.println("First hits"+hits);
		
		while(b = s2.hasNext()) {
		if (s2.hasNextInt()) {
		i = s2.nextInt(); hits += "i";
		} else if (s2.hasNextBoolean()) {
		b2 = s2.nextBoolean(); hits += "b";
		} else {
		s2.next(); hits += "s2";
		}
		}
		System.out.println("hits " + hits);
		
		
		
		
		
		int i1 = -123;
		int i2 = 12345;
		System.out.printf(">%1$(4d< \n", i1);
		System.out.printf(">%0,7d< \n", i2);
		System.out.format(">%+-7d< \n", i2);
		System.out.printf(">%2$b + %1$5d< \n", i1, false);
		
		
		
		
	}
}