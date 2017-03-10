package linkedlists;

public class DLLNode {
	public int data;
	public DLLNode prev;
	public DLLNode next;
	
	public DLLNode(int data) {
		this.data = data;
		prev = null;
		next = null;
	}
	
	public DLLNode(int data,DLLNode prev, DLLNode next) {
		this.data=data;
		this.prev=prev;
		this.next=next;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setData(int data) {
		this.data=data;
	}
	
	public void setPrev(DLLNode prev) {
		this.prev=prev;
	}
	
	public void setNext(DLLNode next) {
		this.next=next;
	}
	
	public DLLNode getPrev() {
		return this.prev;
	}
	
	public DLLNode getNext() {
		return this.next;
	}
}

