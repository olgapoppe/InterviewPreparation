package tree;

public class Node {
	
	String name;
	Node left;
	Node right;
	
	public Node (String n, Node l, Node r) {
		name = n;
		left = l;
		right = r;	
	}
	
	public boolean isLeaf() {
		return left==null && right==null;
	}
}
