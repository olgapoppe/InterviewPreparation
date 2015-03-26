package array_string;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class LookAndSaySequenceTest {

	@Test
	public void testgetLookAndSaySequence() {
		
		ArrayList<String> results = new ArrayList<String>();
		results.add("1");
		results.add("11");
		results.add("21");
		results.add("1211");
		results.add("111221");
		Assert.assertEquals(results, LookAndSaySequence.getLookAndSaySequence("1",5));
	}
}
