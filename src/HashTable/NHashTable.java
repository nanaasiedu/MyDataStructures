package HashTable;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import List.*;

public class NHashTable<K,V> implements Map<K, V> {
	
	private static final double DEFAULT_LOAD_FACTOR =  0.75; //Java HashMap default value 
	private static final int DEFAULT_CAPACITY = 16;    //Java HashMap default value 
	
	private double load_factor;
	private int capacity;
	private int size;
	private int numBuckets;
	private NList<Map.Entry<K, V>>[] buckets;
	
	// CONSTRUCTORS ========
	
	NHashTable() {
		this.load_factor = DEFAULT_LOAD_FACTOR;
		this.capacity = DEFAULT_CAPACITY;
		initialSetup();
	}
	
	NHashTable(int capacity) {
		this.load_factor = DEFAULT_LOAD_FACTOR;
		this.capacity = capacity;
		initialSetup();
	}
	
	NHashTable(int capacity, double load_factor) {
		this.load_factor = load_factor;
		this.capacity = capacity;
		initialSetup();
	}
	
	// Initialises the fields 
	private void initialSetup() {
		size = 0;
		buckets = (NList<Map.Entry<K, V>>[]) Array.newInstance(NList.class, capacity);
		numBuckets = 0;
	}
	
	// PUBLIC METHODS =====
	
	@Override
	public void clear() {
		initialSetup();
	}

	@Override
	public boolean containsKey(Object keyObj) {
		K key = (K)keyObj;
		
		int index = key.hashCode() % capacity;		
		NList<Map.Entry<K, V>> list = buckets[index];
		
		if (list == null) {
			return false;
		}
		
		for (Map.Entry<K, V> entry : list) {
			if (entry.getKey().equals(key)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsValue(Object valueObj) {
		V value = (V)valueObj;
		
		for (int i = 0; i < capacity; i++) {
			List<Map.Entry<K, V>> list = buckets[i];
			
			for (Map.Entry<K, V> entry : list) {
				if (entry.getValue().equals(value)){
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object keyObj) {
		K key = (K)keyObj;
	
		int index = key.hashCode() % capacity;		
		List<Map.Entry<K, V>> list = buckets[index];
		
		if (list == null) {
			return null;
		}

		for (Map.Entry<K, V> entry : list) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % capacity;
		V oldValue = null;
		
		List<Map.Entry<K, V>> list = buckets[index];
		
		if (list == null) {
			buckets[index] = new NList<Map.Entry<K, V>>();
			numBuckets++;
			
			Map.Entry<K, V> newEntry = new AbstractMap.SimpleEntry<K,V>(key, value);
			buckets[index].add(newEntry);
			size++;
			
			return oldValue;
		}
		
		ListIterator<Map.Entry<K, V>> iter = list.listIterator();
		
		while (iter.hasNext()) {
			Map.Entry<K, V> entry = iter.next();
			
			if (entry.getKey().equals(key)) {
				oldValue = entry.getValue();
				entry.setValue(value);
				return oldValue;
			}
		}
		
		Map.Entry<K, V> newEntry = new AbstractMap.SimpleEntry<K,V>(key, value);
		list.add(0, newEntry);
		size++;
		
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object keyObj) {
		K key = (K)keyObj;
		
		int index = key.hashCode() % capacity;		
		NList<Map.Entry<K, V>> list = buckets[index];
		
		if (list == null) {
			return null;
		}
		
		ListIterator<Map.Entry<K, V>> iter = list.listIterator();
		
		while (iter.hasNext()) {
			Map.Entry<K, V> entry = iter.next();
			
			if (entry.getKey().equals(key)) {
				V removedValue = entry.getValue();
				iter.previous();
				iter.remove();
				size--;
				return removedValue;
			}
		}
		
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// PRIVATE METHODS
	
	// Returns table's current load factor
	private int loadFactor() {
		return numBuckets / capacity;
	}
	
	// Return true iff the table needs to be expanded as the load factor capacity has been exceeded
	private boolean tableOverload() {
		return loadFactor() >= DEFAULT_LOAD_FACTOR;
	}
}
