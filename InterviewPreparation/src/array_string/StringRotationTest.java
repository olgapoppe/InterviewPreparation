package array_string;

import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {

	@Test
	public void testleftrotate1() {
		String[] input = new String [10];
		input[0] = "0";
		input[1] = "1";
		input[2] = "2";
		input[3] = "3";
		input[4] = "4";
		input[5] = "5";
		input[6] = "6";
		input[7] = "7";
		input[8] = "8";
		input[9] = "9";
		String[] result = new String [10];
		result[0] = "2";
		result[1] = "3";
		result[2] = "4";
		result[3] = "5";
		result[4] = "6";
		result[5] = "7";
		result[6] = "8";
		result[7] = "9";
		result[8] = "0";
		result[9] = "1";
		StringRotation.leftRotate1(input, 2);
		Assert.assertArrayEquals(result, input);	
	}

	@Test
	public void testleftrotate2() {
		String[] input = new String [10];
		input[0] = "0";
		input[1] = "1";
		input[2] = "2";
		input[3] = "3";
		input[4] = "4";
		input[5] = "5";
		input[6] = "6";
		input[7] = "7";
		input[8] = "8";
		input[9] = "9";
		String[] result = new String [10];
		result[0] = "2";
		result[1] = "3";
		result[2] = "4";
		result[3] = "5";
		result[4] = "6";
		result[5] = "7";
		result[6] = "8";
		result[7] = "9";
		result[8] = "0";
		result[9] = "1";
		StringRotation.leftRotate2(input, 2, input.length);
		Assert.assertArrayEquals(result, input);	
	}
	
	@Test
	public void testisRotation() {
		
		Assert.assertFalse(StringRotation.isRotation("wat", "water"));
			
		Assert.assertTrue(StringRotation.isRotation(" ", " "));
			
		Assert.assertTrue(StringRotation.isRotation("waterbottle", "waterbottle"));
			
		Assert.assertTrue(StringRotation.isRotation("waterbottle", "erbottlewat"));
	}
}
