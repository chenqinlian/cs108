// TabooTest.java
// Taboo class tests -- nothing provided.

import java.util.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TabooTest extends TestCase {

	/*
	 *	Copy from https://github.com/varren/cs108/blob/master/hw1/TabooTest.java
	 *
	 */
	
    public void noFollowBasicTest() {
        List<String> list = Arrays.asList("a", "c", "a", "b", null, "k", "p");
        Taboo<String> taboo = new Taboo<String>(list);

        Set<String> testSet1 = new HashSet<String>(Arrays.asList("c", "b"));
        assertTrue(testSet1.equals(taboo.noFollow("a")));

        Set<String> testSet2 = new HashSet<String>(Arrays.asList("a"));
        assertTrue(testSet2.equals(taboo.noFollow("c")));

        Set<String> testSet3 = new HashSet<String>();
        assertTrue(testSet3.equals(taboo.noFollow("x")));

        Set<String> testSet4 = new HashSet<String>(Arrays.asList("a"));
        assertFalse(testSet4.equals(taboo.noFollow("cd")));

    }

    public void reduceBasicTest() {
        List<String> list = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<String>(list);

        List<String> reducedList = new ArrayList<String>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        taboo.reduce(reducedList);
        List<String> resultList = new ArrayList<String>(Arrays.asList("a", "x", "c"));
        assertTrue(resultList.equals(reducedList));
    }

     public void reduceAdvancedTest() {
        List<String> list = Arrays.asList("a", "a");
        Taboo<String> taboo = new Taboo<String>(list);

        List<String> reducedList = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
        taboo.reduce(reducedList);

        List<String> resultList = new ArrayList<String>(Arrays.asList("a"));
        assertTrue(resultList.equals(reducedList));

    }

    public void reduceAdvancedTest2() {
        List<String> list = Arrays.asList("a");
        Taboo<String> taboo = new Taboo<String>(list);

        List<String> reducedList = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
        taboo.reduce(reducedList);

        List<String> resultList = new ArrayList<String>(Arrays.asList("a", "a", "a", "a"));
        assertTrue(resultList.equals(reducedList));
    }

    public void testReduceEdge() {
        List<String> rules1 = Arrays.asList("");
        Taboo<String> t1 = new Taboo<String>(rules1);

        List<String> a = Arrays.asList("");
        t1.reduce(a);
        assertTrue(a.equals(Arrays.asList("")));
    }    
    
}
