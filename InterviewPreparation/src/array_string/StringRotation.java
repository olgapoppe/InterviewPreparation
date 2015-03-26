package array_string;

public class StringRotation {
	
	/**
	 * Swap the characters at positions start and end
	 * @param s		input string
	 * @param start	start index
	 * @param end	end index
	 */	
	static void reverse (String[] s, int start, int end) {
	    String t;    
	    while(start<end) {
	        t = s[start];
	        s[start] = s[end];
	        s[end] = t;
	        start++;
	        end--;
	    }        
	}
	
	/**
	 * Left rotate n characters of a string in-place and in linear time
	 * @param s	input string
	 * @param n	number of characters to rotate
	 */
	static void leftRotate1 (String[] s, int n){
		n--; // index begins with 0 
		if(n==s.length) return;	 
	    reverse(s,0,n);
	    reverse(s,n+1,s.length-1);
	    reverse(s,0,s.length-1);
	}
	
	/**
	 * Compute greatest common divisor of 2 numbers 
	 * @param a first number
	 * @param b second number
	 * @return	greatest common divisor
	 */
	static int gcd(int a, int b) {
		return (b==0) ? a : gcd(b, a%b);
	}
	
	/**
	 * Left rotate n characters of a string in-place and in linear time
	 * @param arr						input string
	 * @param numberOfElements2Rotate	number of characters to rotate
	 * @param length					length of the string
	 */
	static void leftRotate2 (String arr[], int numberOfElements2Rotate, int length) {
	  
	  for (int i = 0; i < gcd(numberOfElements2Rotate, length); i++) {
	    String temp = arr[i];
	    int position = i;
	    while(true) {
	      int element = position + numberOfElements2Rotate; 
	      if (element >= length) element = element - length; 
	      if (element == i) break;
	      arr[position] = arr[element];
	      position = element;
	      //print(arr);	      
	    }
	    arr[position] = temp;	    
	  }
	}
	
	/** Determine whether one string is a rotation of another 
	 * @param s1	first string
	 * @param s2	second string
	 * @return		boolean
	 */
	public static boolean isRotation (String s1, String s2) {
		// Base cases
		if (s1.length() != s2.length()) return false;
		if (s1 == s2) return true;
		// Recursive case
		for(int i=s2.length()-1; i>0; i--) {
			String head = s2.substring(0, i);
			String tail = s2.substring(i, s2.length());
			String tail_head = tail.concat(head);			
			if (s1.matches(tail_head)) return true;
		}
		return false;
	}
	// Complexity is at most s2.length-1
	
	/**
	 * Print the input array of strings
	 * @param input
	 */
	static void print(String[] input) {
		String result = "";
		for (String s : input) {
			result += s.toString() + " ";
		}
		System.out.println(result);
	}
}
