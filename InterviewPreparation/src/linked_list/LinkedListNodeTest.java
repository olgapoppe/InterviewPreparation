package linked_list;

import junit.framework.Assert;
import org.junit.Test;

public class LinkedListNodeTest {

	@Test
	public void test() {
		// no loop
		LinkedListNode n5 = new LinkedListNode(5,null);
		LinkedListNode n4 = new LinkedListNode(4,n5);
		LinkedListNode n3 = new LinkedListNode(3,n4);
		LinkedListNode n2 = new LinkedListNode(2,n3);
		LinkedListNode n1 = new LinkedListNode(1,n2);		
		Assert.assertEquals(null, n1.getStartOfLoop());
				
		// loop
		LinkedListNode n15 = new LinkedListNode(2,null);
		LinkedListNode n14 = new LinkedListNode(4,n15);
		LinkedListNode n13 = new LinkedListNode(3,n14);
		LinkedListNode n12 = new LinkedListNode(2,n13);
		LinkedListNode n11 = new LinkedListNode(1,n12);		
		n15.next = n12;
		Assert.assertEquals(n12, n11.getStartOfLoop());		
	}
}
