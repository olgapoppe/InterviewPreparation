package array_string;

import java.lang.reflect.Array;

public class EvaluateToTargetNumber {
	
	public boolean getTarget(int[] nums, int target) {
		
		// + 1, - 2, * 3, / 4

		int prev = nums[0];
		for (int level=1; level<Array.getLength(nums); level++) {
			int curr = nums[level];
			for (int op=1; op<5; op++) {
				
			}
		}
		
		
		return false;		
	} 

}
