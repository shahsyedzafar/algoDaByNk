package scjp;
import java.text.NumberFormat;
import java.util.regex.*;

public class SelfTestIO {
	
	public static void main(String[] args) {
		

		
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("ab34ef");
		boolean b = true;
		
		while(b) {
			b = m.find();
			System.out.println("\nFound match");
		System.out.print("Start "+ m.start() +"\tGroup: " +m.group());
		}
		
		
	}
		
		
}
