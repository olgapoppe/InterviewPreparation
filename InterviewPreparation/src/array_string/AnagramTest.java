package array_string;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void testareAnagramms() {
		
		// equal strings -> true
		String a = "winter";
		String b = "winter";
		assertTrue(Anagram.areAnagrams(a,b));
				
		// non-equal strings -> false
		String c = "summer";
		String d = "winter";
		assertFalse(Anagram.areAnagrams(c,d));
				
		// almost equal strings -> false
		String e = "summer";
		String f = "summmer";
		assertFalse(Anagram.areAnagrams(e,f));
				
		// anagrams -> true
		String g ="william shakespeare";
		String h = "i am a weakish speller";
		assertTrue(Anagram.areAnagrams(g,h));
				
		// empty strings -> true
		String i ="";
		String j = "";
		assertTrue(Anagram.areAnagrams(i,j));
				
		// empty strings -> true
		String k ="";
		String l = " ";
		assertTrue(Anagram.areAnagrams(k,l));		
	}
}
