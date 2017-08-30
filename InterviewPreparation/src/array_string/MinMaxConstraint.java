package array_string;

public class MinMaxConstraint {
	
	public static void main (String [] args) {
		int [] input = new int [4];
		input[0] = 1;
		input[1] = 2;
		input[2] = 3;
		input[3] = 4;
		
		int result = getNumberOfSubsequences (input,6);
		System.out.println(result);
	}
	
	public static int getNumberOfSubsequences (int [] input, int k) {
		int result = 0;
		
		for (int i=0; i<input.length-1; i++) {
			for (int j=1; j<input.length; j++) {
				if (i<j) {
					if (input[i]+input[j]<k) {
						result++;
					}
				}				
			}
		}		
		return result;
	}
}
