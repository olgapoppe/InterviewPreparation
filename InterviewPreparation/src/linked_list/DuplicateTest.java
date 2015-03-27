package linked_list;

import junit.framework.Assert;
import java.util.LinkedList;
import org.junit.Test;

public class DuplicateTest {

	@Test
	public void testremoveDuplicates() {
		
		// no duplicates
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Assert.assertEquals(list,Duplicate.removeDuplicates1(list));
		Assert.assertEquals(list,Duplicate.removeDuplicates2(list));
		
		// some duplicates
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(1);
		list1.add(1);
		list1.add(5);
		LinkedList<Integer> list11 = new LinkedList<Integer>();
		list11.add(1);
		list11.add(2);
		list11.add(5);
		Assert.assertEquals(list11,Duplicate.removeDuplicates1(list1));
		Assert.assertEquals(list11,Duplicate.removeDuplicates2(list1));
		
		// only duplicates
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		LinkedList<Integer> list22 = new LinkedList<Integer>();
		list22.add(1);
		Assert.assertEquals(list22,Duplicate.removeDuplicates1(list2));
		Assert.assertEquals(list22,Duplicate.removeDuplicates2(list2));
	}

}
