package narasimkarumanchi;

public class IsArraySorted {
	public static void main(String[] args) {
		int[] a = {1,2,13,5};
		IsArraySorted as = new IsArraySorted();
		System.out.println(as.check(a, 4));
		
	}
	public int check(int[] a, int n) {
		if(n==1) {
			return 1;
		}
		return a[n-1]<a[n-2]?0:check(a, n-1);
	}
}
