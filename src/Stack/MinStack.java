package Stack;

public class MinStack<T extends Comparable<T>> {
	private StackItem<T> top;
	private StackItem<MinInfo> min;
	
	MinStack() {
		
	}
	
	public void push(T item) {
		top = new StackItem<T>(item, top);
		
		if (min == null) {
			min = new StackItem<MinInfo>(new MinInfo(top.getItem()), null);
		} else if (min.getItem().compare(top.getItem()) > 0) {
		    min = new StackItem<MinInfo>(new MinInfo(top.getItem()), min);
		} else {
			min.getItem().incLeft();
		}
	}
	
	public T getMin() {
		return min.getItem().getItem();
	}
	
	public T pop() {
		T popped = top.getItem();
		
		top = top.getNext();
		
		if (min.getItem().decLeft()) {
			min = min.getNext();
		}
		
		return popped;
	}
	
	private class MinInfo {
		private T item;
		private int itemsLeft;
		
		MinInfo(T item) {
			this.item = item;
			this.itemsLeft = 1;
		}
		
		public T getItem() {
			return item;
		}
		
		// Returns true if the current minimum item needs to be removed
		public boolean decLeft() {
			return --itemsLeft == 0;
		}
		
		public void incLeft() {
			itemsLeft++;
		}
		
		public int compare(T other) {
			return item.compareTo(other);
		} 
	} 
}
