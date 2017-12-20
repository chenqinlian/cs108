
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	
	HashMap<T, HashSet<T>> mapping;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		
		mapping = new HashMap<>();
		
		for(int i=0; i<rules.size()-1;i++){
			
			T curElement = rules.get(i);
			T nextElement= rules.get(i+1);
			
			//get candidates
			HashSet<T> candidates = new HashSet<>();
			if(mapping.containsKey(curElement)){
				candidates = mapping.get(curElement);
			}
			candidates.add(nextElement);

			//put curElement- candidates
			mapping.put(curElement, candidates);
		}

	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		return mapping.get(elem); // YOUR CODE HERE
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {

		if(list.isEmpty()){
			return;
		}
		
		
		T prevElem = list.get(0);
		List<T> res = new ArrayList<>();
		res.add(prevElem);
		
		for(int i=1; i<list.size(); i++){
			
			T curElem = list.get(i);
			
			if(mapping.get(prevElem).contains(curElem)){
				System.out.println(mapping.get(prevElem).contains(curElem));
				continue;
			}
			
			res.add(curElem);
			prevElem = curElem;
		}
		
		list = new ArrayList<>(res);
		System.out.println(res);
	}
	
	
	
	public static void main(String[] args){
        List<String> list = Arrays.asList("a", "c", "b","x", "c", "a");
        Taboo<String> t= new Taboo(list);
        t.reduce(list);
        System.out.println(list);
	}
}
