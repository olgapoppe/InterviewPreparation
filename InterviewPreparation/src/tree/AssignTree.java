package tree;

import java.util.HashMap;
import java.util.Set;

public class AssignTree {
	
	public static void main (String[] args) {
		
		HashMap<String,Node> nodes = new HashMap<String,Node>();
		
		Node two = new Node("2", null, null);
		Node three = new Node("3", null, null);
		Node plus = new Node("+", two, three);
		nodes.put("x",plus); // 5
		
		Node five = new Node("5", null, null);
		Node four = new Node("4", null, null);
		Node minus = new Node("-", five, four);
		nodes.put("y",minus); // 1
		
		Node x = new Node("x", null, null);
		Node ten = new Node("10", null, null);
		Node mult = new Node("*", ten, x);
		nodes.put("z",mult); // 50
				
		Node z2 = new Node("z", null, null);
		Node y2 = new Node("y", null, null);
		Node one = new Node("1", null, null);
		Node mult2 = new Node("*", one, y2);
		Node minus2 = new Node("-", z2, mult2);
		
		int result = compute(minus2, nodes);
		System.out.println(result);
	}
	
	public static int compute (Node n, HashMap<String,Node> nodes) {
		
		// Iterate over all given trees and compute the values
		HashMap<String,Integer> values = new HashMap<String,Integer>();
		Set<String> keys = nodes.keySet();
		for (String key : keys) {
			Node node = nodes.get(key);
			int value = compute2(node,values);		
			values.put(key, value);
		}
		// Plug in these values into the tree n
		return compute2(n,values);		
	}
	
	public static int compute2 (Node n, HashMap<String,Integer> values) {
		
		// Base case: n is a leaf
		if (n.isLeaf()) {
			if (isNumeric(n.name)) { 
				return Integer.parseInt(n.name);
			} else {
				return values.get(n.name);
			}
		}
		
		// Recursive case: traverse the tree
		switch (n.name) {
			case "+" : return compute2(n.left,values) + compute2(n.right,values);
			case "-" : return compute2(n.left,values) - compute2(n.right,values);
			default : return compute2(n.left,values) * compute2(n.right,values);
		}				
	}
	
	public static boolean isNumeric(String str) {  
	  try  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe) {  
	    return false;  
	  }  
	  return true;  
	}
}
