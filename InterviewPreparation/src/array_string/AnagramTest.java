package array_string;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

	@Test
	public void testareAnagramms() {
		
		// equal strings -> true
		String a = "winter";
		String b = "winter";
		Assert.assertTrue(Anagram.areAnagrams(a,b));
				
		// non-equal strings -> false
		String c = "summer";
		String d = "winter";
		Assert.assertFalse(Anagram.areAnagrams(c,d));
				
		// almost equal strings -> false
		String e = "summer";
		String f = "summmer";
		Assert.assertFalse(Anagram.areAnagrams(e,f));
				
		// anagrams -> true
		String g ="william shakespeare";
		String h = "i am a weakish speller";
		Assert.assertTrue(Anagram.areAnagrams(g,h));
				
		// empty strings -> true
		String i ="";
		String j = "";
		Assert.assertTrue(Anagram.areAnagrams(i,j));
				
		// empty strings -> true
		String k ="";
		String l = " ";
		Assert.assertTrue(Anagram.areAnagrams(k,l));		
	}
}
