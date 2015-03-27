package linked_list;

public class LinkedListNode {
	
	int data;
	LinkedListNode next;
	
	public LinkedListNode (int d, LinkedListNode n) {
		this.data = d;
		this.next = n;
	}
	
	/**
	 * Delete a node in the middle of a single linked list given only access to that node
	 * @return	boolean indicating whether the node was deleted
	 */
	public boolean deleteNode (LinkedListNode n) {
		if (n==null || n.next == null) {
			return false;
		}
		n.data = n.next.data;
		n.next = n.next.next;				
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
	
	public boolean equals (LinkedListNode other) {
		return this.data==other.data && this.next.equals(other.next);
	}
	
	public String toString() {
		return "" + this.data;
	}
}