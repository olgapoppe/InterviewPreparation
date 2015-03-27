package linked_list;

import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;
import org.junit.Test;

public class LRUcacheTest {

	@Test
	public void testput() {
		
		LRUcache <String,String> cache4strings = new LRUcache <String,String> (new HashMap<String,String>(), new LinkedList<String>(), 3);
		cache4strings.put("1", "1");		
		cache4strings.put("2", "2");		
		cache4strings.put("3", "3");		
		cache4strings.put("4", "4");	
		LRUcache <String,String> cache4strings2 = new LRUcache <String,String> (new HashMap<String,String>(), new LinkedList<String>(), 3);
		cache4strings2.keys.add("2");
		cache4strings2.keys.add("3");
		cache4strings2.keys.add("4");
		cache4strings2.contents.put("1","1");
		cache4strings2.contents.put("2","2");
		cache4strings2.contents.put("3","3");
		cache4strings2.contents.put("4","4");
		Assert.assertEquals(cache4strings2, cache4strings);	
	}
}
