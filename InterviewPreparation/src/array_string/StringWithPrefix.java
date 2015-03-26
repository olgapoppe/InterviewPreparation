package array_string;

public class StringWithPrefix {
	
	String prefix;
	String word;
	
	public StringWithPrefix(String p, String w) {
		prefix = p;
		word = w;
	}
	
	public boolean equals (Object other) {
		if (other instanceof StringWithPrefix) {
			StringWithPrefix o = (StringWithPrefix) other;
			return this.prefix.equals(o.prefix) && this.word.equals(o.word);
		} else {
			return false;
		}
	}
	
	public String toString() {
		return prefix + " : " + word;
	}
}
