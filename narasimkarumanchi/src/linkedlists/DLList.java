package linkedlists;

public class DLList {
	
	public DLLNode head;
	public DLLNode tail;
	public int length;
	
	public DLList() {
		head = new DLLNode(Integer.MIN_VALUE, null, null);
		tail = new DLLNode(Integer.MIN_VALUE, head, null);
		head.setNext(tail);
		length=0;
	}
	
	public int get(int position) {
		return Integer.MIN_VALUE;
	}
	
	public int getPosition(int data) {
		int position = 0;
		DLLNode x = head;
		while(x.next!=null && x.data!=data) {
			x=x.next;
			position++;
		}
		if(x.data == data) {
			return position;
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	public int length() {
		return length;
	}
	
	public void insert(int newValue) {
		DLLNode node = new DLLNode(newValue);
		node.next = head.prev;
		head=node;
	}
	
	public void insert(int data, int position) {
		DLLNode node = new DLLNode(data);
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=length;
		}
		if(head==null) {
			head=node;
			tail=node;
		}
		
		if(position==0) {
			node.next = head;
			head = node;
		}
		
		DLLNode x = head;
		for(int i=0;i<position;i++) {
			x=x.next;
		}
		
		node.next=x.next;
		x.next=node;
		node.prev = x;
		node.next.prev=node;
	}
	
	
	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue, tail.getPrev(), tail);
		newNode.prev = newNode;
		tail.setPrev(newNode);
		length+=1;
		
	}
	
	
	
	public void remove(int position) {
		if(position<0) {
			position = 0;
		}
		if(position>length) {
			position=length;
		}
		if(head==null) {
			return;
		}
		if(position == 0) {
			head = head.next;
			if(head==null) {
				tail= null;
			}
		} else {
			DLLNode temp = head;
			for(int i=0;i<position;i++) {
				temp=temp.next;
			}
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			length-=1;
		}
	}

}
