package linked_list;

public class LinkedListNode {
	
	int data;
	LinkedListNode next;
	
	public LinkedListNode (int d, LinkedListNode n) {
		this.data = d;
		this.next = n;
	}
	
	public boolean deleteNode () {
		if (this == null || this.next == null) {
			return false;
		}
		this.data = this.next.data;
		this.next = this.next.next;
		return true;
	}
	
	/**
	 * Get the first node in a loop
	 */
	public LinkedListNode getStartOfLoop () {
		LinkedListNode n1 = this;
		LinkedListNode n2 = this;
		
		// find meeting point
		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				break;
		}}
		// no meeting point, no loop
		if (n2.next == null) {
			return null;
		}
		// move n1 to head and move n1 and n2 at same pace, they'll meet at the start of a loop
		n1 = this;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}
	
	public String toString() {
		return "" + this.data;
	}
}