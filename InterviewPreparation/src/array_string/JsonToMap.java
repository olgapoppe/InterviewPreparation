package array_string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonToMap {
	
	public static void main (String [] args) {
		 
		String s = "{ \"customer\" : { \"id\": \"123\", \"name\": \"abc\" } }";
		
		Map<String,String> result = jsonToMap(s);
	}
	
	public static Map<String,String> jsonToMap(String t) { 
		
		HashMap<String,String> result = new HashMap<String,String>();
		
		try {
			JSONObject jObj = new JSONObject(t);
			Iterator<?> keys = jObj.keys();

			while( keys.hasNext() ) {
				String key = (String) keys.next();
				if ( jObj.get(key) instanceof JSONObject ) {   
					JSONObject value = (JSONObject) jObj.get(key);
					String s = value.toString();
					result.put(key, s);	
					System.out.println(key + "," + s + "\n");
			}}
		} catch (JSONException e) {
			  e.printStackTrace();
		}	
		return result;
	}

}
