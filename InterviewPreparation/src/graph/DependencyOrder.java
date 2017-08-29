package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class DependencyOrder {
	
	public static void main (String [] args) {
		
		// (b,c) (c,d) (a,b) (d,e) (e,c) (f,g)
		Entry a = new Entry("a");
		Entry b = new Entry("b");
		Entry c = new Entry("c");
		Entry d = new Entry("d");
		Entry e = new Entry("e");
		Entry f = new Entry("f");
		Entry g = new Entry("g");
		Dependency a1 = new Dependency (a,new ArrayList<Dependency>());
		Dependency b1 = new Dependency (b,new ArrayList<Dependency>());
		Dependency c1 = new Dependency (c,new ArrayList<Dependency>());
		Dependency d1 = new Dependency (d,new ArrayList<Dependency>());
		Dependency e1 = new Dependency (e,new ArrayList<Dependency>());
		Dependency f1 = new Dependency (f,new ArrayList<Dependency>());
		Dependency g1 = new Dependency (g,new ArrayList<Dependency>());
		b1.following.add(c1);
		c1.following.add(d1);
		a1.following.add(b1);
		d1.following.add(e1);
		e1.following.add(c1);
		f1.following.add(g1);
		Vector<Dependency> edges = new Vector<Dependency>();
		edges.add(a1);
		edges.add(b1);
		edges.add(c1);
		edges.add(d1);
		edges.add(e1);
		edges.add(f1);
		edges.add(g1);
		String result = getDependencyOrder(edges);
		System.out.println(result);
	}
	
	public static String getDependencyOrder (Vector<Dependency> edges) {
		
		// build the graph, find start nodes
		HashMap<Entry,ArrayList<Dependency>> graph = new HashMap<Entry,ArrayList<Dependency>>();
		for (Dependency d : edges) {
			for (Dependency d1 : d.following) { 
				d1.entry.start = false;
			}
			graph.put(d.entry, d.following);						
		}
		
		// traverse the graph from start nodes
		String result = "";
		String intermediate = "";
		Set<Entry> entries = graph.keySet();
		for (Entry entry : entries) {
			if (entry.start) {
				intermediate += " " + entry.name;
				ArrayList<Dependency> dependencies = graph.get(entry);
				while (!dependencies.isEmpty()) {
					ArrayList<Dependency> nextLevel = new ArrayList<Dependency>();
					for (Dependency d : dependencies) {
						if (!d.entry.visited) {
							nextLevel.addAll(d.following);
							d.entry.visited = true;
							intermediate += " " + d.entry.name;
						} else {
							intermediate = "";
							nextLevel.clear();
							break;
						}
					}
					dependencies = nextLevel;
				}
				result += intermediate;
			}			
		}		
		return result;		
	}	
}
