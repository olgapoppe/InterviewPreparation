package graph;

import java.util.ArrayList;

public class Dependency {
	
	Entry entry;
	ArrayList<Dependency> following;
	
	public Dependency (Entry e, ArrayList<Dependency> f) {
		entry = e;
		following = f;
	}
}
