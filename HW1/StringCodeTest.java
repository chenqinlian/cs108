import static org.junit.Assert.*;

import org.junit.Test;


public class StringCodeTest {

    /*
     * Reference
     * https://github.com/varren/cs108/blob/master/hw1/StringCodeTest.java
     */	
	
	@Test
	public void testblowup() {
		assertEquals("attttxzzz",StringCode.blowup("a3tx2z"));
		assertEquals("2xxx",StringCode.blowup("12x"));		
	}
	
	@Test
	public void testmaxRun() {
		assertEquals(3,StringCode.maxRun("xxyyyz"));
		assertEquals(1,StringCode.maxRun("xyz"));	
	}
	
    @Test
    public void testIntersect() {
        assertTrue(StringCode.stringIntersect("12", "12", 2));
        assertTrue(StringCode.stringIntersect("123", "123", 2));
        assertTrue(StringCode.stringIntersect("1234", "1234", 0));
        assertFalse(StringCode.stringIntersect("1234", "1234", 5));
    }

    
}
