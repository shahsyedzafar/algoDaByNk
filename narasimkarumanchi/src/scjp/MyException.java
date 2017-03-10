package scjp;



public class MyException {

	static String s;
	public static void main(String[] args) throws Exception  {
		
		try {
				
			} catch (Exception e) {
			try {
			try { throw new Exception();
			} catch (Exception ex) { s += "ic "; }
			throw new Exception(); }
			catch (Exception x) { s += "mc "; }
			finally { s += "mf "; }
			} finally { s += "of "; }
			System.out.println(s);
			
			
			
		
	}
	
			
}