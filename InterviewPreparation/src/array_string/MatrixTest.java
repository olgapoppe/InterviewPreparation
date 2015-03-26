package array_string;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

	@Test
	public void testrotate() {
		
		char[][] matrix1 = new char[1][1];
		matrix1[0][0] = 'a';
		char[][] matrix11 = new char[1][1];
		matrix11[0][0] = 'a';
		Assert.assertArrayEquals(matrix11,Matrix.rotate(matrix1, 0, 0));
						
		char[][] matrix2 = new char[2][2];
		matrix2[0][0] = 'a';
		matrix2[0][1] = 'b';				
		matrix2[1][0] = 'c';
		matrix2[1][1] = 'd';	
		char[][] matrix22 = new char[2][2];
		matrix22[0][0] = 'c';
		matrix22[0][1] = 'a';				
		matrix22[1][0] = 'd';
		matrix22[1][1] = 'b';	
		Assert.assertArrayEquals(matrix22,Matrix.rotate(matrix2, 0, 1));
				
		char[][] matrix3 = new char[3][3];
		matrix3[0][0] = 'a';
		matrix3[0][1] = 'b';
		matrix3[0][2] = 'c';		
		matrix3[1][0] = 'd';
		matrix3[1][1] = 'e';
		matrix3[1][2] = 'f';		
		matrix3[2][0] = 'g';
		matrix3[2][1] = 'h';
		matrix3[2][2] = 'i';		
		char[][] matrix33 = new char[3][3];
		matrix33[0][0] = 'g';
		matrix33[0][1] = 'd';
		matrix33[0][2] = 'a';		
		matrix33[1][0] = 'h';
		matrix33[1][1] = 'e';
		matrix33[1][2] = 'b';		
		matrix33[2][0] = 'i';
		matrix33[2][1] = 'f';
		matrix33[2][2] = 'c';		
		Assert.assertArrayEquals(matrix33,Matrix.rotate(matrix3, 0, 2));
		
		char[][] matrix4 = new char[4][4];
		matrix4[0][0] = 'a';
		matrix4[0][1] = 'b';
		matrix4[0][2] = 'c';
		matrix4[0][3] = 'd';		
		matrix4[1][0] = 'e';
		matrix4[1][1] = 'f';
		matrix4[1][2] = 'g';
		matrix4[1][3] = 'h';		
		matrix4[2][0] = 'i';
		matrix4[2][1] = 'j';
		matrix4[2][2] = 'k';
		matrix4[2][3] = 'l';		
		matrix4[3][0] = 'm';
		matrix4[3][1] = 'n';
		matrix4[3][2] = 'o';
		matrix4[3][3] = 'p';		
		char[][] matrix44 = new char[4][4];
		matrix44[0][0] = 'm';
		matrix44[0][1] = 'i';
		matrix44[0][2] = 'e';
		matrix44[0][3] = 'a';		
		matrix44[1][0] = 'n';
		matrix44[1][1] = 'j';
		matrix44[1][2] = 'f';
		matrix44[1][3] = 'b';		
		matrix44[2][0] = 'o';
		matrix44[2][1] = 'k';
		matrix44[2][2] = 'g';
		matrix44[2][3] = 'c';		
		matrix44[3][0] = 'p';
		matrix44[3][1] = 'l';
		matrix44[3][2] = 'h';
		matrix44[3][3] = 'd';		
		Assert.assertArrayEquals(matrix44,Matrix.rotate(matrix4, 0, 3));	
	}
	
	@Test
	public void testsetToNull() {
	
		int[][] matrix1 = new int[1][1];
		matrix1[0][0] = 1;
		int[][] matrix11 = new int[1][1];
		matrix11[0][0] = 1;		
		Assert.assertArrayEquals(matrix11,Matrix.setToNull(matrix1, 1, 1));	
	
		int[][] matrix2 = new int[2][2];
		matrix2[0][0] = 1;
		matrix2[0][1] = 0;			
		matrix2[1][0] = 2;
		matrix2[1][1] = 3;	
		int[][] matrix22 = new int[2][2];
		matrix22[0][0] = 0;
		matrix22[0][1] = 0;			
		matrix22[1][0] = 2;
		matrix22[1][1] = 0;
		Assert.assertArrayEquals(matrix22,Matrix.setToNull(matrix2, 2, 2));
	
		int[][] matrix3 = new int[3][3];
		matrix3[0][0] = 1;
		matrix3[0][1] = 2;
		matrix3[0][2] = 3;	
		matrix3[1][0] = 4;
		matrix3[1][1] = 0;
		matrix3[1][2] = 5;		
		matrix3[2][0] = 6;
		matrix3[2][1] = 0;
		matrix3[2][2] = 0;
		int[][] matrix33 = new int[3][3];
		matrix33[0][0] = 1;
		matrix33[0][1] = 0;
		matrix33[0][2] = 0;	
		matrix33[1][0] = 0;
		matrix33[1][1] = 0;
		matrix33[1][2] = 0;		
		matrix33[2][0] = 0;
		matrix33[2][1] = 0;
		matrix33[2][2] = 0;
		Assert.assertArrayEquals(matrix33,Matrix.setToNull(matrix3, 3, 3));
	
		int[][] matrix4 = new int[4][3];
		matrix4[0][0] = 0;
		matrix4[0][1] = 0;
		matrix4[0][2] = 0;			
		matrix4[1][0] = 1;
		matrix4[1][1] = 2;
		matrix4[1][2] = 3;			
		matrix4[2][0] = 1;
		matrix4[2][1] = 2;
		matrix4[2][2] = 3;			
		matrix4[3][0] = 1;
		matrix4[3][1] = 2;
		matrix4[3][2] = 3;
		int[][] matrix44 = new int[4][3];
		matrix44[0][0] = 0;
		matrix44[0][1] = 0;
		matrix44[0][2] = 0;			
		matrix44[1][0] = 0;
		matrix44[1][1] = 0;
		matrix44[1][2] = 0;			
		matrix44[2][0] = 0;
		matrix44[2][1] = 0;
		matrix44[2][2] = 0;			
		matrix44[3][0] = 0;
		matrix44[3][1] = 0;
		matrix44[3][2] = 0;
		Assert.assertArrayEquals(matrix44,Matrix.setToNull(matrix4, 4, 3));	
	}
}
