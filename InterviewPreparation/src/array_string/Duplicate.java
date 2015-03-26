package array_string;

public class Duplicate {
	
	/**
	 * Return true is the input string has all unique characters. Return false otherwise.
	 * @param s string
	 * @return	boolean
	 */
	public static boolean areAllCharsUnique(String s) {
		
		// assuming that s contains lower case letters only
		// create an array that remembers the chars that appear in the input
		// initially the array is filled with zeros
		int[] buffer = new int[26];
		for(int i=0; i<26; i++) {
			buffer[i] = 0;
		}
		// Complexity 26
		
		for(int i=0; i<s.length(); i++) {
			
			// get the position of this character in the array
			int j = s.codePointAt(i) - "a".codePointAt(0);
			
			// this position in the array is updated to 1 for every new character
			if (buffer[j] == 0) {
				buffer[j] = 1;
			// if the character already appeared in the input before return false
			} else {
				return false;
			}
		}
		return true;
		// Complexity s.length
	}
	// Complexity is exactly 26 + s.length
	
	/**
	 * Replace duplicates by 0.	
	 * @param s	Array of chars without 0
	 * @return	Array of chars where duplicates are replaced by 0s
	 */
	public static char[] replaceDuplicates(char[] s) {		
					
		for(int i=0; i<s.length; i++) {
			
			if (s[i] != 0) {
				
				for(int j=i+1; j<s.length; j++) {
				
					if (s[i] == s[j]) s[j] = 0;
		}}}
		return s;
	}
	// Complexity is exactly s.length^2
		
	/**
	 * Remove duplicate characters in an array without additional buffer	
	 * @param s	Array of chars with duplicates 
	 * @return	Array of chars without duplicates
	 */
	public static char[] removeDuplicates(char[] s) {	
								
		for(int i=0; i<s.length; i++) {
				
			for(int j=i+1; j<s.length; j++) {
				
				int k=j; // initial position of a duplicate to skip
				int l=j; // initial position to which characters are copied 
				int count=0; // counts the number of skipped characters
				int n=s.length-1; // remembers the last position in array to insert count-many zeros
					
				// skip several adjacent duplicates
				while(s[i]!=0 && k<s.length && s[i]==s[k]) { 
					k++; 
					count++;
				}	
				// copy other characters to the positions of skipped characters
				while(k<s.length) {						
					s[l] = s[k];
					l++;
					k++;
				}	
				// replace count-many characters at the end by empty spaces
				while(count>0) {					
					s[n] = 0;
					n--;
					count--;
				}			
			}			
		}
		return s;
	}
	// Complexity is at most s.length^3	
}
