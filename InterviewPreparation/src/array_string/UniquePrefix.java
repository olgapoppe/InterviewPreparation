package array_string;

import java.util.ArrayList;

public class UniquePrefix {
	
	/**
	 * Determine whether the given prefix is a unique prefix of all words in the list
	 * @param prefix	
	 * @param index		index of the word in the list which is not considered
	 * @param list		list of words
	 * @return			boolean
	 */
	public static boolean uniquePrefix (String prefix, int index, ArrayList<String> list) {
		for (String s : list) {
			if (list.indexOf(s)!=index && s.startsWith(prefix)) {
				return false;
		}}
		return true;
	}
	
	/**
	 * Return a unique prefix for a given word in the list
	 * @param word		word for which the unique prefix is computed		
	 * @param index		index of this word in the list
	 * @param input		list of words
	 * @return			unique prefix of the word
	 */
	public static String getUniquePrefix (String word, int index, ArrayList<String> input) {
		String prefix = "";
		for (int i=0; i<=word.length(); i++) {
			String potential_prefix = word.substring(0, i);
			if (uniquePrefix(potential_prefix, index, input)) {
				prefix = potential_prefix;
				break;
		}}
		return prefix;
	}
	
	/**
	 * Generate unique prefixes for every word in the list
	 * @param input	list of words
	 * @return		list of words with unique prefixes
	 */
	public static ArrayList<StringWithPrefix> getUniquePrefixes (ArrayList<String> input) {
		
		ArrayList<StringWithPrefix> output = new ArrayList<StringWithPrefix>();		
		
		for (String word : input) {		
			
			int index = input.indexOf(word);
			String prefix = getUniquePrefix(word, index, input);	
			output.add(new StringWithPrefix(prefix, word));						
		}
		return output;
	}
}
