package List;

public class ListItem<T> {
	private T item;
	private ListItem<T> nextItem;
	private ListItem<T> prevItem;
	
	ListItem() {}
	
	ListItem(T item , ListItem<T> prevItem, ListItem<T> nextItem) {
		this.item = item;
		this.nextItem = nextItem;
		this.prevItem = prevItem;
	}
	
	// Returns item after current item (if one exist)
	public ListItem<T> next() {
		return nextItem;
	}
	
	// Returns item before current item (if one exist)
	public ListItem<T> prev() {
		return prevItem;
	}
	
	// Return true iff item is a header for a list
	public boolean isHeader() {
		return prevItem == null;
	}
	
	// Return true iff item is a header for a list
	public boolean isFooter() {
		return nextItem == null;
	}
	
	// Links item to prevItem
	public void addPrev(ListItem<T> item) {
		prevItem = item;
	}
	
	// Links item to nextItem
	public void addNext(ListItem<T> item) {
		nextItem = item;
	}
	
	// Returns item value
	public T val() {
		return item;
	}
	
	// Sets the item value
	public void setVal(T item) {
		this.item = item;
	}
	
}
