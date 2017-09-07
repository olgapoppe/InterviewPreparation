package array_string;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*Extensions:
 * - more operators
 * - duplicate numbers
 * - numbers in any order 
 * */ 


public class EvaluateToTargetNumber {
	
	public static void main (String [] args) {
		int [] nums = new int[3];
		nums[0] = 5;
		nums[1] = 3;
		nums[2] = 8;
		
		boolean result = getTarget(nums, 16);		
		System.out.println(result);
	}
	
	public static boolean getTarget(int[] nums, int target) {
		
		ArrayList<Integer> prevLevel = new ArrayList<Integer>();
		ArrayList<Integer> currLevel = new ArrayList<Integer>();
		prevLevel.add(nums[0]);
		
		for (int level=1; level<Array.getLength(nums); level++) {
			int curr = nums[level];
			for (int prev : prevLevel) {
				currLevel.add(prev + curr);
				currLevel.add(prev - curr);
			}
			prevLevel.clear();	
			prevLevel.addAll(currLevel);
			currLevel.clear();	
			//System.out.println(prevLevel.toString());
		}
		for (int prev : prevLevel) {
			if (prev == target) {
				return true;
			}			
		}			
		return false;		
	} 
}
