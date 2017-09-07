package tree;

import java.util.ArrayList;
import java.util.Stack;

public class ClosestLeaf {
	
	public static void main (String [] args) {
		
		Node seven = new Node("7", null, null);
		Node nine = new Node("9", null, null);
		Node eight = new Node("8", seven, nine);
				
		Node eleven = new Node("11", null, null);
		Node thirteen = new Node("13", null, null);
		Node twelve = new Node("12", eleven, thirteen);
				
		Node ten = new Node("10", eight, twelve);
		
		Node sixteen = new Node("16", null, null);
		Node fourteen = new Node("14", ten, sixteen);
		
		Node closest = findClosestNode(fourteen,ten);
		System.out.println(closest.toString() + " " + closest.distance);
	}
	
	public static ArrayList<Node> walkInOrder (Node root) {
		
		ArrayList<Node> root_subtree = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.isLeaf() || current.visited) {
				current.visited = false;
				root_subtree.add(current);
			} else {
				current.visited = true;
				if (current.right != null) {
					current.right.level = current.level+1;
					stack.push(current.right);
				}
				stack.push(current);
				if (current.left != null) {
					current.left.level = current.level+1;
					stack.push(current.left);
				}
			} 
		}
		return root_subtree;			
	}
	
	public static Node nextSmallest (Node root, Node target) {
		
		ArrayList<Node> root_subtree = walkInOrder(root);
		int i = root_subtree.indexOf(target);
		return root_subtree.get(i-1);	
	}
	
	public static Node nextLargest (Node root, Node target) {
		
		ArrayList<Node> root_subtree = walkInOrder(root);
		int i = root_subtree.indexOf(target);
		return root_subtree.get(i+1);	
	}
	
	public static Node findClosestNodeInSubtree (Node target) {
		
		ArrayList<Node> target_subtree = walkInOrder(target);
		int min_distance = Integer.MAX_VALUE;
		Node min_node = new Node("0",null,null);
		
		for (Node node : target_subtree) {
			int distance = node.level-target.level;
			if (node.isLeaf() && min_distance>distance) {
				node.distance = distance;
				min_distance = distance;
				min_node = node;				
			}
		}
		return min_node;		
	} 
	
	public static ArrayList<Node> getAncestors (Node root, Node target) {
		
		ArrayList<Node> ancestors = new ArrayList<Node>();
		ancestors.add(root); 
				
		Node node = root;
		int level = 1;
		while (node!=target) {
			if (target.getValue()>node.getValue() && node.right!=null) {
				node = node.right;
				node.level = level+1;
			}
			if (target.getValue()<node.getValue() && node.left!=null) {
				node = node.left;
				node.level = level+1;
			}
			ancestors.add(node); 
			level++;
		}		
		return ancestors;
	}
	
	public static Node findClosestNode (Node root, Node target) {
		
		ArrayList<Node> ancestors = getAncestors(root,target);
		System.out.println(ancestors.toString());
		
		int min_distance = Integer.MAX_VALUE;
		Node closest_node = new Node("0",null,null);
		
		for (Node ancestor : ancestors) {
			int targetToAncestor = target.level - ancestor.level;
			Node node = findClosestNodeInSubtree(ancestor);
			int nodeToAncestor = node.distance;
			int distance = targetToAncestor + nodeToAncestor;
			if (distance < min_distance) {
				node.distance = distance;
				min_distance = distance;	
				closest_node = node;				
			}
		}
		return closest_node;
	}

}
