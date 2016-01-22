package array_string;

import java.util.ArrayList;

// The look-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211,

public class LookAndSaySequence {
	
	public static ArrayList<String> getLookAndSaySequence (String current_number, int n) {
		
		ArrayList<String> results = new ArrayList<String>();
		
		for (int i=1; i<=n; i++) {		
			
			results.add(current_number);
			
			int cursor = 1;
			char c = current_number.charAt(0);
			int count = 1;	
			String accumulator = "";
						
			while (cursor<current_number.length()) {				
				
				if (c == current_number.charAt(cursor)) {					
					count++;
				} else {
					accumulator += count + "" + c;
					c = current_number.charAt(cursor);
					count=1;
				}				
				cursor++;
			}
			current_number = accumulator + count + c;			
		}
		return results;
	}	
}
