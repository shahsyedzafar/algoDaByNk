package scjp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class GenericEx2 {

	public static void main(String[] args) {
		/*GenericEx2 ge = new GenericEx2();
		ge.foo();*/
		/*Set s = new TreeSet();
		s.add("1");
		s.add(1);*/
		
			String[] s = {"map", "pen", "marble", "key"};
			Othello o = new Othello();
			Arrays.sort(s,o);
			
			for(String s2: s) System.out.print(s2 + " ");
				System.out.println(Arrays.binarySearch(s, "pen", o));
			}
			static class Othello implements Comparator<String> {
				public int compare(String a, String b) { return b.compareTo(a); }
			}
	
	public void foo() {
		//Dog[] d = {new Dog(), new Dog()};
		addAnimal(new ArrayList<Dog>());
		
	}
	
	public void addAnimal(List<? super Dog> al) {
		/*a[0] = new Dog();
		a[1] = new Cat();*/
	}
}
