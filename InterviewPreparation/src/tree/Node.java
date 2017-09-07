package tree;

public class Node {
	
	String name;
	Node left;
	Node right;
	boolean visited;
	int level;
	int distance;
	
	public Node (String n, Node l, Node r) {
		name = n;
		left = l;
		right = r;	
		visited = false;
		level = 1;
	}
	
	public boolean isLeaf() {
		return left==null && right==null;
	}
	
	public String toString() {
		return name;
	}
	
	public int getValue () {
		return Integer.parseInt(name);
	}
	
	public void setDistance (int d) {
		distance = d;
	}
}
