package array_string;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class UniquePrefixTest {

	@Test
	public void testgetUniquePrefixes() {
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("zebra");
		input.add("dog");
		input.add("duck");
		input.add("dove");
		
		ArrayList<StringWithPrefix> results = new ArrayList<StringWithPrefix>();
		results.add(new StringWithPrefix("z","zebra"));
		results.add(new StringWithPrefix("dog","dog"));
		results.add(new StringWithPrefix("du","duck"));
		results.add(new StringWithPrefix("dov","dove"));
		
		Assert.assertEquals(results, UniquePrefix.getUniquePrefixes(input));
	}
}
