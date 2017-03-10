package linkedlists;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList {
	private int length=0; 
	ListNode head;
	
	public LinkedList() {
		length = 0;
	}
	
	public ListNode getHead() {
		return this.head;
	}
	
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(this.head);
		head = node;
		length++;
	}
	
	public synchronized void insertAtEnd(ListNode node) {
		ListNode curr = this.head;
		if(this.head==null) {
			head =node;
		} else {
			while(curr.next != null) {
				curr = curr.getNext();
			}
			curr.setNext(node);
			node.setNext(null);
	
			
		}
		this.length++;
		
	}
	
	public void insert(int data, int position) {
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position = length;
		}
		if(head==null) {
			head = new ListNode(data);
		} else if(position==0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head.setNext(temp);
		} else {
			ListNode temp = null;
			
			
			for(int i=0;i<position;i++) {
				temp = temp.next;
			}
			ListNode newNode = new ListNode(data);
			
			newNode.next = temp.next;
			temp.next = newNode;
		}
		length+=1;
	}
	
	
	public synchronized ListNode removeFromBegin() {
		ListNode temp = head;
		if(temp!=null) {
			head = temp.next;
		} 
		return temp;
	}
	public synchronized ListNode removeFromEnd() {
		ListNode curr=head, prev=head;
		while(curr.next!=null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next=null;
		return curr;
	}
	

	
	public int ListLength(ListNode head) {
		ListNode x = head;
		int length = 0;
		while(x.getNext()!=null) {
			length++;
			x=x.getNext();
		}
		return length;
	}
	
	public void display(ListNode node) {
		ListNode x = node;
		if(x==null) {
			System.out.println("List is empty");
		} else {
			while(x.next!=null) {
				
			
					System.out.print(x.getData()+"->");
					x=x.next;
			}
			System.out.print(x.getData());
		}
		
	}
	
	public boolean isLoop(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		while(fastPtr.next!=null && fastPtr.next.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr==fastPtr) {
				return true;
			}
		}
		return false;
		
	}
	
	public ListNode beginOfloop(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		boolean loopExists = false;
		
		// checking for both - list with cycle and without cycle
		while(fastPtr.next!=null && fastPtr.next.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr) {
				loopExists = true;
				break;
			}
		}
		if(loopExists) {
			slowPtr = head;
			while(slowPtr != fastPtr) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
			return fastPtr;
		} else {
			return null;
		}	
 	}
	
	public int lengthofLoop(ListNode head) {
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		boolean loopExists = false;
		int length=0;
		
		// checking for both - list with cycle and without cycle
		while(fastPtr.next!=null && fastPtr.next.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr) {
				loopExists = true;
				break;
			}
		}
		if(loopExists) {
			slowPtr = head;
			while(slowPtr != fastPtr) {
				slowPtr = slowPtr.next;
				length++;
			}
		} 
		return length;
	}
	
	public ListNode InsertInSortedList(ListNode head, ListNode node) {
		
		if(head==null) {
			return node;
		}
		ListNode curr = head;
		ListNode prev = null;
		while(curr.getData()<node.getData() && curr != null) {
			prev = curr;
			curr = curr.next;
		}
		
		prev.next = node;
		node.next = curr;
	
		
		
		
		return head;
		
	}
	
	public ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while(curr!=null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		System.out.println("Reverse Display of list\n");
		display(prev);
		return prev;
	}
 	
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		ListNode a1 = new ListNode(10);
		ListNode a2 = new ListNode(20);
		ListNode a3 = new ListNode(30);
		ListNode a4 = new ListNode(40);
		ListNode a5 = new ListNode(50);
		ListNode a6 = new ListNode(60);
		ListNode a7 = new ListNode(1);
		ListNode a8 = new ListNode(2);
		ListNode a9 = new ListNode(3);
		
		
	/*	l.insertAtEnd(a1);
		l.insertAtEnd(a2);
		l.insertAtEnd(a3);
		
		l.insertAtEnd(a4);
		l.insertAtEnd(a5);
		l.insertAtEnd(a6);
		
		*/
		l1.insertAtEnd(a1);
		l1.insertAtEnd(a2);
		l1.insertAtEnd(a3);
		l1.insertAtEnd(a4);
		l1.insertAtEnd(a7);
		l1.insertAtEnd(a8);
		l1.insertAtEnd(a9);
		
		
		
		l2.insertAtEnd(a5);
		l2.insertAtEnd(a6);
		
		ListNode x = l1.head;
		int flag = 0;
		while(x!=null) {
			if(x.data==40) {
				flag = 1;
			}
			if(flag==1) {
				l2.insertAtEnd(x);
			}
			x=x.next;
		}
		
		
		
		//Reversing a list
		//a6.next = a3;
		
		
		//System.out.println(l.length);
		///l.display(l.head);
		//System.out.println(" ");
		//System.out.println(l.isLoop(l.head));
		//System.out.println(l.beginOfloop(l.head).getData());
		
		//findLengthofLoop
		//System.out.println(l.lengthofLoop(l.head));
		
		// inserting a node in sorted linked list
		
		// reversing a list
		//l.display(l.head);
		//l.reverse(l.head);
		
		ArrayList<ListNode> nodes = new ArrayList<ListNode>();
		//l.reverseUsingRecursion(l.head, nodes);
		
		// findIntersectingNode
		ListNode intersec = findIntersectingNode(l1, l2);
		
	
		
		
			
		
	}

	
	public static ListNode findIntersectingNode(LinkedList l1, LinkedList l2) {
		ListNode a1 = l1.head;
		ListNode h1 = a1;
		ListNode a2 = l2.head;
		ListNode h2 = a2;
		int len1 = l1.length;
		int len2 = l2.length;
		int diff = 0;
		ListNode x;
		
		System.out.println("Lengths are"+len1+","+len2);
		
		if(len1>=len2) {
			diff = len1-len2;
			h1 = a1;
			h2 = a2;

		} else {
			diff = len2-len1;
			h1 = a2;
			h2 = a1;
		}
		
		
		System.out.println(h1.getData());
		System.out.println("Difference"+diff);
		for(int i=0;i<diff;i++) {
			h1 = h1.next;
		}
		System.out.println("Printing h1 and h2");
		System.out.println(h1.getData());
		System.out.println(h2.getData());
		
		while(h1 != null && h2!=null) {
			if(h1==h2) {
				System.out.println("printing intersec");
				System.out.println(h1);
				return h1;
			}
			h1 = h1.next;
			h2 = h2.next;
		}
		
	
		
		return null;
		
	
		
		
	
		
		
	}
	
	
	public void reverseUsingRecursion(ListNode current, ArrayList<ListNode> nodes) {
		
		if(nodes.isEmpty()) {
			nodes.add(null);
		}
		
		if(current.next!=null) {
			current.next = nodes.get(nodes.size()-1);
			nodes.add(current);
			reverseUsingRecursion(current.next, nodes);
				
		}
		if(current.next==null) {
			current.next = nodes.get(nodes.size()-1);
			nodes.add(current);
			Iterator<ListNode> it = nodes.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			
		}
		
	}
	
	
	
	
	
	
	
}
