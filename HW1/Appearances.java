import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	

	public static <T> int sameCount(Collection<T> a, Collection<T> b) {

		// build 2 hashmap for Collection<T> a,b
		HashMap<T, Integer> aHash = new HashMap<>();
		HashMap<T, Integer> bHash = new HashMap<>();
		
		calculateAppearance(a, aHash);
		calculateAppearance(b, bHash);

		//judge whether equals
		int result = 0;
		for(T element: aHash.keySet()){
			if(bHash.containsKey(element) && aHash.get(element).equals(bHash.get(element))){
				result++;
			}
		}
		
		return result; // YOUR CODE HERE
	}
	
	private static <T> void calculateAppearance(Collection<T> Col, HashMap<T, Integer> mapping){

		for(T element: Col){
			if(mapping.containsKey(element)){
				mapping.put(element,mapping.get(element)+1);
			}
			else{
				mapping.put(element,1);
			}
		}
	}

	
	
}
