package List;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ListIterator;

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
	public void TestAddSize3() {
		List<Integer> l = new NList<Integer>();
		
		assertEquals("Expected size of 0", 0, l.size());
		
		for (int i = 0; i < 3; i++) {
			l.add(i*2 + 5);
		}
		
		assertEquals("Expected size of 3", 3, l.size());
		assertEquals("Expected 5 from the list", new Integer(5), l.get(0));
		assertEquals("Expected 7 from the list", new Integer(7), l.get(1));
		assertEquals("Expected 9 from the list", new Integer(9), l.get(2));
		
		l.add(0, 1);
		l.add(1, 2);
		// 2: 5
		l.add(3, 6);
		// 4: 7
		l.add(5, 8);
		// 6: 9
		
		assertEquals("Expected size of 7", 7, l.size());
		assertEquals("Expected 1 from the list", new Integer(1), l.get(0));
		assertEquals("Expected 5 from the list", new Integer(5), l.get(2));
		assertEquals("Expected 7 from the list", new Integer(7), l.get(4));
		assertEquals("Expected 9 from the list", new Integer(9), l.get(6));
	}
	
	@Test
	public void TestClear() {
		List<Integer> l = new NList<Integer>();
		for (int i = 0; i < 20; i++) {
			l.add(i + 15);
		}
		
		assertEquals("Expected size of 20", l.size(), 20);
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
	
	@Test
	public void IteratorTest() {
		List<Character> l = new NList<Character>();
		
		for (int i = 65; i < 91; i++) {
			l.add((char)i);
		}
		
		assertEquals("Expected 26 letters", l.size(), 26);
		
		ListIterator<Character> iter = l.listIterator();
		
		assertEquals("Expected next index 1", iter.nextIndex(), 1);
		assertEquals("Expected 'A'", iter.next(), new Character('A'));
		assertEquals("Expected 'B'", iter.next(), new Character('B'));
		assertEquals("Expected next index 1", iter.previousIndex(), 1);
		assertEquals("Expected 'B'", iter.previous(), new Character('B'));
		
		int i = 0;
		for (Character c : l) {
			assertEquals("character loop fail", c, new Character((char)(65+i)));
			i++;
		}
	}
	
	@Test
	public void IteratorTest2() {
		List<Boolean> l = new NList<Boolean>();
		
		for (int i = 0; i < 10; i++) {
			l.add(i % 2 == 0);
		}
		
		assertEquals("Expected 10 bools", l.size(), 10);
		
		ListIterator<Boolean> iter = l.listIterator();
		
		assertEquals("Expected next index 1", iter.nextIndex(), 1);
		assertEquals("Expected 0 is even", iter.next(), new Boolean(true));
		assertEquals("Expected 1 is odd", iter.next(), new Boolean(false));
		iter.remove(); // remove 2 
		iter.remove(); // remove 3
		assertEquals("Expected 4 is even", iter.next(), new Boolean(true));
		iter.add(55 % 2 == 0);
		assertEquals("Expected 5 is even", iter.next(), new Boolean(false));
		assertEquals("Expected 55 is even", iter.next(), new Boolean(false));
		assertEquals("Expected 6 is even", iter.next(), new Boolean(true));
		iter.set(true); // change 7 % 2 == 0 to false
		assertEquals("Expected 7 is erronesously even", iter.next(), new Boolean(true));
		
		
	}
}
