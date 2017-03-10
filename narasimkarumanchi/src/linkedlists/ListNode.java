package linkedlists;

public class ListNode {

	protected int data;
	public ListNode next;
	
	public ListNode(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode getNext() {
		return this.next;
	}
}
