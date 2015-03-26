package array_string;

import org.junit.Assert;
import org.junit.Test;

public class DuplicateTest {

	@Test
	public void testareAllCharsUnique() {
		
		// all equal -> false
		String s1 = "llllllllllllll";
		Assert.assertFalse(Duplicate.areAllCharsUnique(s1));
				
		// all different -> true
		String s2 = "anthskg";
		Assert.assertTrue(Duplicate.areAllCharsUnique(s2));		
			
		// one duplicate -> false
		String s3 = "buopthbf";
		Assert.assertFalse(Duplicate.areAllCharsUnique(s3));		
				
		// empty string -> true
		String s4 = "";
		Assert.assertTrue(Duplicate.areAllCharsUnique(s4));	
				
		// several duplicates -> false
		String s5 = "anna";
		Assert.assertFalse(Duplicate.areAllCharsUnique(s5));		
	}
	
	@Test
	public void testreplaceDuplicates() {
		
		// all equal -> "l     "
		char[] a = { 'l', 'l', 'l', 'l', 'l', 'l' };
		char[] aa = { 'l', '\0', '\0', '\0', '\0', '\0' };
		Assert.assertArrayEquals(aa,Duplicate.replaceDuplicates(a));
							
		// all different -> "anthskg"
		char[] b = { 'a', 'n', 't', 'h', 's', 'k', 'g' };
		Assert.assertArrayEquals(b,Duplicate.replaceDuplicates(b));
							
		// one duplicate -> "buop thf"
		char[] c = { 'b', 'u', 'o', 'p', 'o', 't', 'h', 'f' };
		char[] cc = { 'b', 'u', 'o', 'p', '\0', 't', 'h', 'f' };
		Assert.assertArrayEquals(cc,Duplicate.replaceDuplicates(c));
							
		// empty string -> ""
		char[] d = { '\0' };
		Assert.assertArrayEquals(d,Duplicate.replaceDuplicates(d));
							
		// several duplicates -> "an  "
		char[] e = { 'a', 'n', 'n', 'a' };
		char[] ee = { 'a', 'n', '\0', '\0' };
		Assert.assertArrayEquals(ee,Duplicate.replaceDuplicates(e));
	}
					
	@Test
	public void testremoveDuplicates() {		
			
		// all equal -> "l"
		char[] a = { 'l', 'l', 'l', 'l', 'l', 'l' };
		char[] aa = { 'l', '\0', '\0', '\0', '\0', '\0' };
		Assert.assertArrayEquals(aa,Duplicate.removeDuplicates(a));
					
		// all different -> "anthskg"
		char[] b = { 'a', 'n', 't', 'h', 's', 'k', 'g' };
		Assert.assertArrayEquals(b,Duplicate.removeDuplicates(b));
									
		// one duplicate -> "buop thf"
		char[] c = { 'b', 'u', 'o', 'p', 'o', 't', 'h', 'f' };
		char[] cc = { 'b', 'u', 'o', 'p', 't', 'h', 'f', '\0' };
		Assert.assertArrayEquals(cc,Duplicate.removeDuplicates(c));
									
		// empty string -> ""
		char[] d = { '\0' };
		Assert.assertArrayEquals(d,Duplicate.removeDuplicates(d));
									
		// several duplicates -> "an  "
		char[] e = { 'a', 'n', 'n', 'a' };
		char[] ee = { 'a', 'n', '\0', '\0' };
		Assert.assertArrayEquals(ee,Duplicate.removeDuplicates(e));
	}
}
