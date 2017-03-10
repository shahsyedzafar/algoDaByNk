package scjp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(); // added in natural order
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(1000, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		}); // added using comparator
		
		int[] ia = {1,5,3,7,6,9,8 };
		
		System.out.println("Without using Comparator(Natural Ordering)");
		for(int x: ia) {
			pq1.offer(x);
		}
		for(int x: ia) {
			System.out.print(pq1.poll() + " ");
		}
		
		System.out.println("\nUsing Compartor");
		for(int x: ia) {
			pq2.offer(x);
		}
		for(int x: ia) {
			System.out.print(pq2.poll() + " ");
		}
		
		
		List x = new ArrayList<String>();
		
		
	}

}
