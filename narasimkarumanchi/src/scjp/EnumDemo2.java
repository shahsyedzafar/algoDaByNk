package scjp;

enum CoffeeSize {
	SMALL(8), BIG(10), HUGE(16);
	public int ounces;
	CoffeeSize(int ounces) {
		this.ounces = ounces;
	}

	public int getOunces() {
		return ounces;
	}
}


public class EnumDemo2 {
	CoffeeSize size;
	
	public static void main(String[] args) {
		int s = 323;
		EnumDemo2 drink1 = new EnumDemo2();
		drink1.size = scjp.CoffeeSize.BIG;
		
		EnumDemo2 drink2 = new EnumDemo2();
		drink2.size = scjp.CoffeeSize.HUGE;
		
		System.out.println(drink1.size.getOunces());
		
		for(CoffeeSize cs: CoffeeSize.values()) {
			System.out.println(cs+" "+cs.getOunces());
		}
	}
}
