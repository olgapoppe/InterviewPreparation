package linked_list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class Duplicate {
	
	/**
	 * Remove duplicates from an unsorted linked list without an additional data structure
	 * @param list with duplicates
	 * @return list without duplicates 
	 */
	public static LinkedList<Integer> removeDuplicates1 (LinkedList<Integer> list) {
		HashMap<Integer,Integer> numberOfOccurrencies = new HashMap<Integer,Integer>();
		Vector<Integer> duplicates = new Vector<Integer>();
		for (Integer i : list) {
			if (numberOfOccurrencies.containsKey(i)) {
				duplicates.add(i);
				Integer old_value = numberOfOccurrencies.get(i);
				numberOfOccurrencies.put(i, old_value+1);
			} else {
				numberOfOccurrencies.put(i, i);
		}}
		for (Integer d : duplicates) {			
			list.removeLastOccurrence(d);			
		}
		return list;
	}
	// Time complexity is at most list.size^2
	
	/**
	 * Remove duplicates from an unsorted linked list without an additional data structure
	 * @param list with duplicates
	 * @return list without duplicates 
	 */
	public static LinkedList<Integer> removeDuplicates2 (LinkedList<Integer> list) {
		for (int i=0; i<list.size(); i++) {
			Integer element = list.get(i);
			int first = list.indexOf(element); 
			int last = list.lastIndexOf(element); 
			while (first != last) {
				list.removeLastOccurrence(element);
				last = list.lastIndexOf(element); 
		}}
		return list;
	}
	// Time complexity is exactly (2*list.size)*list.size
	
	public static void print (LinkedList<Integer> list) {
		for (Integer i : list) {
			System.out.print(i + " ");
		}	
		System.out.println();
	}
}