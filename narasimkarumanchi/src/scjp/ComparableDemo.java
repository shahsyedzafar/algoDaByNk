package scjp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;







class Student implements Comparable<Student> {
	int rollno;  
	String name;  
	int age;  
	Student(int rollno,String name,int age){  
		this.rollno=rollno;  
		this.name=name;  
		this.age=age;  
	}
	@Override
	public int compareTo(Student o) {
				
		if(age>o.age) {
			return 1;
		} else if(age<o.age) {
			return -1;
		}
		return 0;
	}
	
	public String toString() {
		return this.name;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Student && ((Student)o).name == this.name) {
			return true;
		}
		return false;
	}
	
	public int hashCode() {
		return name.length();
	}
}

class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		
		return s1.name.compareTo(s2.name);	
	}
	
}

class RollnoComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		
		if(s1.rollno<s2.rollno) {
			return -1;
		} else if(s1.rollno>s2.rollno) {
			return 1;
		}
		return 0;
	}
	
}


class PQsort implements Comparator<Integer> { // inverse sort
	public int compare(Integer one, Integer two) {
		return two - one; // unboxing
	}
}
	
public class ComparableDemo {
	
	enum Pets{DOG, CATS, HORSE};
	public static void main(String[] args) {
		List<Student> al=new ArrayList<Student>();  
		al.add(new Student(101,"Vijay",23));  
		al.add(new Student(106,"Ajay",27));  
		al.add(new Student(105,"Jai",21));
		
		System.out.println("\nComparable Demo");
		System.out.println("Unsorted List: "+al);
		Collections.sort(al);
		System.out.println("Sorted List: "+al);
		
		System.out.println("\nComparator Demo");
		
		Collections.sort(al, new RollnoComparator());
		System.out.println(al);
		
		System.out.println("\nSet Demo");
	
		Set s = new HashSet();
		boolean[] ba = new boolean[5];
		
		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a");
		ba[4] = s.add(new Object());
		for(int x=0; x<ba.length; x++)
		System.out.print(ba[x] + " ");
		System.out.println("\n");
		for(Object o : s)
		System.out.print(o + " ");
		
		System.out.println("\nMap Demo");
		
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("k1", new Student(101,"Vijay",23)); // add some key/value pairs
		m.put("k2", Pets.DOG);
		m.put(Pets.CATS, "CAT key");
		
		Student s1 = new Student(101,"clover",23);
		
		m.put(s1, "Student");
		
		s1.name = "magnolia";
		System.out.println(m.get(s1)); // #1
		s1.name = "clover";
		System.out.println(m.get(new Student(101,"clover",23))); // #2
		s1.name = "arthur";
		System.out.println(m.get(new Student(101,"xyz",23))); // #3
		
		 // let's keep this reference
		
		int[] ia = {1,5,3,7,6,9,8 }; // unordered data
		PriorityQueue<Integer> pq1 =
		new PriorityQueue<Integer>(); // use natural order
		for(int x : ia) // load queue
			pq1.offer(x);
		for(int x : ia) // review queue
			System.out.print(pq1.poll() + " ");
		System.out.println("");
		PQsort pqs = new PQsort(); // get a Comparator
		PriorityQueue<Integer> pq2 =
		new PriorityQueue<Integer>(10,pqs); // use Comparator
		for(int x : ia) // load queue
		pq2.offer(x);
		System.out.println("size " + pq2.size());
		System.out.println("peek " + pq2.peek());
		System.out.println("size " + pq2.size());
		System.out.println("poll " + pq2.poll());
		System.out.println("size " + pq2.size());
		for(int x : ia) // review queue
		System.out.print(pq2.poll() + " ");
	}
	
	


	
}
