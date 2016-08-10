package List;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class NListTest {
	@Test
	public void TestAdd1() {
		List<Integer> l = new NList<Integer>();
		l.add(2);
		
		assertEquals("Expected 2 from the list", new Integer(2), l.get(0));
	}
	
	@Test
	public void TestAdd2() {
		List<Integer> l = new NList<Integer>();
		for (int i = 0; i < 10; i++) {
			l.add(i + 5);
		}
		
		assertEquals("Expected 5 from the list", new Integer(5), l.get(0));
		assertEquals("Expected 10 from the list", new Integer(10), l.get(5));
		assertEquals("Expected 14 from the list", new Integer(14), l.get(9));
	}
	
	@Test
	public void TestClear() {
		List<Integer> l = new NList<Integer>();
		for (int i = 0; i < 20; i++) {
			l.add(i + 15);
		}
		
		assertEquals("Expected 25 from the list", new Integer(25), l.get(10));
		assertEquals("Expected non empty list", false, l.isEmpty());
		
		l.clear();
		
		assertEquals("Expected empty list", true, l.isEmpty());
	}
	
	@Test
	public void TestContains() {
		List<String> l = new NList<String>();
		l.add("Harry");
		l.add("Pokemon");
		
		assertEquals("Expected henry search to fail", false, l.contains("Henry"));
		assertEquals("Expected harry search to succeed", true, l.contains("Harry"));
	}
}
