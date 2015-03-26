package array_string;

public class Matrix {
	
	/** 
	 * Rotate an NxN matrix by 90 degrees in place
	 * @param matrix matrix to rotate
	 * @param min	minimum index
	 * @param max	maximum index
	 * @return 		rotated matrix
	 */	
	public static char[][] rotate(char[][] matrix, int min, int max) {
		
		if (max-min==1) {
			
			char[] top = new char[max+1];
			for (int i=min; i<=max; i++) { top[i] = matrix[min][i]; }
						
			// bottom -> left
			for (int i=min; i<=max; i++) { matrix[i][min] = matrix[max][i]; }
			
			// top -> right
			for (int i=min; i<=max; i++) { matrix[i][max] = top[i]; }
		
		} else { 
		if (max-min>1) {
			
				/*** 1) rotate outer layer ***/
				
				char[] top = new char[max+1];
				for (int i=min; i<=max; i++) { top[i] = matrix[min][i]; }
								
				// left -> top	
				int j=min;
				for (int i=max; i>=min; i--) { matrix[min][j] = matrix[i][min]; j++; }
								
				// bottom -> left
				for (int i=min; i<=max; i++) { matrix[i][min] = matrix[max][i]; }
								
				// right -> bottom
				int k=min;
				for (int i=max; i>=min; i--) { matrix[max][k] = matrix[i][max]; k++; }	
								
				// top -> right
				for (int i=min; i<=max; i++) { matrix[i][max] = top[i]; }	
						
				/*** 2) rotate inner layer ***/
			
				matrix = rotate(matrix, min+1, max-1);
		}}		
		return matrix;
	}
	// Complexity is exactly max^3
	
	/** If an element of an MxN matrix is 0, set all elements in its entire row and column to 0	 * 
	 * @param matrix	input matrix
	 * @param m			number of rows
	 * @param n			number of columns
	 * @return			modified matrix
	 */
	public static int[][] setToNull (int[][] matrix, int m, int n) {
		
		int[] rows = new int[m];
		for(int i=0; i<m; i++) {
			rows[i] = 0;
		}
		
		int[] columns = new int[n];
		for(int j=0; j<n; j++) {
			columns[j] = 0;
		}		
		
		// find out the elements of which rows and columns must be set to 0
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
		}}}
		
		for(int i=0; i<m; i++) {
			if (rows[i] == 1) {
				for(int k=0; k<n; k++) {
					matrix[i][k] = 0;
		}}}
		
		for(int j=0; j<n; j++) {
			if (columns[j] == 1) {
				for(int k=0; k<m; k++) {
					matrix[k][j] = 0;
		}}}
		
		return matrix;		
	}
	// Complexity is at most (mn)^3
	
	/**
	 * Print the given matrix
	 * @param matrix	matrix to print
	 * @param size		maximum index
	 */
	public static void print (char[][] matrix, int size) {
		
		for (int i=0; i<=size; i++) {
			for (int j=0; j<=size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}	
		System.out.print("\n");
	}
}
