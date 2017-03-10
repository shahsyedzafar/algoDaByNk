package linkedlists;

import java.awt.List;

public class CLList {
	ListNode head;
	ListNode tail;
	int length;
	
	public CLList() {
		tail = null;
		length = 0;
	}
	
	public void add(int data) {
		ListNode temp = new ListNode(data);
		if(tail==null) {
			tail = temp;
			head = temp;
			temp.next =tail;
		} else {
			temp.next = tail.next;
			tail = temp;
		}
	}
	
	/*public void add(int data) {
		addToHead(data);
	}*/
	public void addToHead(int data) {
		ListNode temp = new ListNode(data);
		if(tail==null) {
			tail=temp;
			tail.next = tail;
		}
		temp.next = tail.next;
		tail.next = temp;
		length++;
	}
	
	public void addToTail(int data) {
		
		ListNode temp = new ListNode(data);
		temp.next = head;
		if(head == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
		length++;
		
	}
	
	
	
	public int peek() {
		return tail.getData();
		
	}
	
	public int removeFromHead() {
		ListNode temp = tail.next;
		if(temp==tail.getNext()) {
			tail = null;
		} else {
			tail.next=temp.next;
			temp.next = null;
		}
		
		length--;
		return temp.data;
	}
	
	public int removefromTail() {
		
		ListNode temp = tail;
		if(temp==tail.next) {
			tail=null;
			return temp.getData();
		} else {
			while(temp.next!=tail) {
				temp=temp.next;
			}
			temp.next = tail.next;
			int x = tail.getData();
			tail = temp;
			length--;
			return x;
		}
	}
	
	public boolean contains(int data) {
		ListNode temp = tail;
		if(temp==null) {
			return false;
		}
		while(temp.next!=tail) {
			if(temp.data==data) {
				return true;
			}
		}
		return false;
	}
 	
	public void display() {
		
		System.out.println("\n Displaying Circular Linked List");
		ListNode temp = head;
		if(temp == temp.next) {
			System.out.print(temp.data+"->");
		} else if(temp == null) {
			System.out.print("List is empty");
		} else {
			System.out.print(head.data+ "->");
			temp = head.next;
			while(temp.next!=head) {
				System.out.print(temp.data + "->");
				temp = temp.next;
				
			}
			System.out.print(temp.data);
			temp = temp.next;
			System.out.print("->" + temp.data);
		}
		
		
	}
	
	//split the circular list into two equal parts
	public void splitCLLs(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = head;
		ListNode h1,t1,h2,t2;
		while(fast.next != head && fast.next.next != head) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		if(fast.next == head) {
			t1 = prev;
			t1.next = head;
			
			tail.next = slow;
			h2 = slow;
			t2 = tail;
			
			
		} else if(fast.next.next == head) {
			h1 = head;
			t1 = slow;
			t1.next = head;
			
			h2 = slow.next;
			t2 = fast.next;
			t2.next = h2;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		CLList c = new CLList();
		CLList c1 = new CLList();
		CLList c2 = new CLList();
		
		
		ListNode a1 = new ListNode(10);
		ListNode a2 = new ListNode(20);
		ListNode a3 = new ListNode(30);
		ListNode a4 = new ListNode(40);
		ListNode a5 = new ListNode(50);
		ListNode a6 = new ListNode(60);
		
		c.addToTail(10);
		c.addToTail(20);
		c.addToTail(30);
		c.addToTail(40);
		
		
		c.display();
		c.splitCLLs(c.head);
		
		
		
	}
	
}
