package array_string;

public class RectangleSearch {
	
	public static void main (String [] args) {
		
		int [][] matrix = new int [3][3];
		matrix[0][0] = 0;
		matrix[0][1] = 0;
		matrix[0][2] = 0;
		matrix[1][0] = 0;
		matrix[1][1] = 1;
		matrix[1][2] = 1;
		matrix[2][0] = 0;
		matrix[2][1] = 0;
		matrix[2][2] = 0;
		
		String result = findRectangle(matrix,3,3);
		System.out.println(result);
	}
	
	public static String findRectangle (int[][] matrix, int length, int height) {
		
		String result = "";
		int x = 0;
		int y =0;
		
		for (int h=0; h<length; h++) {
			for (int v=0; v<height; v++) {
				if (matrix[h][v] == 1) {
					x = v;
					while (matrix[h][v] == 1) {
						y = h;
						h++;
					}
					result = "(" + x + "," + y + ")";
					break;
				}
			}
			if (result.length() > 0) 
				break;
		}		
		return result;		
	}

}
