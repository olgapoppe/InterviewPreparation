package linked_list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class LRUcache <K,V> {
	
	HashMap <K,V> contents;
	LinkedList <K> keys;
	int max;
	
	LRUcache (HashMap <K,V> c, LinkedList <K> k, int m) {
		this.contents = c;
		this.keys = k;
		this.max = m;
	}
	
	V get(K key) {
		
		this.keys.remove(key);
		this.keys.addFirst(key);
		
		return this.contents.get(key);
	}
	
	void put (K key, V value) {
		
		if (this.contents.size()+1>this.max) this.keys.removeLast(); 		
		this.keys.addFirst(key);
		this.contents.put(key, value);
	}
	
	public boolean equals (Object other) {
		if (other instanceof LRUcache) {
			LRUcache o = (LRUcache) other;
			for (K key : keys) {
				if (!o.keys.contains(key)) return false;
			}
			Set<K> keys = contents.keySet();
			for (K key : keys) {
				if (!o.contents.containsKey(key) || !this.contents.get(key).equals(o.contents.get(key))) return false;
			}
			return true;
		} else {
			return false;
		}
	}
}
