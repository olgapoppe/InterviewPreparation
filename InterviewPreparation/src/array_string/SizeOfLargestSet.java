package array_string;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SizeOfLargestSet {

	public static void main (String[] arg) {
		
		int[] input = new int[7];
		input[0]=5;
		input[1]=4;
		input[2]=0;
		input[3]=3;
		input[4]=1;
		input[5]=6;
		input[6]=2;
		
		int result = getSizeOfLargestSet(input);
		System.out.println(result);
	}
	
	public static int getSizeOfLargestSet (int[] input) {
		
		int max = 0;
			
		for (int i=0; i<Array.getLength(input); i++) {
			
			ArrayList<Integer> set = new ArrayList<Integer>();
			int v = input[i];
			while (!set.contains(v)) {
				set.add(v);
				v = input[v];
			}
			if (max<set.size()) 
				max=set.size();
			System.out.println(i + " " + set.toString());
		}	
		return max;		
	}
	
}
