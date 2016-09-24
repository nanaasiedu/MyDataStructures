package List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class NList<T> implements List<T> {
	private ListItem<T> header;
	private ListItem<T> footer;
	
	public NList() {
		header = new ListItem<T>();
		footer = new ListItem<T>();
		
		header.addNext(footer);
		header.addPrev(header);
	}
	
	@Override
	public boolean add(T item) {
		return linkItems(empty() ? header : end(), item, footer);
	}

	@Override
	public void add(int index, T item) {
		if (index < 0 || index >= size()) {
			return;
		}
		
		ListItem<T> oldItem = findItem(index);
		linkItems(oldItem.prev(), item, oldItem);
		
	}

	@Override
	public boolean addAll(Collection collection) {
		Iterator<T> iter = collection.iterator();
		
		while(iter.hasNext()) {
			boolean result = add(iter.next());
			if (!result) return false;
		}
		
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		header.addNext(footer);
		footer.addNext(header);
		
	}

	@Override
	public boolean contains(Object item) {
		if (empty()) return false;
		
		T a = (T)item;
		ListItem<T> curr = front();
		
		while(curr != footer) {
			if (curr.val().equals(a)) {
				return true;
			}
			
			curr = curr.next();
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int i) {
		return findItem(i).val();
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return empty();
	}

	@Override
	public Iterator iterator() {
		return listIterator();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		return new NListIterator(0);
	}

	@Override
	public ListIterator listIterator(int pos) {
		return new NListIterator(pos);
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int i) {
		ListItem<T> removedItem = findItem(i);
		
		removedItem.prev().addNext(removedItem.next());
		removedItem.next().addPrev(removedItem.prev());
		
		return removedItem.val();
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		if (empty()) {
			return 0;
		}
		
		ListItem<T> curr = front();
		int size = 0;
		
		while (curr != footer) {
			size++;
			curr = curr.next();
		}
		
		return size;
	}

	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Returns true iff the list is empty
	private boolean empty() {
		return header.next() == footer;
	}
	
	// Returns last item (null if list is empty)
	private ListItem<T> end() {
		return !empty() ? footer.prev() : null;
	}
	
	//Returns first item (null if list is empty)
	private ListItem<T> front() {
		return !empty() ? header.next() : null;
	}
	
	// Returns list item at index 
	private ListItem<T> findItem(int i) {
		if (i < 0 || i >= size()) return null;
		assert(!empty());
		
		ListItem<T> curr = front();
		int currIndex = 0;
		
		while(curr != footer) {
			if (currIndex == i) {
				return curr;
			}
			
			currIndex++;
			curr = curr.next();
		}
		
		return null;
	}
	
	// links the 3 items together (creates new list item in the middle)
	private boolean linkItems(ListItem<T> prevItem, T item, ListItem<T> nextItem) {
		ListItem<T> newItem = new ListItem<T>(item, prevItem, nextItem);
		
		prevItem.addNext(newItem);
		nextItem.addPrev(newItem);
		
		return true;
	}

	private class NListIterator implements ListIterator<T> {
		private ListItem<T> curr;
		private int index;
		
		NListIterator(int initPos) {
			curr = findItem(initPos);
			index = initPos;
		}
		
		@Override
		public void add(T item) {
			linkItems(curr, item, curr.next());
		}

		@Override
		public boolean hasNext() {
			return curr != footer;
		}

		@Override
		public boolean hasPrevious() {
			return curr.prev() != header;
		}

		@Override
		public T next() {
			index++;
			T item = curr.val();
			curr = curr.next();
			
			return item;
		}

		@Override
		public int nextIndex() {
			return index + 1;
		}

		@Override
		public T previous() {
			index--;
			curr = curr.prev();
			return curr.val();
			
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			ListItem<T> removedItem = curr;
			
			removedItem.prev().addNext(removedItem.next());
			removedItem.next().addPrev(removedItem.prev());
			
			curr = curr.next();
		}

		@Override
		public void set(T replacementItem) {
			curr.setVal(replacementItem);
		}
		
	}
}
