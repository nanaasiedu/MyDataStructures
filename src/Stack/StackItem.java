package Stack;

public class StackItem<T> {
	private T item;
	private StackItem<T> next;
	
	StackItem (T item, StackItem<T> next) {
		this.item = item;
		this.next = next;
	}
	
	public T getItem() {
		return item;
	}
	
	public void setNext(StackItem<T> next) {
		this.next = next;
	}
	
	public StackItem<T> getNext() {
		return next;
	}
}
