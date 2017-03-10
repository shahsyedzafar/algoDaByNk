package narasimkarumanchi;

public class TowersOfHanoi {
	
	public static void main(String[] args) {
		TowersOfHanoi th = new TowersOfHanoi();
		th.towersofHanoi(4, 'A', 'C', 'B');
		
	}
	
	void towersofHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
		if(n==1) {
			System.out.println("Move disk 1 from peg"+fromPeg+" to peg "+toPeg);
			return;
		}
		towersofHanoi(n-1, fromPeg, auxPeg, toPeg);
		
		System.out.println("\nMove disk"+n+"from peg"+fromPeg+" to Peg "+toPeg);
		
		towersofHanoi(n-1, auxPeg, toPeg, fromPeg);
		
	}
}
