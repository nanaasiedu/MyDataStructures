package Stack;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import List.NList;


public class MinStackTest {
	@Test
	public void TestPush1() {
		MinStack<Integer> stack = new MinStack<Integer>();
		
		stack.push(1);
		
		assertEquals("Expected 1", new Integer(1), stack.peek());
	}
	
	@Test 
	public void TestPushPop() {
		MinStack<Integer> stack = new MinStack<Integer>();
		
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		assertEquals("Expected 9", new Integer(9), stack.peek());
		
		for (int i = 9; i > 5; i--) {
			assertEquals("Expected " + i, new Integer(i), stack.pop());
		}
		
		assertEquals("Expected 5", new Integer(5), stack.peek());
	}
	
	@Test 
	public void min1() {
		MinStack<Integer> stack = new MinStack<Integer>();
		
        stack.push(6);
        assertEquals("Expected 6", new Integer(6), stack.getMin());
        assertEquals("Expected 6", new Integer(6), stack.pop());
        assertEquals("Expected null", null, stack.getMin());
	}
	
	@Test 
	public void multiMin() {
		MinStack<Integer> stack = new MinStack<Integer>();
		
        stack.push(7);
        stack.push(10);
        stack.push(20);
        stack.push(2);
        stack.push(4);
        stack.push(2);
        
        assertEquals("Expected 2", new Integer(2), stack.getMin());
        stack.pop();
        assertEquals("Expected 2", new Integer(2), stack.getMin());
        stack.pop();stack.pop();
        assertEquals("Expected 2", new Integer(7), stack.getMin());
        stack.push(4); stack.push(7);
        assertEquals("Expected 4", new Integer(4), stack.getMin());
	}
}
