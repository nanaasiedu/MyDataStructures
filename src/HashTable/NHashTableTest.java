package HashTable;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import List.NList;

public class NHashTableTest {
	@Test
	public void TestAdd1() {
		Map<String, Integer> ages = new NHashTable<String, Integer>();
		
		assertEquals("Expected empty", new Boolean(true), ages.isEmpty());
		assertEquals("Expected empty", new Integer(0), new Integer(ages.size()));
		assertEquals("Expected no such key", new Boolean(false), ages.containsKey("Nana"));
		ages.put("Nana", 20);
		assertEquals("Expected key Nana", new Boolean(true), ages.containsKey("Nana"));
		ages.put("Abina", 6);
		assertEquals("Expected 2 elements", new Integer(2), new Integer(ages.size()));
		assertEquals("Expected 20 for Nana", new Integer(20), ages.get("Nana"));
	}
	
	@Test
	public void TestAddRemove() {
		int NUM_ELEMENTS = 10000; //524287 + 1 causes perculiar error
		Map<Double, Integer> ht = new NHashTable<Double, Integer>(); // TRY TESTING WITH DIFF BUCKET SIZES
		// capacity should be much longer than 100000
		
		assertEquals("Expected empty", new Boolean(true), ht.isEmpty());
		assertEquals("Expected empty", new Integer(0), new Integer(ht.size()));
		
		for (double i = 0.5; i < NUM_ELEMENTS; i++) {
			ht.put(new Double(i), new Integer((int)i));
		}
		
		assertEquals("Expected key 501.5", new Boolean(true), ht.containsKey(501.5));
		
		assertEquals("Expected " + NUM_ELEMENTS + " numbers", new Integer(NUM_ELEMENTS), new Integer(ht.size()));
		assertEquals("Expected 50 for 50.5", new Integer(50), ht.get(50.5));
		assertEquals("Expected 401 for 401.5", new Integer(401), ht.get(401.5));
		ht.put(1000.5, 0);
		assertEquals("Expected removed value of 501", new Integer(501), ht.remove(501.5));
		assertEquals("Unexpected key 501.5", new Boolean(false), ht.containsKey(501.5));
		assertEquals("Expected " + (NUM_ELEMENTS - 1) + " numbers", new Integer(NUM_ELEMENTS-1), new Integer(ht.size()));
		assertEquals("Expected new value of 0", new Integer(0), ht.get(1000.5));
		
		ht.clear();
		assertEquals("Expected empty", new Boolean(true), ht.isEmpty());
		assertEquals("Expected empty", new Integer(0), new Integer(ht.size()));
		assertEquals("Expected null", null, ht.get(50));
		assertEquals("Expected null", null, ht.get(401));
		
	}

	@Test
	public void TestExceptions() {
		Map<Character, Long> ht = new NHashTable<Character, Long>();
		
		ht.put('a', 2000200340000000000l);
		ht.put('b', 50000000000000l);
		
		assertEquals("Expected null", null, ht.get(new Integer(2)));
		assertEquals("Expected false", new Boolean(false), ht.containsKey(new String("Hello")));
		assertEquals("Expected null", null, ht.remove(new Boolean(true)));
	}
}
