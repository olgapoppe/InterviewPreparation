package array_string;

public class Anagram {
	
	/**
	 * Return true if two strings are anagrams. Return false otherwise.
	 * @param s1	first string
	 * @param s2	second string
	 * @return		boolean
	 */	
	public static boolean areAnagrams(String s1, String s2) {
		
		// prepare the buffers
		int[] buffer1 = new int[26];
		int[] buffer2 = new int[26];
		for(int i=0; i<26; i++) {
			buffer1[i] = 0;
			buffer2[i] = 0;
		} 
		// fill the buffers with context (i.e., number of occurrences of a letter)
		for(int i=0; i<s1.length(); i++) {		
			
			int m = s1.codePointAt(i) - "a".codePointAt(0);
			if (m >= 0) { buffer1[m] = buffer1[m]+1; } 
		}		
		for(int i=0; i<s2.length(); i++) {
				
			int n = s2.codePointAt(i) - "a".codePointAt(0);
			if (n >= 0) { buffer2[n] = buffer2[n]+1; }
		}
		// compare the numbers of occurrences of each letter in both buffers
		for(int i=0; i<26; i++) {
			
			if (buffer1[i] != buffer2[i]) { return false; }
		}		
		return true;
	}
	// Complexity is exactly s1.length + s2.length + 26
}