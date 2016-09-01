package HashTable;

import static org.junit.Assert.assertEquals;

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
		ages.put("Nana", 20);
		ages.put("Abina", 6);
		assertEquals("Expected empty", new Integer(2), new Integer(ages.size()));
		
		assertEquals("Expected 20 for Nana", new Integer(20), ages.get("Nana"));
	}
	
	@Test
	public void TestAddRemove() {
		Map<Double, Integer> ht = new NHashTable<Double, Integer>(341); // TRY TESTING WITH DIFF BUCKET SIZES
		// capacity should be much longer than 100000
		
		assertEquals("Expected empty", new Boolean(true), ht.isEmpty());
		assertEquals("Expected empty", new Integer(0), new Integer(ht.size()));
		
		for (double i = 0.5; i < 100000; i++) {
			ht.put(new Double(i), new Integer((int)i));
		}
		
		assertEquals("Expected 100000 numbers", new Integer(100000), new Integer(ht.size()));
		assertEquals("Expected 50 for 50.5", new Integer(50), ht.get(50.5));
		assertEquals("Expected 401 for 401.5", new Integer(401), ht.get(401.5));
		ht.put(1000.5, 0);
		assertEquals("Expected removed value of 501", new Integer(501), ht.remove(501.5));
		assertEquals("Expected null as 501 is removed", null, ht.get(501.5));
		assertEquals("Expected 100000 numbers", new Integer(99999), new Integer(ht.size()));
		assertEquals("Expected new value of 0", new Integer(0), ht.get(1000.5));
		
		ht.clear();
		assertEquals("Expected empty", new Boolean(true), ht.isEmpty());
		assertEquals("Expected empty", new Integer(0), new Integer(ht.size()));
		assertEquals("Expected null", null, ht.get(50));
		assertEquals("Expected null", null, ht.get(401));
		
	}
}
