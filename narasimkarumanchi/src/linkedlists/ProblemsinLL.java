package linkedlists;

import java.util.Stack;

public class ProblemsinLL {
	public static void main(String[] args) {
			
		ProblemsinLL m = new ProblemsinLL();
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		LinkedList l3 = new LinkedList();
		
		LinkedList l4 = new LinkedList();
		LinkedList l5 = new LinkedList();
		
		
		
		ListNode a1 = new ListNode(10);
		ListNode a2 = new ListNode(20);
		ListNode a3 = new ListNode(30);
		ListNode a4 = new ListNode(40);
		ListNode a5 = new ListNode(50);
		ListNode a6 = new ListNode(60);
		
		ListNode a7 = new ListNode(1);
		ListNode a8 = new ListNode(25);
		ListNode a9 = new ListNode(35);
		ListNode a10 = new ListNode(65);
		
		
		ListNode a11 = new ListNode(1);
		ListNode a12 = new ListNode(2);
		ListNode a13 = new ListNode(3);
		ListNode a14 = new ListNode(4);
		ListNode a15 = new ListNode(5);
		ListNode a16 = new ListNode(6);
		ListNode a17 = new ListNode(7);
		ListNode a18 = new ListNode(8);
		
		ListNode a19 = new ListNode(5);
		ListNode a20 = new ListNode(4);
		ListNode a21 = new ListNode(6);
		ListNode a22 = new ListNode(3);
		ListNode a23 = new ListNode(5);
		
		
		l1.insertAtEnd(a1);
		l1.insertAtEnd(a2);
		l1.insertAtEnd(a3);
		l1.insertAtEnd(a4);
		l1.insertAtEnd(a5);
		l1.insertAtEnd(a6);
		
		l2.insertAtEnd(a7);
		l2.insertAtEnd(a8);
		l2.insertAtEnd(a9);
		l2.insertAtEnd(a10);
		
		l4.insertAtEnd(a11);
		l4.insertAtEnd(a12);
		l4.insertAtEnd(a13);
		l4.insertAtEnd(a14);
		l4.insertAtEnd(a15);
		l4.insertAtEnd(a16);
		l4.insertAtEnd(a17);
		l4.insertAtEnd(a18);
		
		
		
		l5.insertAtEnd(a19);
		l5.insertAtEnd(a20);
		l5.insertAtEnd(a21);
		l5.insertAtEnd(a22);
		l5.insertAtEnd(a23);
	
		
		
	
	
		ListNode h1 = l1.head;
		ListNode h2 = l2.head;
		ListNode h4 = l4.head;
		ListNode h5 = l5.head;
		
		
		
		ListNode h3 = m.mergeTwoLists(h1, h2);
		
		
		
		System.out.println("\nMerged list using Recursion\n");
		m.display(h3);
		
		
		System.out.println("\ndisplaying list 4");
		m.display(h4);
		System.out.println("\ndisplaying list 5");
		m.display(h5);
		
		
		m.addTwoNumbers(h4, h5);
		
		ListNode h6 = m.oddEvenLinkedList(h4);
		System.out.println("\ndisplaying OddEven List");
		m.display(h6);
		
/*		ListNode h4 = m.reverseinPairs(h1);
		ListNode h5 = m.reversePairsRecursive(h1);

		System.out.println("\nReversed list\n");
		while(h4!=null) {
			System.out.print(h4.data + "->");
			h4 = h4.next;
		}
		
		System.out.println("\n\nReversed list using recursion\n");
		while(h5!=null) {
			System.out.print(h5.data + "->");
			h5 = h5.next;
		}
		
		ListNode h6 = m.exchangeNodesAdjacent(h1);
		System.out.println("\n\nReversed adjacent nodes in list\n");
		while(h6!=null) {
			System.out.print(h6.data + "->");
			h6 = h6.next;
		}
		
		System.out.println("\n\nReversed adjacent nodes in list\n");
		while(h6!=null) {
			System.out.print(h6.data + "->");
			h6 = h6.next;
		}*/
		
		System.out.println("\ndisplaying list 5");
		m.display(h5);
	
		System.out.println(m.isPalindrome(h5));
		
		
	}
	
	public ListNode oddEvenLinkedList(ListNode head) {
		System.out.println("In oddEven LinkedList");
		display(head);
		//ListNode temp = head.next;
		ListNode x = head;
		ListNode temp = head.next;
		System.out.println("temp.data" + temp.data);
		ListNode y = temp;
		while(x.next!=null && x.next.next!=null) {
			x.next =x.next.next;
			x = x.next;
		}
		while(y.next != null && y.next.next!=null) {
			y.next =y.next.next;
			y = y.next;
		}
		y.next = null;
		System.out.println("temp.data" + temp.data);
		x.next = temp;
	
		System.out.println("REsult display");
		display(head);
		return head;
		
	}
	
	public void addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        Stack<Integer> s3 = new Stack();
        ListNode r = null;
        int carry = 0;
        
    
        while(l1!=null) {
            s1.push(l1.data);
            l1 = l1.next;
        }
        while(l2!=null) {
            s2.push(l2.data);
            l2 = l2.next;
        }
        System.out.println(s1+","+s2);
        while(!s1.empty() && !s2.empty()) {
            int a = s1.pop();
            int b = s2.pop();
            int result;
           
            
            result = a+b;
            result+=carry;
            
            if(result/10 == 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            s3.push(result%10);

        }
        if(!s1.empty()) {

            while(!s1.empty()) {
                int x = s1.pop() + carry;
                if(x/10==1) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                s3.push(x%10);
            }
        }
        
        if(!s2.empty()) {
            while(!s2.empty()) {
                int x = s2.pop() + carry;
                if(x/10==1) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                s3.push(x%10);
            }
        }
      
      //return null;  
        
        while(!s3.empty()) {
        	int x = s3.pop();
        	ListNode p = new ListNode(x);
        	ListNode t = r;
        	if(r == null) {		
        		r = p;
        		r.next = null;
        	} else {
        		while(t.next!=null) {
        			t = t.next;
        		}
        		t.next = p;
        		t.next.next = null;
        	}
        }
        System.out.println("Printing result list");
        display(r);
		
		
	}
	
	
public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
      //  slow = slow.next;
        
        ListNode x = reverse(slow.next);
        
        
        
        while(fast!=slow && x!=null) {
            if(fast.data != slow.data) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true; 
        
    }
    
    
    public ListNode reverse(ListNode h) {
       
      ListNode temp = h;
      ListNode p = null;
      
        
        while(temp!=null) {
            ListNode x = temp;
            ListNode y = p;
            temp = temp.next;
            p = x;
            p.next = y;
            
        }
        return p;
        
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
	

	public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
		
		if(h1==null) {
			return h2;
		} if(h2 == null) {
			return h1;
		}
		ListNode head = new ListNode(0);
		if(h1.data<=h2.data) {
			head = h1;
			head.next = mergeTwoLists(h1.next, h2);
		} else {
			head = h2;
			head.next = mergeTwoLists(h2.next, h1);
		}
		return head;
	}
	
	
	public ListNode reverseinPairs(ListNode head) {
		
		ListNode temp1 = null;
		ListNode temp2 = null;
		
		while(head != null && head.next != null) {
			if(temp1 != null) {
				temp1.next.next = head.next;
			}
			temp1 = head.next;
			head.next = head.next.next;
			temp1.next = head;
			if(temp2 == null) {
				temp2 = temp1;
			}
			head = head.next;
			
			
		}
		
		return temp2;
		
		
	}
	
	public ListNode reversePairsRecursive(ListNode head) {
		
		ListNode p = head;
		if(head == null || head.next == null) {
			return null;
		} else {
			p = head.next;
			head.next = p.next;
			p.next = head;
			head = p;
			head.next.next = reversePairsRecursive(head.next.next);
			return p;
		}
	}
	
	
	public ListNode exchangeNodesAdjacent(ListNode head) {
		ListNode curr = head;
		ListNode temp = new ListNode(0);
		ListNode prev = temp;
		temp.next = head;
		while(curr!=null && curr.next!=null) {
			temp = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = temp;
			prev = curr;
			curr = prev.next;
		}
		return temp.next;
		
	}
	
}
