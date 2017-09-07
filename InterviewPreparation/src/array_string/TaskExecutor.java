package array_string;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Set;

public class TaskExecutor {
	
	public static void main (String [] args) {
		
		int [] input = new int [5];
		input[0] = 1;
		input[1] = 1;
		input[2] = 2;
		input[3] = 1;
		input[4] = 2;
		
		int result = getNumberOfTimeSlots(input,2);
		System.out.println(result);
	}
	
	public static int getNumberOfTimeSlots (int [] input, int cooldown) {
		
		int result = 0;
		HashMap<Integer,Integer> distances = new HashMap<Integer,Integer>();
		
		for (int i=0; i<Array.getLength(input); i++) {
			int currNum = input[i];
			int distance = (distances.containsKey(currNum)) ? distances.get(currNum) : cooldown;
			int timeSlots = (i>0 && cooldown>distance) ? (1+(cooldown-distance)) : 1;
			result += timeSlots;
			
			distances.put(currNum, 0);
			Set<Integer> keys = distances.keySet();
			for (int key : keys) {
				if (key != currNum) {
					int dist = distances.get(key);
					distances.put(key, dist+timeSlots);	
				} 
			}			
		}
		
		return result;
	}

}
