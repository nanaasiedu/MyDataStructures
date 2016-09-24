package Trie;

import java.util.Collection;
import java.util.Iterator;

public class NTrie implements Collection<String> {
	private static final int ALPHABET_SIZE = 26;
	
	private NTrie[] children;
	private boolean valid;
	private int size;
	
	NTrie() {
		this.children = new NTrie[ALPHABET_SIZE];
		this.valid = false;
	}
	
	
	// O(S)
	@Override
	public boolean add(String s) {
		boolean result = insert(s, 0);
		if (result) size++;
		
		return result;
	}
	
	// pre-condition: index <= s.length() (erroneous use may hinder space complexity)
	// Inserts the string s into the trie. Operates in O(S) S: number of characters
	private boolean insert(String s, int index) {
		// Reached end of string by adding nodes for all its characters
		if (index == s.length()) {
			boolean oldValid = valid;
			valid = true;
			
			// If the oldValue was true we didnt add a new element (already exist) hence we return false
			return !oldValid;
		}
		
		// Invalid index
		if (s.length() < index || index < 0) return false;
		
		// Get current char character child
		int charIndex = (int)s.charAt(index) - (int)'a';
		NTrie nextNode = children[charIndex];
		
		if (nextNode == null) {
			nextNode = new NTrie();
			children[charIndex] = nextNode;
		}
		
		return nextNode.insert(s, index+1);
	}
	
	// Returns the largest prefix between smaller and larger 
	// Pre-condition: smaller.legnth() < larger.length
	private String longestCommonPrefix(String smaller, String larger ) {
		for (int i = 0; i < smaller.length(); i++) {
			if (smaller.charAt(i) != larger.charAt(i)) {
				if (i <= 0) {
					return "";
				}
				
				return smaller.substring(0, i-1);
			}
		}
		
		return null;
	}
	
	@Override
	public boolean addAll(Collection<? extends String> collection) {
		Iterator<? extends String> iter = collection.iterator();
		
		while(iter.hasNext()) {
			boolean result = add(iter.next());
			if (!result) return false;
		}
		
		return true;
	}

	// O(1)
	@Override
	public void clear() {
		this.children = new NTrie[ALPHABET_SIZE];
		this.valid = false;
		
	}
	
	// O(s)
	@Override
	public boolean contains(Object arg) {
	   String s;
	   try {
		   s = (String)arg;
	   } catch (ClassCastException e) {
		   return false;
	   }
		
	   return find(s, 0);
	}
	
	// Traverses through the trie checking the occurence of every character in s
	// Operates in O(s) S: number of characters in s
	private boolean find(String s, int index) {
		// Reached end of string by traversing nodes for all its characters
		if (index == s.length()) {
			return valid;
		}
				
		// Invalid index
		if (s.length() < index || index < 0) return false;
				
		// Get current char character child
		int charIndex = (int)s.charAt(index) - (int)'a';
		NTrie nextNode = children[charIndex];
				
		return (nextNode == null ? false : nextNode.find(s, index + 1));
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg) {
		   String s;
		   try {
			   s = (String)arg;
		   } catch (ClassCastException e) {
			   return false;
		   }
			
		   boolean result = delete(s, 0);
		   if (result) size--;
		   
		   return result;
	}
	
	// Traverses through the trie checking the occurence of every character in s
	// Operates in O(s) S: number of characters in s
	private boolean delete(String s, int index) {
		// Reached end of string by traversing nodes for all its characters
		if (index == s.length()) {
			boolean oldValid = valid;
			valid = false;
			return oldValid;
		}
				
		// Invalid index
		if (s.length() < index || index < 0) return false;
				
		// Get current char character child
		int charIndex = (int)s.charAt(index) - (int)'a';
		NTrie nextNode = children[charIndex];
				
		return (nextNode == null ? false : nextNode.delete(s, index + 1));
	}
	
	

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// O(1)
	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
